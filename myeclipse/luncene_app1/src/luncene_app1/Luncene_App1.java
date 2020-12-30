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
		//1.����javabean����
		//Article ar=new Article();
//		
	
		//2.����document����
		Document doc =new Document();
		//3.��JavaBean�����Է�װ��document����
		doc.add(new Field("id", ar.getId().toString(),Store.YES,Index.ANALYZED));
		doc.add(new Field("title", ar.getTitle().toString(),Store.YES,Index.ANALYZED));
		doc.add(new Field("content", ar.getContent().toString(),Store.YES,Index.ANALYZED));
		//4.����IndexWriter����
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		//5.д��������
		idw.addDocument(doc);
		//6.�ر�
		
		idw.close();
		
	}
	
	 
	public static void SearchIndex(String keyword) throws IOException, Exception {
		//1.����IndexSearcher
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
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
		//5�����ʻ���з����������ĵ�����
		for(int i=0;i<tdocs.scoreDocs.length;i++) {
			//6ȡ����װ�˱�źͷ�����ScoreDoc����
		    ScoreDoc sdoc=tdocs.scoreDocs[i];
		    //7ȡ�����
		    int no=sdoc.doc;
		    //IndexSearcher���ݱ��ȥ�������в����ĵ�duix
		    Document d=idxs.doc(no);
		    //8����JavaBean����
		    Article a =new Article();
		    //ȡ���ĵ������ÿһ�����Է�װ��JavaBean��
		    String id=d.get("id");
		    String title=d.get("title");
		    String content=d.get("content");
		    
		    a.setId(Integer.parseInt(id));
		    a.setTitle(title);
		    a.setContent(content);
		    
		   System.out.println(a); 
		   
		}
		//9.�ر�IndexSearcher����
		idxs.close();
	}
	
	public static void deleteIndex(String keyword) throws IOException, Exception {
		
		Version ver=Version.LUCENE_30;
		Analyzer analyzer=new StandardAnalyzer(ver);
		
		Directory dir=FSDirectory.open(new File("e:/indexDb"));
		MaxFieldLength m=MaxFieldLength.LIMITED;
		IndexWriter idw=new IndexWriter(dir, analyzer, m);
		
		QueryParser paser=new QueryParser(ver,"content",analyzer) ;
		//3.����quey����
		//String keyword="��ѵ";
		Query qr=paser.parse(keyword);
		
		idw.deleteDocuments(qr);
		idw.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Article ar =new Article();
//		ar.setId(1);
//		ar.setTitle("��ѵ");
//		ar.setContent("guohua��ѵ������һ�ҷǳ��õĵ�����ѵ����");
//		WriteIndex(ar);
//		
//		ar.setId(2);
//		ar.setTitle("��ѵ");
//		ar.setContent("oldboy edu��ѵ������һ����ѵ����");
//		WriteIndex(ar);
//		
//		ar.setId(3);
//		ar.setTitle("��ѵ");
//		ar.setContent("pussy.org��ѵ���Ĳ���һ����ѵ����");
//		WriteIndex(ar);
//		
//		ar.setId(4);
//		ar.setTitle("ɫ��");
//		ar.setContent("pussy.org��һ��ɫ����վ���кܶ��Ů������ɫ��Ƭ");
//		WriteIndex(ar);
//		
//		ar.setId(5);
//		ar.setTitle("ɫ��");
//		ar.setContent("youtube����һ��ɫ����վ������������ǳ����ˣ����Թۿ�ɫ��Ƭ");
//		WriteIndex(ar);
		
		//SearchIndex("��ѵ");
		SearchIndex("ɫ��");
		//deleteIndex("ɫ��");
	}

}
