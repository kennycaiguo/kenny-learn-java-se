package lucenepaging.service;

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

import LuceneUtil.LuceneUtil1;
import lucenepaging.Bean.Page;
import lucenepaging.dao.ArticleDao;
import lucenepaging.entity.Article;

public class ArticleService {

	public ArticleService() {
		// TODO Auto-generated constructor stub
		
	}
     
	private ArticleDao adao=new ArticleDao();
	 
	public Page show(String keyword,int currentPageNo,int pagesize) throws Exception{
		Page page=new Page();
		page.setPerPageSize(pagesize);
		//设置当前页
		page.setCurrentPageNo(currentPageNo);
		//设置总记录数
		int allRecordNo=adao.getAllRecord(keyword);
		//System.out.println(allRecordNo); //OK
		page.setAllRecordNo(allRecordNo);
		//设置总页数
		int allPageNo=0;
		if(page.getAllRecordNo() % page.getPerPageSize()==0) {
			   allPageNo=page.getAllRecordNo()/page.getPerPageSize();
			
		}else {
			
			 allPageNo=page.getAllRecordNo()/page.getPerPageSize()+1;
		}
		
		page.setAllPageNo(allPageNo);
		//封装内容
		int size=page.getPerPageSize();
		int start=(page.getCurrentPageNo()-1)*size;
		List<Article> arlist =adao.findLimited(keyword, start, size);
		 page.setArticlelist(arlist);
		return page;
	}
    public static void main(String[] args) throws Exception {
		ArticleService as=new ArticleService();
		
		Page p=as.show("培训",1,4);
		System.out.println(p);
		for(Article a:p.getArticlelist()) {
			System.out.println(a);
		}
	}
}
