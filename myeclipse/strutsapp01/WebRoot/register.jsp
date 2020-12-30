<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/user_register.action" method="post" >
   <table>
       <tr><td>用户名</td><td><input type="text" name="name" /></td></tr>
       <tr><td> 密码</td><td><input type="password"" name="pwd"  /></td></tr>
       <tr><td> 生日</td><td><input type="text" name="birth" /><!-- 日期格式yyyy/mm/dd --></td></tr>
        <tr><td colspan="3" ><input type="submit" name="submit"  value="注册"/>&nbsp;<input type="button" name="cancel" value="取消"/></td></tr>
   </table>
   </form>
  </body>
</html>
