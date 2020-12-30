<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>easyui datagrid 实现分页显示数据</title>
	 <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
     <!-- 导入js文件，有顺序-->
     <script type="text/javascript" src="js/jquery.min.js"></script>
     <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
     <table id="dg"></table>
     <script type="text/javascript">
       $("#dg").datagrid({
              url:'${pageContext.request.contextPath}/EmpServlet?time='+new Date().getTime(),    
			    columns:[[    
					        {field:'empno',title:'编号',width:100},    
					        {field:'ename',title:'姓名',width:100},    
					        {field:'job',title:'职位',width:100},    
					        {field:'mgr',title:'上司',width:100},    
					        {field:'hiredate',title:'入职日期',width:100,
					            formatter: function (value, row, index) {
                                return formatterdate(value, row);
                             }
					        },    
					        {field:'sal',title:'月薪',width:100},    
					        {field:'comm',title:'佣金',width:100},    
					        {field:'deptno',title:'部门',width:100}   
					         
			    ]],
			    fitColumns:true,
			    singleSelect:true,
			    pagination:true,
			    pageNumber:1,
			    pageSize:3,
			    pageList:[3]
       });
       
       function formatterdate(val, row) {
            
		    if (val==null)
		        return '';
		    var format = 'yyyy-MM-dd';
		    var date = new Date(val.time);
		    Y = date.getFullYear() + '-';
			M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			D = date.getDate() + ' ';
			newdate=Y+M+D;
			//alert(newdate);
		    return newdate;
    }
       
       
       function changeDateFormat(cellva){
          //alert(cellva.toString());
          //Date date = (Date)cellva;
         // return cellva.format("yyyy-MM-dd");
       }
       
     </script>
  </body>
</html>
