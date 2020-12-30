package com.kenny.action.user;

import com.opensymphony.xwork2.ActionSupport;
 

public class UserAction extends ActionSupport{
	
//	  private String userName; 方式一
//	  private String pwd;
//	  
//    public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
     //方式二，使用对象
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		
    	System.out.println(user.getUserName());
    	System.out.println(user.getPwd());
		return "login";
    	
    }
}
