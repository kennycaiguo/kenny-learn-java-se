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
	 IndexSearcher idxs=new IndexSearcher(LuceneUtil1.getDirectory());
		//2.����QueryParser����
		QueryParser paser=new QueryParser(LuceneUtil1.getVersion(),"content",LuceneUtil1.getAnalyzer()) ;
		//3.����quey����
		//String keyword="��ѵ";
		Query qr=paser.parse(keyword);
		//4.����IndexSearcher�����������
		
		Formatter formatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
		//��ѯ����
		Scorer scorer =new QueryScorer(qr);
		//����������
		Highlighter highlighter=new Highlighter(formatter,scorer);
		
		int MAX_RECORD=100;
		TopDocs tdocs=idxs.search(qr, MAX_RECORD);
		int middle=Math.min(start+size, tdocs.totalHits);
		for(int i=start;i<middle;i++) {
			ScoreDoc sd=tdocs.scoreDocs[i];
			int no=sd.doc;
			Document d=idxs.doc(no);
			  //���ظ���������
		    String highlighted=highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "content", d.get("content"));
		    String highlightitle=highlighter.getBestFragment(LuceneUtil.getAnalyzer(), "title", d.get("title"));
		    //����������������û��ĵ�����
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
//		Map<String,Object> map =new LinkedHashMap<String,Object>();
//		 map.put("size", list.size());
//		 map.put("rows", 100);
//		 
//		 JSONArray jsarr=JSONArray.fromObject(list);
//		 String string = jsarr.toString();
//		 System.out.println(string);
	}

}
