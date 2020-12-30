<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SPRINGMVC映射器例子</title>
	 <style type="text/css">
	   .noUnderline{
	      text-decoration: none;
	       
	   }
	 </style>
  </head>
  
  <body>
        <a href="${pageContext.request.contextPath}/add.action" class="noUnderline">增加用户</a><br/>
        <hr/>
        <a href="${pageContext.request.contextPath}/update.action" class="noUnderline">修改用户</a><br/>
         
        <a href="${pageContext.request.contextPath}/delete.action" class="noUnderline">删除用户</a><br/>
         
        <a href="${pageContext.request.contextPath}/find.action" class="noUnderline">查询用户</a><br/>
         
  
  
<!--    <form action="${pageContext.request.contextPath}/register" method="post"> -->
<!--        <table border="1" align="center"> -->
<!--           <tr> -->
<!--               <th>姓名：</th> -->
<!--               <td><input  type="text" name="emp.username"/></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--               <th>工资：</th> -->
<!--               <td><input type="text" name="emp.salary"/></td> -->
<!--           </tr> -->
<!--           <tr> -->
             
<!--               <td colspan="2" align="center"><input type="submit" value="注册"/></td> -->
<!--           </tr> -->
<!--        </table> -->
<!--     </form> -->
  </body>
</html>
