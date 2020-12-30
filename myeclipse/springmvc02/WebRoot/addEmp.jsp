<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
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
     <form action="${pageContext.request.contextPath}/user/register.action" method="post">
       <table border="1" align="center">
          <caption><h2>用户注册</h2></caption>
          <tr>
              <th>姓名：</th>
              <td><input  type="text" name="username"/></td>
              
          </tr>
          <tr>
              <th>薪水：</th>
              <td>
	               
	              <input  type="text" name="salary"/>
              </td>
          </tr>
            <tr>
              <th>入职的时间：</th>
              <td><input id="dd" type="text" class="easyui-datetimebox" data-options="'required':'required'" name="hiredate" /></td>
           </tr>
          <tr>
             <td colspan="2" align="center"><input type="submit" value="注册" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
