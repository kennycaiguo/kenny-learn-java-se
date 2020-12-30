<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SPRINGMVC适配器例子2</title>
	 <style type="text/css">
	   .noUnderline{
	      text-decoration: none;
	       
	   }
	 </style>
	 
  <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  
  <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
  <script type="text/javascript" src="js/jquery.min.js"></script>
  
  
  <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  
  <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  
  </head>
  
  <body>
<!--         <a href="${pageContext.request.contextPath}/index.action" style="text-decoration:none">首页</a>  -->
        
<!--        <hr/> -->
     <form action="${pageContext.request.contextPath}/add.action" method="post">
       <table border="1" align="center">
          <tr>
              <th>管理员姓名：</th>
              <td><input  type="text" name="username"/></td>
              
          </tr>
          <tr>
              <th>管理员性别：</th>
              <td>
	              <input type="radio" name="gender" value="男" checked="checked"/>男
	              <input type="radio" name="gender" value="女 "/>女
              </td>
          </tr>
          <tr>
              <th>入职的时间：</th>
              <td><input id="dd" type="text" class="easyui-datebox" data-options="'required':'required'" name="hiredate" /></td>
          </tr>

          <tr>
             <td colspan="2" align="center"><input type="submit" value="提交"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
