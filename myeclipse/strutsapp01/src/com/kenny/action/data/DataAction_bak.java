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
    	  //1.�������ݷ�װ
    	  //2.����service�õ����
    	  //3.���ݱ��浽����
    	  
    	  //Struts���ݴ���ʽ1,ֱ�ӵ���jdk��servlet Api
//    	  HttpServletRequest request = ServletActionContext.getRequest();
//    	    HttpSession session = request.getSession();
//    	  ServletContext application = ServletActionContext.getServletContext();
//    	  request.setAttribute("requestData", "request data");
//    	  session.setAttribute("sessionData", "session data");
//    	  application.setAttribute("applicationData", "application data");
    	  
    	//Struts���ݴ���ʽ2 ͨ��ActionContext��
    	  //���ʽʵ�ֶ����ݲ���
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
