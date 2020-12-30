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
     <form name="form1" action="${pageContext.request.contextPath}/person/register.action" method="post">
       <table border="1" align="center">
          
          <tr>
              <th>姓名：</th>
              <td><input  type="text" name="user.username" value="${!empty user.username?user.username:'' }"/></td>
              
          </tr>
          <tr>
              <th>薪水：</th>
              <td>
	               
	              <input  type="text" name="user.salary" value="${!empty user.salary?user.salary:''}"/>
	              
              </td>
          </tr>
            <tr>
              <th>入职的时间：</th>
              <td><input id="dd1" type="text" class="easyui-datebox" data-options="'required':'required'" name="user.hiredate" value="<fmt:formatDate value='${user.hiredate}' type='date' dateStyle='medium'/>" /></td>
           </tr>
          <tr>
             <td colspan="2" align="center"><input type="submit" value="普通用户注册" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
    <hr/>
  管理员用户
     <form name="form2" action="${pageContext.request.contextPath}/person/register.action" method="post">
       <table border="1" align="center">
          
          <tr>
              <th>姓名：</th>
              <td><input  type="text" name="admin.username" value="${admin.username}"/></td>
              
          </tr>
          <tr>
              <th>薪水：</th>
              <td>
	               
	              <input  type="text" name="admin.salary" value="${admin.salary}"/>
	              
              </td>
          </tr>
             <tr>
              <th>入职的时间：</th>
              <td><input id="dd1" type="text" class="easyui-datebox" data-options="'required':'required'" name="admin.hiredate" value="<fmt:formatDate value='${admin.hiredate}' type='date' dateStyle='medium'/>" /></td>
           </tr>
          <tr>
             <td colspan="2" align="center"><input type="submit" value="管理员注册" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
