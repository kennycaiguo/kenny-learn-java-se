package com.kenny.action.user;

import com.opensymphony.xwork2.ActionSupport;
 

public class UserAction extends ActionSupport{
	
//	  private String userName; ��ʽһ
//	  private String pwd;
//	  
//    public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
     //��ʽ����ʹ�ö���
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
