package utils;

import java.util.List;

public class PageBean<T> {
	
	private int CurrentPage=1;
	private int pageCount=8;
	private int totalCount;
	private int totalPage;
	private List<T> pageData;
	
	
	public int getCurrentPage() {
		return CurrentPage;
	}
	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(totalCount % pageCount==0) {
			totalPage=totalCount/pageCount;
			 
		}else {
			totalPage=totalCount/pageCount+1;
			
		}
			
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
