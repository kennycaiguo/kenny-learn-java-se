<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <h1>${message}</h1>
    新员工姓名:${emp.username} <br/>
    新员工性别:${emp.gender} <br/>
  <!-- 这个不好 -->  
    入职时间:${emp.hiredate} <br/>
   <!-- 这个用jstl：好 --> 
   <!-- 
    value属性表示要格式化的值
    type属性的值可以是‘date’：只显示日期，‘time’：只显示时间 或‘both’：都显示
    dateStyle表示日期的格式,可以取‘short’，‘medium’，‘long’,'default','full'
    -->
   <fmt:formatDate 
	   value="${requestScope.emp.hiredate}" 
	   type="date" 
	   dateStyle="full" />
	   
<!--   <strong> <fmt:formatDate value="${requestScope.emp.hiredate}" pattern="yyyy-MM-dd"/></strong> -->
  </body>
</html>
