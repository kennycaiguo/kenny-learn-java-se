<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'success.jsp' </title>
    
	 
  </head>
  
  <body>
    This is success page. <br>
    <h1>操作成功！！！</h1>
    ${user.username}===>${user.salary}===>
 
    <fmt:formatDate 
          value="${user.hiredate}"  
          type="both"
          dateStyle="full"
          timeStyle="full" />
   
  </body>
</html>
