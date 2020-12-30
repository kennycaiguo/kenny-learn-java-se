<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SPRINGMVC适配器例子</title>
	 <style type="text/css">
	   .noUnderline{
	      text-decoration: none;
	       
	   }
	 </style>
  </head>
  
  <body>
         
      <form action="${pageContext.request.contextPath}/add.action" method="post">
       <table border="1" align="center">
          <tr>
              <th>员工姓名：</th>
              <td><input  type="text" name="username"/></td>
              <td><input type="submit" value="提交"/></td>
          </tr>
<!--           <tr> -->
<!--               <th>工资：</th> -->
<!--               <td><input type="text" name="emp.salary"/></td> -->
<!--           </tr> -->

<!--           <tr> -->
<!--              <td colspan="2" align="center"><input type="submit" value="注册"/></td> -->
<!--           </tr> -->
       </table>
    </form>
  </body>
</html>
