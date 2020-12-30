<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'success.jsp' </title>
    
	 
  </head>
  
  <body>
    This is success page. <br>
    <h1>操作成功！！！</h1>
    ${message}<br/>
    被删除员工：<br/>
   <c:forEach var="id" items="${ids}" varStatus="vs">
       ${id}
    </c:forEach>
  </body>
</html>
