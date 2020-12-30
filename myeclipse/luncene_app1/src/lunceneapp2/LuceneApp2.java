package lunceneapp2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import LuceneUtil.LuceneUtil;
import entity.Article;

public class LuceneApp2 {

	public LuceneApp2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void WriteIndex(Article ar) throws Exception {
		//1.创建javabean对象
		//Article ar=new Article();
//		
	
		//2.创建document对象
		Document doc =LuceneUtil.Javabean2Document(ar);
		//3.将JavaBean的属性封装到document对象
//		doc.add(new Field("id", ar.getId().toString(),Store.YES,Index.ANALYZED));
//		doc.add(new Field("title", ar.getTitle().toString(),Store.YES,Index.ANALYZED));
//		doc.add(new Field("content", ar.getContent().toString(),Store.YES,Index.ANALYZED));
		//4.创建IndexWriter对象
		Version ver=LuceneUtil.getVersion();
		Analyzer analyzer=LuceneUtil.getAnalyzer();
		Directory dir=LuceneUtil.getDirectory();
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		//5.写入索引库
		idw.addDocument(doc);
		//6.关闭
		
		idw.close();
		
	}
	
	 
	public static void SearchIndex(String keyword) throws Exception {
		//1.创建IndexSearcher
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
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
		//5遍历词汇表中符合条件的文档对象
		for(int i=0;i<tdocs.scoreDocs.length;i++) {
			//6取出封装了编号和分数的ScoreDoc对象
		    ScoreDoc sdoc=tdocs.scoreDocs[i];
		    //7取出编号
		    int no=sdoc.doc;
		    //IndexSearcher根据编号去索引库中查找文档duix
		    Document d=idxs.doc(no);
		    //8创建JavaBean对象
		    Article a =(Article)LuceneUtil.Document2JavaBean(d,Article.class);
		    //取出文档对象的每一个属性封装到JavaBean中
//		    String id=d.get("id");
//		    String title=d.get("title");
//		    String content=d.get("content");
//		    
//		    a.setId(Integer.parseInt(id));
//		    a.setTitle(title);
//		    a.setContent(content);
//		    
		   System.out.println(a); 
		   
		}
		//9.关闭IndexSearcher对象
		idxs.close();
	}
	
public static void deleteIndex(String keyword) throws IOException, Exception {
		
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		
		QueryParser paser=new QueryParser(ver,"content",analyzer) ;
		//3.创建quey对象
		//String keyword="培训";
		Query qr=paser.parse(keyword);
		
		idw.deleteDocuments(qr);
		idw.close();
		
	}
	

	public static void main(String[] args) throws Exception {
		  
//        Article ar =new Article();
//        ar.setId(6);
//        ar.setTitle("学习");
//        ar.setContent("www.pussy.org是一个非常好的肏屄学习网站");
//        LuceneUtil.WriteIndex(ar);
		//================================================
		//SearchIndex("成人");
//		//deleteIndex("学习");
//		Article art=new Article(15,"培训","SOU.360.com不是一个培训网站，它是搜索引");
//		Term t=new Term("id","15");
//		LuceneUtil.updateIndex(art, t);
		
		 List<Article> l=LuceneUtil.SearchIndex("培训");
		 for(Article a:l) {
			 System.out.println(a);
		 }
		 Map<String ,String> map=new HashMap<String,String>();
		
	}

}
