<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
         欢迎您： ${sessionScope.loginInfo.userName  }
       
        <table border="1" width="*80%" align="center" cellpadding="5" cellspacing="0">
        <tr>
            <td>序号</td><td>员工号</td><td>员工姓名</td><td>性别</td><td>工资</td>
        </tr>
         <c:if test="${not empty requestScope.list }">
       
        <c:forEach var="emp" items="${requestScope.list}" varStatus="vs">
           <tr>
                <td>${vs.count }</td><td>${emp.id }</td><td>${emp.name }</td><td>${emp.gender }</td><td> ${emp.salary }</td>
           </tr>
        </c:forEach>
        </c:if> 
         </table>
  </body>
</html>
