package lucenedao;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

import LuceneUtil.LuceneUtil;
import entity.Article;


public class LuceneDao {

	public LuceneDao() {
		// TODO Auto-generated constructor stub
	}
    public static void add(Article a) throws  Exception {
    	//Document d=LuceneUtil.Javabean2Document(a);
    	LuceneUtil.WriteIndex(a);
    }
    
   public static void addAll(List<Article> list) throws Exception {
    	for(Article a :list) {
    		LuceneUtil.WriteIndex(a);
    	}
    }
 
 public static void update(Term t,Document d) throws Exception {
 	IndexWriter idw=LuceneUtil.getIndexWriter();
 	idw.updateDocument(t, d);
 	idw.close();
 }
 public static void delete(String keyword) {
 	
 }
 
 public static void deleteAll() {
 	
 }
 
 public static Article find(String keyword) {
	 
 	return null;
 }
 
 public static List<Article> findAll(String keyword){
	 
	 return null;
 }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//�����������
		List<Article> list=new ArrayList<Article>();
       Article a5=new Article(5,"��ѵ","bing.com����һ����ѵ��վ��������������");
       list.add(a5);
       Article a6=new Article(6,"��ѵ","shougou.com����һ����ѵ��վ�����������");
       list.add(a6);
       Article a7=new Article(7,"��ѵ","ask.com����һ����ѵ��վ��������������");
       list.add(a7);
       Article a8=new Article(8,"��ѵ","youtube.com����һ����ѵ��վ��������Ƶ��վ");
       list.add(a8);
       addAll(list);
		//��������
//		Article a=new Article(15,"��ѵ","search.360.com����һ����ѵ��վ������������");
//		Document d=LuceneUtil.Javabean2Document(a);
//		Term t=new Term("id","15");
//		update(t,d);
//		//ɾ��ָ������
//		Term t =new Term("id","16");
//		LuceneUtil.deleteIndex(t);
		//ɾ����������
		//LuceneUtil.deleteAllIndex();
	}

}
