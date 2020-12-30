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
	//�����಻����new
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
	
	
    //��װд�뷽��
	public static void WriteIndex(Object obj) throws Exception {
		Document d=LuceneUtil.Javabean2Document(obj);
		Version ver=LuceneUtil.getVersion();
		Analyzer analyzer=LuceneUtil.getAnalyzer();
		Directory dir=LuceneUtil.getDirectory();
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		//5.д��������
		idw.addDocument(d);
		//6.�ر�
		
		idw.close();
		
	}
	
	public static void updateIndex(Article a,Term t) throws Exception{
		Document d=Javabean2Document(a);
		IndexWriter i=getIndexWriter();
		i.updateDocument(t, d);
		i.close();
		
	}
	//��װ��������
	public static List<luceneApp.entity.Article> SearchIndex(String keyword) throws Exception {
		 List<Article> list =new ArrayList<Article>();
		Version ver=LuceneUtil.getVersion();
		Analyzer analyzer=LuceneUtil.getAnalyzer();
		Directory dir=LuceneUtil.getDirectory();
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexSearcher idxs=new IndexSearcher(dir);
		
		//2.����QueryParser����
		QueryParser paser=new QueryParser(ver,"content",analyzer) ;
		//3.����quey����
		//String keyword="��ѵ";
		Query qr=paser.parse(keyword);
		//4.����IndexSearcher�����������
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		//�ؼ��ָ�������
		//��ʽ��
		Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
		//��ѯ����
		Scorer scorer =new QueryScorer(qr);
		//����������
		Highlighter highlighter=new Highlighter(formatter,scorer);
		
		for(int i=0;i<tdocs.scoreDocs.length;i++) {
			//6ȡ����װ�˱�źͷ�����ScoreDoc����
		    ScoreDoc sdoc=tdocs.scoreDocs[i];
		    //7ȡ�����
		    int no=sdoc.doc;
		    //IndexSearcher���ݱ��ȥ�������в����ĵ�duix
		    
		    Document d=idxs.doc(no);
		    //���ظ���������
		    String highlighted=highlighter.getBestFragment(analyzer, "content", d.get("content"));
		    String highlightitle=highlighter.getBestFragment(analyzer, "title", d.get("title"));
		    //����������������û��ĵ�����
		    d.getField("content").setValue(highlighted);
		    d.getField("title").setValue(highlightitle);
		    
		  //8����JavaBean����
		    Article a =new Article();
		    //ȡ���ĵ������ÿһ�����Է�װ��JavaBean��
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
          a.setTitle("��ѵ");
          a.setContent("kenny.com����һ����ѵ����");
         Document d=LuceneUtil.Javabean2Document(a);
//          System.out.println(d.get("id"));
//          System.out.println(d.get("title"));
//          System.out.println(d.get("content"));
         Article article=(Article) LuceneUtil.Document2JavaBean(d, Article.class);
         System.out.println(article);
          
	}

}
