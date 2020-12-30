<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>Add Emp page</title>
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  
   <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
   <script type="text/javascript" src="js/jquery.min.js"></script>
  
  
   <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  
   <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	 
  </head>
  
  <body>
  普通用户
     <form  action="${pageContext.request.contextPath}/emp/deleteAll.action" method="post">
       <table border="2" align="center" cellspacing="0">
          
          <tr>
              <th>编号：</th>
              <th>姓名：</th>
               
          </tr>
          <tr>
             <td><input  type="checkbox" name="ids" value="1"/></td>
              <td>小敏</td>
          </tr>
          <tr>
             <td><input  type="checkbox" name="ids" value="2"/></td>
              <td>小东</td>
          </tr>
           
            <tr>
               <td><input  type="checkbox" name="ids" value="3"/></td>
              <td>小王</td>
           </tr>
           
            <tr>
               <td><input  type="checkbox" name="ids" value="4"/></td>
              <td>小张</td>
           </tr>
           
            <tr>
               <td><input  type="checkbox" name="ids" value="5"/></td>
              <td>小华</td>
           </tr>
           
          <tr>
             <td colspan="2" align="center"><input type="submit" value="删除" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
  
  </body>
</html>
