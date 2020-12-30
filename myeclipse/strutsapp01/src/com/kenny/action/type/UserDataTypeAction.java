package com.kenny.action.type;

import java.util.Date;

//struts2请求数据找到封装以及类型转换
public class UserDataTypeAction {
//	
//	private String  name;
//	private String  pwd;
//	private Date  birth;
//	
//    public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}
	private User user;
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    
	public String register() {
    	System.out.println("userName:"+user.getName()+"\t"+"password:"+user.getPwd()+"\t"+"Birthday:"+user.getBirth());
		return "success";
		 
	}
}
