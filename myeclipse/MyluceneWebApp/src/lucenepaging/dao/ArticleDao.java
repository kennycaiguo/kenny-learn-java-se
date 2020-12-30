package lucenepaging.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
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
import org.apache.lucene.util.Version;

import LuceneUtil.LuceneUtil;
import LuceneUtil.LuceneUtil1;
import lucenepaging.entity.Article;
import net.sf.json.JSONArray;

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
	 IndexSearcher idxs=new IndexSearcher(LuceneUtil1.getDirectory());
		//2.创建QueryParser对象
		QueryParser paser=new QueryParser(LuceneUtil1.getVersion(),"content",LuceneUtil1.getAnalyzer()) ;
		//3.创建quey对象
		//String keyword="培训";
		Query qr=paser.parse(keyword);
		//4.利用IndexSearcher对象查找内容
		
		Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
		//查询内容
		Scorer scorer =new QueryScorer(qr);
		//高亮处理器
		Highlighter highlighter=new Highlighter(formatter,scorer);
		
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		int middle=Math.min(start+size, tdocs.totalHits);
		for(int i=start;i<middle;i++) {
			ScoreDoc sd=tdocs.scoreDocs[i];
			int no=sd.doc;
			Document d=idxs.doc(no);
			  //返回高亮处理结果
		    String highlighted=highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "content", d.get("content"));
		    String highlightitle=highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "title", d.get("title"));
		    //将高亮结果重新设置回文档对象
		    d.getField("content").setValue(highlighted);
		    d.getField("title").setValue(highlightitle);
			Article ar=(Article) LuceneUtil1.Document2JavaBean(d,Article.class);
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
//		Map<String,Object> map =new LinkedHashMap<String,Object>();
//		 map.put("size", list.size());
//		 map.put("rows", 100);
//		 
//		 JSONArray jsarr=JSONArray.fromObject(list);
//		 String string = jsarr.toString();
//		 System.out.println(string);
	}

}
