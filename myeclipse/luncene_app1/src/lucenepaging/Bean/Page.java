package lucenepaging.Bean;

import java.util.ArrayList;
import java.util.List;

import lucenepaging.entity.Article;

/*
 * ��ҳ��
 * */
public class Page {
    
	private Integer currentPageNo;//��ǰҳ��
	
	private Integer perPageSize;//ÿҳ��¼��
	
	private Integer allRecordNo;//�ܼ�¼��
	
	private Integer allPageNo;//��ҳ��
	
	private List<Article> articlelist=new ArrayList<Article>();//ÿҳ��ʾ������
	
	public List<Article> getArticlelist() {
		return articlelist;
	}
	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
	}
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public Integer getPerPageSize() {
		return perPageSize;
	}
	public void setPerPageSize(Integer perPageSize) {
		this.perPageSize = perPageSize;
	}
	public Integer getAllRecordNo() {
		return allRecordNo;
	}
	public void setAllRecordNo(Integer allRecordNo) {
		this.allRecordNo = allRecordNo;
	}
	public Integer getAllPageNo() {
		return allPageNo;
	}
	public void setAllPageNo(Integer allPageNo) {
		this.allPageNo = allPageNo;
	}
	 
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "currentpage:"+this.getAllPageNo()+"\r\n"+"Record Perpage:"+this.getPerPageSize()+"\r\n"+"Records:"+this.getAllRecordNo()
    	                    +"\r\n"+"total page:"+this.getAllPageNo();
    }
	 
}
