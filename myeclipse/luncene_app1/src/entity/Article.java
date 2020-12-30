package entity;

import org.junit.Test;

public class Article {
	 
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(Integer id,String title,String content) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.title =title;
		this.content=content;
	}
	
	 

	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String title;
	private String content;
	
	
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "±àºÅ:"+this.getId() +"\t"+"±êÌâ:"+this.getTitle()+ "\t" +"ÄÚÈÝ:"+this.getContent();
	}
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
 
	public String getContent() {
		return content;
	}
 
	public void setContent(String content) {
		this.content = content;
	}
 
	 

}
