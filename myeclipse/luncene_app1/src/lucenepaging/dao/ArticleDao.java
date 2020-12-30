package lucenepaging.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import LuceneUtil.LuceneUtil;
import lucenepaging.entity.Article;

public class ArticleDao {

	public ArticleDao() {
		// TODO Auto-generated constructor stub
	}
    public int getAllRecord(String keyword) throws Exception{
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
		return tdocs.totalHits;
    }
    
    /*
     * start����ʾ�����￪ʼ��Ĭ�ϴ�0��ʼ
     * size����ʾҪ��ѯ����������
     */
 public List<Article> findLimited(String keyword,int start,int size) throws Exception{
	 List<Article> arlist=new ArrayList<Article>();
	 //���IndexSearcher����
	 IndexSearcher idxs=new IndexSearcher(LuceneUtil.getDirectory());
		//2.����QueryParser����
		QueryParser paser=new QueryParser(LuceneUtil.getVersion(),"content",LuceneUtil.getAnalyzer()) ;
		//3.����quey����
		//String keyword="��ѵ";
		Query qr=paser.parse(keyword);
		//4.����IndexSearcher�����������
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		int middle=Math.min(start+size, tdocs.totalHits);
		for(int i=start;i<middle;i++) {
			ScoreDoc sd=tdocs.scoreDocs[i];
			int no=sd.doc;
			Document d=idxs.doc(no);
			Article ar=(Article) LuceneUtil.Document2JavaBean(d,Article.class);
			arlist.add(ar);
		}
		return arlist;
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//         ArticleDao dao=new ArticleDao();
//         System.out.println(dao.getAllRecord("��ѵ"));
		ArticleDao dao=new ArticleDao();
		List<Article> list=new ArrayList<Article>();
		System.out.println("��һҳ");
		list=dao.findLimited("��ѵ",0,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("�ڶ�ҳ");
		list=dao.findLimited("��ѵ",3,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("����ҳ");
		list=dao.findLimited("��ѵ",6,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("����ҳ");
		list=dao.findLimited("��ѵ",9,3);
		for(Article a:list) {
			System.out.println(a);
		}
	}

}
