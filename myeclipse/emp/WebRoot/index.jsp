<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>员工管理系统</title>
	 <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  
     <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath}/add.do" method="post">
       <table border="1" align="center">
          <tr>
              <th>管理员姓名：</th>
              <td><input  type="text" name="username"/></td>
              
          </tr>
          <tr>
              <th>期望薪水：</th>
              <td>
<!-- 	              <input type="text" name="salary" value="3000.00"/> -->
	              <select name="salary" class="easyui-combobox" style="width:80px;">
	                <option value="3000">3000</option>
	                <option value="5000" selected="selected">5000</option>
	                <option value="6000">6000</option>
	                <option value="7000">7000</option>
	              </select>
              </td>
          </tr>
          <tr>
              <th>入职的时间：</th>
              <td><input id="dd" type="text" class="easyui-datebox" data-options="required:true" name="hiredate" /></td>
          </tr>

          <tr>
             <td colspan="2" align="center"><input type="submit" value="提交"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
