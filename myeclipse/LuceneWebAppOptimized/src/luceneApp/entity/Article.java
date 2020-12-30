package luceneApp.entity;

public class Article {
	 
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(Integer id,String title,String content,Integer count) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.title =title;
		this.content=content;
		this.count=count;
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
	private Integer count;
	
	 public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "编号:"+this.getId() +"\t"+"标题:"+this.getTitle()+ "\t" +"内容:"+this.getContent()+"\t"+"字数："+this.getCount();
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
