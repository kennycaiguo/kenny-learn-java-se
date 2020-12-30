<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>用户登陆</title>
	 
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath}/user/login.action" method="post">
       <table border="1" align="center">
          <caption><h2>用户登陆</h2></caption>
          <tr>
              <th>姓名：</th>
              <td><input  type="text" name="username"/></td>
              
          </tr>
<!--           <tr> -->
<!--               <th>薪水：</th> -->
<!--               <td> -->
	               
<!-- 	              <input  type="text" name="salary"/> -->
<!--               </td> -->
<!--           </tr> -->
           
          <tr>
             <td colspan="2" align="center"><input type="submit" value="登陆" style="width:150px;"/></td>
          </tr>
       </table>
    </form>
  </body>
</html>
