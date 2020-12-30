package luceneApp.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ar.ArabicAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

import luceneApp.entity.Article;

public class LuceneUtil {
    
	private static Version version;
	private static Analyzer analyzer;
	
	private static Directory directory;
	private static MaxFieldLength maxFieldLength;
	
	static {
		
		try {
			version=Version.LUCENE_30;
			 analyzer=new StandardAnalyzer(version);
			
			 directory=FSDirectory.open(new File("e:/indexDbOpt"));
			 maxFieldLength=MaxFieldLength.LIMITED;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static Version getVersion() {
		return version;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static MaxFieldLength getMaxFieldLength() {
		return maxFieldLength;
	}
	//工具类不允许new
	private LuceneUtil() {
		// TODO Auto-generated constructor stub
	}

	public static IndexWriter getIndexWriter() throws Exception {
		IndexWriter idw=new IndexWriter(getDirectory(), getAnalyzer(), getMaxFieldLength());
		return idw;
		
	}
	public static Document Javabean2Document(Object obj) throws Exception, SecurityException {
		Document document=new Document();
		Class clazz=obj.getClass();
		java.lang.reflect.Field[] refFields=clazz.getDeclaredFields();
		for(java.lang.reflect.Field f:refFields) {
			f.setAccessible(true);
			String name=f.getName();
			String mehtodname="get"+name.substring(0, 1).toUpperCase()+name.substring(1);
			Method m=clazz.getMethod(mehtodname, null);
			String value=m.invoke(obj, null).toString();
			document.add(new Field(name,value,Store.YES,Index.ANALYZED));
		}
		return document;
	}
	
	public static Object Document2JavaBean(Document document,Class clazz) throws Exception {
		      Object obj=clazz.getConstructor(null).newInstance(null);
		      java.lang.reflect.Field[] refFields=clazz.getDeclaredFields();
				for(java.lang.reflect.Field f:refFields) {
					f.setAccessible(true);
					String name=f.getName();
					String value=document.get(name);
					BeanUtils.setProperty(obj, name, value);
				}
		return obj;
	}
	
	
    //封装写入方法
	public static void WriteIndex(Object obj) throws Exception {
		Document d=LuceneUtil.Javabean2Document(obj);
		Version ver=LuceneUtil.getVersion();
		Analyzer analyzer=LuceneUtil.getAnalyzer();
		Directory dir=LuceneUtil.getDirectory();
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		//5.写入索引库
		idw.addDocument(d);
		//6.关闭
		
		idw.close();
		
	}
	
	public static void updateIndex(Article a,Term t) throws Exception{
		Document d=Javabean2Document(a);
		IndexWriter i=getIndexWriter();
		i.updateDocument(t, d);
		i.close();
		
	}
	//封装搜索方法
	public static List<luceneApp.entity.Article> SearchIndex(String keyword) throws Exception {
		 List<Article> list =new ArrayList<Article>();
		Version ver=LuceneUtil.getVersion();
		Analyzer analyzer=LuceneUtil.getAnalyzer();
		Directory dir=LuceneUtil.getDirectory();
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexSearcher idxs=new IndexSearcher(dir);
		
		//2.创建QueryParser对象
		QueryParser paser=new QueryParser(ver,"content",analyzer) ;
		//3.创建quey对象
		//String keyword="培训";
		Query qr=paser.parse(keyword);
		//4.利用IndexSearcher对象查找内容
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		//关键字高亮处理
		//格式器
		Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
		//查询内容
		Scorer scorer =new QueryScorer(qr);
		//高亮处理器
		Highlighter highlighter=new Highlighter(formatter,scorer);
		
		for(int i=0;i<tdocs.scoreDocs.length;i++) {
			//6取出封装了编号和分数的ScoreDoc对象
		    ScoreDoc sdoc=tdocs.scoreDocs[i];
		    //7取出编号
		    int no=sdoc.doc;
		    //IndexSearcher根据编号去索引库中查找文档duix
		    
		    Document d=idxs.doc(no);
		    //返回高亮处理结果
		    String highlighted=highlighter.getBestFragment(analyzer, "content", d.get("content"));
		    String highlightitle=highlighter.getBestFragment(analyzer, "title", d.get("title"));
		    //将高亮结果重新设置回文档对象
		    d.getField("content").setValue(highlighted);
		    d.getField("title").setValue(highlightitle);
		    
		  //8创建JavaBean对象
		    Article a =new Article();
		    //取出文档对象的每一个属性封装到JavaBean中
		    a=(Article) LuceneUtil.Document2JavaBean(d,Article.class);
		    
		   list.add(a) ;
		   
		}
		return list;
		 
		
	}
	
public static void deleteIndex(Term t) throws IOException, Exception {
		 
		IndexWriter idw=LuceneUtil.getIndexWriter();
		idw.deleteDocuments(t);
		idw.close();
		
	}

public static void deleteAllIndex() throws IOException, Exception {
	 
	IndexWriter idw=LuceneUtil.getIndexWriter();
	idw.deleteAll();
	idw.close();
	
}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          Article a=new Article();
          a.setId(1);
          a.setTitle("培训");
          a.setContent("kenny.com不是一家培训机构");
         Document d=LuceneUtil.Javabean2Document(a);
//          System.out.println(d.get("id"));
//          System.out.println(d.get("title"));
//          System.out.println(d.get("content"));
         Article article=(Article) LuceneUtil.Document2JavaBean(d, Article.class);
         System.out.println(article);
          
	}

}
