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
	    //�Ż����ϲ�cfs�ļ�
	    idw.optimize();
	    idw.close();
	}
	
	public void type2(Article ar) throws Exception{

	    Document doc=LuceneUtil.Javabean2Document(ar);
	    IndexWriter idw=LuceneUtil.getIndexWriter();
	    idw.addDocument(doc);
	    //�Ż����ϲ�cfs�ļ�
	    idw.setMergeFactor(3);
	    idw.close();
	}
	
	//�������ַ�ʽ���Խ���ٶ���������
	public void type3(Article ar) throws Exception{
		
		//�������Article����ת��ΪDocument����
		Document doc=LuceneUtil.Javabean2Document(ar);
        //Ӳ��������
		Directory fsdir=FSDirectory.open(new File("e:/indexDbOpt"));
		//�ڴ�������,����Ӳ���������Ŀ¼��new������ͬ��Ӳ��������
		Directory ramdir=new RAMDirectory(fsdir);
		
		//ָ��Ӳ�̵��ַ���,Ҫʹ��4�������Ĺ��췽����true��ʾҪ��ɾ��Ӳ������,Ȼ����ͬ��
		IndexWriter fsIdw=new IndexWriter(fsdir, LuceneUtil.getAnalyzer(),true,LuceneUtil.getMaxFieldLength());
		//ָ���ڴ���ַ���
		IndexWriter ramIdw=new IndexWriter(ramdir, LuceneUtil.getAnalyzer(),LuceneUtil.getMaxFieldLength());
		//��Document����д���ڴ�������
		ramIdw.addDocument(doc);
		ramIdw.close();//д���˱���ر��ַ���
      //���ڴ�������ͬ����Ӳ��������
		fsIdw.addIndexesNoOptimize(ramdir);
		fsIdw.close();
 
	}
	public List<Article> findAll(String keyword) throws Exception{
		List<Article> list =new ArrayList<Article>();
		list=LuceneUtil.SearchIndex(keyword);
		return list;
		
	}
	
	public static void main(String[] args) throws Exception {
 		 
//		Article ar=new Article(3,"��ѵ","youtube.com����һ����ѵ�ṹ",10);
//        ArticleDao dao=new ArticleDao();
//         dao.type3(ar);
		 ArticlesearchDao dao=new ArticlesearchDao();
         List<Article> li=dao.findAll("��ѵ");
         for(Article a:li) {
        	 System.out.println(a);
         }
	}

}
