<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>Lucene web test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- 输入区 -->
  <form action="${pageContext.request.contextPath}/ArticleServlet" method="post" id="form1">
      <input type="hidden" name="currentPageNo" value="1" />
	  <table border="2" cellspacing="0" align="center">
	       <tr>
	          <th>输入关键字</th>
	          <td><input type="text" name="keyword" maxlength="15" value="${requestScope.keyword}"/></td>
	          <td><input id="search" type="button" value="站内搜索" /></td> 
	       </tr>
	  </table>
  </form>
  <script type="text/javascript" >
  
     function trim(str){
     //先去除左边的空格
      str=str.replace(/^\s*/,"");
      //再去除右边的空格
      str=str.replace(/\s*$/,"");
      //返回str
      return str;
     }
    //定位“站内搜索”按钮，并且添加处理代码
    document.getElementById("search").onclick=function(){
         //获取form表单
         var formElement=document.forms[0];
         //q获取关键字
         var keyword=formElement.keyword.value;
         //	去掉空格
         keyword=trim(keyword);
         //判断keyword是否为空
         if(keyword.length==0){
           //出错提示
           alert("请输入关键字！！！")
         }else{
            //提交表单
            formElement.submit();
         }
    };
  </script>
   
   <!--显示区 -->
  <table border="2" cellspacing="0" align="center" width="70%">
	       <tr>
	          <th>编号</th>
	          <th>标题</th>
	          <th>内容</th>
	          
	       </tr>
	       
	       <c:forEach var="a" items="${requestScope.page.articlelist}" >
	        <tr>
	          <td>${a.id}</td>
	          <td>${a.title }</td>
	          <td>${a.content }</td>
	        </tr>
	      </c:forEach>
	      <tr><th colspan="3" algin="center">
	             
	            <c:choose>
	              <c:when test="${requestScope.page.currentPageNo>1 }">
	                <a onclick="page(1)" style="cursor:hand;color:blue;text-decoration:underline"> 首页 </a> 
	              </c:when>
	              <c:otherwise>
	                		  首页 
	              </c:otherwise>
	            </c:choose>
	             <c:choose>
	              <c:when test="${requestScope.page.currentPageNo-1>=1 }">
	                <a onclick="page(${requestScope.page.currentPageNo-1})" style="cursor:hand;color:blue;text-decoration:underline"> 上一页 </a> 
	              </c:when>
	              <c:otherwise>
	                		   上一页  
	              </c:otherwise>
	            </c:choose>
	           
	            <c:choose>
	              <c:when test="${requestScope.page.currentPageNo+1<=requestScope.page.allPageNo }">
	                <a onclick="page(${requestScope.page.currentPageNo+1})" style="cursor:hand;color:blue;text-decoration:underline"> 下一页 </a> 
	              </c:when>
	              <c:otherwise>
	                		 下一页
	              </c:otherwise>
	            </c:choose>
	            <c:choose>
	              <c:when test="${requestScope.page.currentPageNo<requestScope.page.allPageNo  }">
	                <a onclick="page(${requestScope.page.allPageNo})" style="cursor:hand;color:blue;text-decoration:underline"> 尾页 </a> 
	              </c:when>
	              <c:otherwise>
	                		尾页 
	              </c:otherwise>
	            </c:choose>
	            
	          </th>
	      </tr>
	  </table>
	  <script type="text/javascript">
	     
	     function page(cpage){
	      var form=document.getElementById("form1");
	       
	      form.currentPageNo.value=cpage;
	      form.submit();
	     }
	  </script>
  </body>
</html>
