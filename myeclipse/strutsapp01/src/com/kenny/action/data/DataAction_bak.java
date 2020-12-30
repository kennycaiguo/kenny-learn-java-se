package com.kenny.action.data;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction_bak extends ActionSupport{
      public String excute() {
    	  //1.请求数据封装
    	  //2.调用service拿到结果
    	  //3.数据保存到域中
    	  
    	  //Struts数据处理方式1,直接调用jdk的servlet Api
//    	  HttpServletRequest request = ServletActionContext.getRequest();
//    	    HttpSession session = request.getSession();
//    	  ServletContext application = ServletActionContext.getServletContext();
//    	  request.setAttribute("requestData", "request data");
//    	  session.setAttribute("sessionData", "session data");
//    	  application.setAttribute("applicationData", "application data");
    	  
    	//Struts数据处理方式2 通过ActionContext类
    	  //解耦方式实现对数据操作
//    	  ActionContext context = ActionContext.getContext();
//    	  Map<String, Object> request = context.getContextMap();
//    	  Map<String, Object> application = context.getApplication();
//    	  Map<String, Object> session = context.getSession();
    	  
//    	  request.put("request_data", "request_data");
//    	  application.put("application_data", "application_data");
//    	  session.put("session_data", "session_data");
//    	  
    	  
    	  
    	  
		return SUCCESS;
		 
	}
}
