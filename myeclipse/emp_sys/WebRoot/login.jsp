<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/login" name="frmLogin" method="post">
     <table border="1">
     <tr>
       <td>用户名</td>
       <td><input type="text" name="userName" /></td>
     </tr>
     <tr>
       <td>密码</td>
       <td><input type="password" name="pwd" /></td>
     </tr>
     
     <tr>
             <td colspan ="2"><input type="submit" name="submit" value="登陆" /></td>
     </tr>
     </table>
   </form>
  </body>
</html>
