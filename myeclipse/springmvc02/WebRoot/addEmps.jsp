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
     <form  action="${pageContext.request.contextPath}/emp/addAll.action" method="post">
           
       <table border="2" align="center" cellspacing="0">
          <caption><h2>批量注册员工</h2></caption>
          <tr>
             <td>姓名：<input  type="text" name="empList[0].username" value="jack"/></td>
              <td>工资：<input  type="text" name="empList[0].salary" value="2000.00"/></td>
          </tr>
          <tr>
             <td>姓名：<input  type="text" name="empList[1].username" value="小东"/></td>
              <td>工资：<input  type="text" name="empList[1].salary" value="1700.00"/></td>
          </tr>
          <tr>
             <td>姓名：<input  type="text" name="empList[2].username" value="小王"/></td>
              <td>工资：<input  type="text" name="empList[2].salary" value="1900.00"/></td>
          </tr>
          <tr>
             <td>姓名：<input  type="text" name="empList[3].username" value="大敏"/></td>
              <td>工资：<input  type="text" name="empList[3].salary" value="2100.00"/></td>
          </tr>
          <tr>
             <td>姓名：<input  type="text" name="empList[4].username" value="大B"/></td>
              <td>工资：<input  type="text" name="empList[4].salary" value="1000.00"/></td>
          </tr>
          <tr>
             <td>姓名：<input  type="text" name="empList[5].username" value="妍妍"/></td>
              <td>工资：<input  type="text" name="empList[5].salary" value="900.00"/></td>
          </tr>
           
          <tr>
             <td colspan="2" align="center"><input type="submit" value="批量注册" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
  
  </body>
</html>
