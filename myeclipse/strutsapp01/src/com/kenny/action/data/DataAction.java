package com.kenny.action.data;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
   

	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	
	   public String excute() {
	    	 //方式三，通过实现接口的方式
		   request.put("request_data", "request_data");
	       application.put("application_data", "application_data");
	       session.put("session_data", "session_data");
	    	  
	    	  
			return SUCCESS;
			 
		}

}
