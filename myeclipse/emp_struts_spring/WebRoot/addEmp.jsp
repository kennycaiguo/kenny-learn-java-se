<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加员工</title>
    
	 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/register" method="post">
       <table border="1" align="center">
          <tr>
              <th>姓名：</th>
              <td><input  type="text" name="emp.username"/></td>
          </tr>
          <tr>
              <th>工资：</th>
              <td><input type="text" name="emp.salary"/></td>
          </tr>
          <tr>
             
              <td colspan="2" align="center"><input type="submit" value="注册"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
