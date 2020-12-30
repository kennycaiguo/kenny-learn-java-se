<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加部门</title>
	 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	 <!-- 导入css文件，没有顺序-->
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
     <!-- 导入js文件，有顺序-->
     <script type="text/javascript" src="js/jquery.min.js"></script>
     <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <form action="">
         <table border="1" align="center" cellspacing="0">
            <tr>
               <th>部门名称</th><td><input type="text" name="department" /></td>
            </tr>
            <tr>
               <th>部门主管</th><td><input type="text" name="leader" /></td>
            </tr>
            <tr>
               <th>部门职责</th><td><textarea rows="5" cols="33"></textarea></td>
            </tr>
            
            <tr>
               <td colspan="2" align="center"><input type="button" value="提交"/></td>
            </tr>
            
         </table>
      </form>
  </body>
</html>
