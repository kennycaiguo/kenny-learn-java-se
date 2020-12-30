<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>分页查询数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	 
	 
  </head>
  
  <body>
    <table border="1" width="80%" align="center" cellpadding="3" cellspacing="0">
	    <tr>
	         <td>序号</td>
	         <td>员工编号</td>
	         <td>员工姓名</td>
	         <td>员工性别</td>
	         <td>工资</td>
	    </tr>
	    <c:choose>
	       <c:when test="${not empty requestScope.pageBean.pageData }">
	          <c:forEach var="emp" items="${requestScope.pageBean.pageData }" varStatus="vs">
	             <tr>
	                 <td> ${vs.count}</td>
	                 <td> ${emp.id}</td>
	                 <td> ${emp.name}</td>
	                 <td> ${emp.gender}</td>
	                 <td> ${emp.salary}</td>
	                 
	             </tr>
	          </c:forEach>
	       </c:when>
	       <c:otherwise>
	          <tr>
	          <td colspan="5">
	           		 没有找到数据
	          </td>
	          </tr>
	       </c:otherwise>
	    </c:choose>
	    <tr>
	      <td colspan="5" align="center">当前 ${requestScope.pageBean.currentPage} / ${requestScope.pageBean.totalPage }
	        <a href="${pageContex.request.contextPath }/paging/index?currentPage=1">首页</a> 
	        <a href="${pageContex.request.contextPath }/paging/index?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a> 
	        <a href="${pageContex.request.contextPath }/paging/index?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a> 
	        <a href="${pageContex.request.contextPath }/paging/index?currentPage=${requestScope.pageBean.totalPage}">末页</a> 
	        </td>
	    </tr>
    </table>
  </body>
</html>
