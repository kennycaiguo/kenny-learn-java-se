package luncene_app1;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.ConstantScoreQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
 

import entity.Article;

public class Luncene_App1 {

	 

	public Luncene_App1() {
		// TODO Auto-generated constructor stub
	}
    
	
	public static void WriteIndex(Article ar) throws IOException {
		//1.创建javabean对象
		//Article ar=new Article();
//		
	
		//2.创建document对象
		Document doc =new Document();
		//3.将JavaBean的属性封装到document对象
		doc.add(new Field("id", ar.getId().toString(),Store.YES,Index.ANALYZED));
		doc.add(new Field("title", ar.getTitle().toString(),Store.YES,Index.ANALYZED));
		doc.add(new Field("content", ar.getContent().toString(),Store.YES,Index.ANALYZED));
		//4.创建IndexWriter对象
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		//5.写入索引库
		idw.addDocument(doc);
		//6.关闭
		
		idw.close();
		
	}
	
	 
	public static void SearchIndex(String keyword) throws IOException, Exception {
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
		    Article a =new Article();
		    //取出文档对象的每一个属性封装到JavaBean中
		    String id=d.get("id");
		    String title=d.get("title");
		    String content=d.get("content");
		    
		    a.setId(Integer.parseInt(id));
		    a.setTitle(title);
		    a.setContent(content);
		    
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
		// TODO Auto-generated method stub
		Article ar =new Article();
//		ar.setId(1);
//		ar.setTitle("培训");
//		ar.setContent("guohua培训中心是一家非常好的电脑培训中心");
//		WriteIndex(ar);
//		
//		ar.setId(2);
//		ar.setTitle("培训");
//		ar.setContent("oldboy edu培训中心是一家培训中心");
//		WriteIndex(ar);
//		
//		ar.setId(3);
//		ar.setTitle("培训");
//		ar.setContent("pussy.org培训中心不是一家培训中心");
//		WriteIndex(ar);
//		
//		ar.setId(4);
//		ar.setTitle("色情");
//		ar.setContent("pussy.org是一家色情网站，有很多妓女，海量色情片");
//		WriteIndex(ar);
//		
//		ar.setId(5);
//		ar.setTitle("色情");
//		ar.setContent("youtube不是一家色情网站，但是如果你是成年人，可以观看色情片");
//		WriteIndex(ar);
		
		//SearchIndex("培训");
		SearchIndex("色情");
		//deleteIndex("色情");
	}

}
