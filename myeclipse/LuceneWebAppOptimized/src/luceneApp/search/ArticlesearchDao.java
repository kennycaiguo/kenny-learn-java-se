package luceneApp.search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import luceneApp.entity.Article;
import luceneApp.util.LuceneUtil;

public class ArticlesearchDao {

	public ArticlesearchDao() {
		// TODO Auto-generated constructor stub
	}
	public void add(Article ar) throws Exception{
		
		
	    Document doc=LuceneUtil.Javabean2Document(ar);
	    IndexWriter idw=LuceneUtil.getIndexWriter();
	    idw.addDocument(doc);
	    idw.close();
	}
	
	public void type1(Article ar) throws Exception{

	    Document doc=LuceneUtil.Javabean2Document(ar);
	    IndexWriter idw=LuceneUtil.getIndexWriter();
	    idw.addDocument(doc);
	    //优化，合并cfs文件
	    idw.optimize();
	    idw.close();
	}
	
	public void type2(Article ar) throws Exception{

	    Document doc=LuceneUtil.Javabean2Document(ar);
	    IndexWriter idw=LuceneUtil.getIndexWriter();
	    idw.addDocument(doc);
	    //优化，合并cfs文件
	    idw.setMergeFactor(3);
	    idw.close();
	}
	
	//以下这种方式可以解决速度慢的问题
	public void type3(Article ar) throws Exception{
		
		//将传入的Article对象转换为Document对象
		Document doc=LuceneUtil.Javabean2Document(ar);
        //硬盘索引库
		Directory fsdir=FSDirectory.open(new File("e:/indexDbOpt"));
		//内存索引库,利用硬盘索引库的目录来new，可以同步硬盘索引库
		Directory ramdir=new RAMDirectory(fsdir);
		
		//指向硬盘的字符流,要使用4个参数的构造方法，true表示要先删除硬盘内容,然后再同步
		IndexWriter fsIdw=new IndexWriter(fsdir, LuceneUtil.getAnalyzer(),true,LuceneUtil.getMaxFieldLength());
		//指向内存的字符流
		IndexWriter ramIdw=new IndexWriter(ramdir, LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		//将Document对象写入内存索引库
		ramIdw.addDocument(doc);
		ramIdw.close();//写完了必须关闭字符流
      //将内存索引库同步到硬盘索引库
		fsIdw.addIndexesNoOptimize(ramdir);
		fsIdw.close();
 
	}
	public List<Article> findAll(String keyword) throws Exception{
		List<Article> list =new ArrayList<Article>();
		list=LuceneUtil.SearchIndex(keyword);
		return list;
		
	}
	
	public static void main(String[] args) throws Exception {
 		 
//		Article ar=new Article(3,"培训","youtube.com不是一家培训结构",10);
//        ArticleDao dao=new ArticleDao();
//         dao.type3(ar);
		 ArticlesearchDao dao=new ArticlesearchDao();
         List<Article> li=dao.findAll("培训");
         for(Article a:li) {
        	 System.out.println(a);
         }
	}

}
