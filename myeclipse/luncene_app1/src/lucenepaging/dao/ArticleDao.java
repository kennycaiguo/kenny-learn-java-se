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
		//2.创建QueryParser对象
		QueryParser paser=new QueryParser(ver,"content",analyzer) ;
		//3.创建quey对象
		//String keyword="培训";
		Query qr=paser.parse(keyword);
		//4.利用IndexSearcher对象查找内容
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		return tdocs.totalHits;
    }
    
    /*
     * start：表示从哪里开始，默认从0开始
     * size：表示要查询多少条数据
     */
 public List<Article> findLimited(String keyword,int start,int size) throws Exception{
	 List<Article> arlist=new ArrayList<Article>();
	 //插件IndexSearcher对象
	 IndexSearcher idxs=new IndexSearcher(LuceneUtil.getDirectory());
		//2.创建QueryParser对象
		QueryParser paser=new QueryParser(LuceneUtil.getVersion(),"content",LuceneUtil.getAnalyzer()) ;
		//3.创建quey对象
		//String keyword="培训";
		Query qr=paser.parse(keyword);
		//4.利用IndexSearcher对象查找内容
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
//         System.out.println(dao.getAllRecord("培训"));
		ArticleDao dao=new ArticleDao();
		List<Article> list=new ArrayList<Article>();
		System.out.println("第一页");
		list=dao.findLimited("培训",0,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("第二页");
		list=dao.findLimited("培训",3,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("第三页");
		list=dao.findLimited("培训",6,3);
		for(Article a:list) {
			System.out.println(a);
		}
		System.out.println("第四页");
		list=dao.findLimited("培训",9,3);
		for(Article a:list) {
			System.out.println(a);
		}
	}

}
