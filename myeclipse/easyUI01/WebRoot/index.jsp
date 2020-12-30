<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>easyUI组件练习</title>
	 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	 <!-- 导入css文件，没有顺序-->
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
     <!-- 导入js文件，有顺序-->
     <script type="text/javascript" src="js/jquery.min.js"></script>
     <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	 
     <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  <div id="layoutID" class="easyui-layout" style="width:700px;height:400px;" data-options="fit:true" >
     <!-- 北 -->
     <div data-options="region:'north'" style="height:100px;" ><center><font style="font-size:60px;">jQuery EasyUI组件</font></center></div>
     <!-- 西 -->
     <div data-options="region:'west'" style="width:200px">
         <div id="accordionID"  class="easyui-accordion" data-options="border:false,selected:-1,fit:true"  > 
	                                        
			    <div title="部门管理" data-options="iconCls:'icon-save'" style="padding:10px"> <!-- 标签体中放置linkbutton -->  
		            <a id="btn_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加部门</a><p>  
					<a id="btn_find" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询部门</a><p>    
					<a id="btn_update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改部门</a><p>     
					<a id="btn_delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除部门</a><p>  
			    </div>   
			    <div title="人事管理" data-options="iconCls:'icon-reload'" style="padding:10px">   
			    
			    <!-- tree树 -->
			       <ul id="treeID" class="easyui-tree" data-options="lines:true">   
							    <li>   
							        <span>增加人事</span>   
							         
							    </li>   
							    <li>   
							        <span>查询人事</span>  
							        <ul>
							            <li>
							                  <span>分页查询人事</span>
							                  <ul>
							                      <li>
							                           <span>模糊分页查询人事</span> 
							                      </li>
							                      <li>
							                           <span>精确分页查询人事</span> 
							                      </li>
							                  </ul>
							            </li>
							            <li>
							                  <span>查询所有人事</span>
							            </li>
							             
							        </ul> 
							    </li>   
						</ul>  
			                                 
			    </div>   
			    <div title="客户管理" data-options="iconCls:'icon-remove'" style="padding:10px">   
			       	     客户管理
			    </div>   
			     <div title="权限管理" data-options="iconCls:'icon-add'" style="padding:10px">   
			     	     权限管理  
			    </div>  
			     <div title="报表管理" data-options="iconCls:'icon-print'" style="padding:10px">   
			                          报表管理   
			    </div>  
			     <div title="帮助" data-options="iconCls:'icon-help'" style="padding:10px">   
			     		帮助 
			    </div>  
		</div>
     </div>
     <!-- 南-->
	  <div data-options="region:'south'"  style="height:100px;">
	     <center><h2>kenny.com版权所有</h2></center>
	  </div>
	  <!-- 中 -->
	  <div data-options="region:'center'" >
	  	<!-- 嵌入tabs控件 -->
	  	 <div id="tabsID" 
		  	 class="easyui-tabs" 
		  	 style="width:500px;height:250px;" 
		  	 data-options="fit:true,showHeader:true,selected:-1,plain:true,border:false" >
		   
       </div>
	  </div>
	  <!-- 东 -->
	  <div data-options="region:'east'" style="width:90px"></div>
	  
  </div>
    <script type="text/javascript">
         $("a").click(function(){
             var title=$(this).text();
             title=$.trim(title);
           
           
           // 增加部门
             if("增加部门"==title){
               if(!$("#tabsID").tabs("exists",title)){
                $("#tabsID").tabs("add",{
                   "title":title,
                   "closable":true,
                   "href":"${pageContext.request.contextPath}/addGroup.jsp",
                   "iconCls":"icon-add"
                });
             }// 查询部门
           }else if("查询部门"==title){
               if(!$("#tabsID").tabs("exists",title)){
                $("#tabsID").tabs("add",{
                   "title":title,
                   "closable":true,
                   "content":"查询部门",
                   "iconCls":"icon-search"
                });
             }//修改部门
           }else if("修改部门"==title){
               if(!$("#tabsID").tabs("exists",title)){
                $("#tabsID").tabs("add",{
                   "title":title,
                   "closable":true,
                   "iconCls":"icon-edit"
                });
             }//删除部门
           }else if("删除部门"==title){
               if(!$("#tabsID").tabs("exists",title)){
                $("#tabsID").tabs("add",{
                   "title":title,
                   "closable":true,
                   "iconCls":"icon-remove"
                });
             }
           }
         });

//          $("a").click(function(){
//              var title=$(this).text();
//              title=$.trim(title);
//              if(!$("#tabsID").tabs("exists",title)){
//                  $("#tabsID").tabs("add",{
//                    "title":title,
//                    "closable":true
//                 });
//              }
            
             
              
 //        });
     </script>
     
     <script type="text/javascript">
          $(function(){
             //默认折叠所有tree选项
             $("#treeID").tree("collapseAll");
          }) ;
     </script>
     
     <script type="text/javascript">
       $("#treeID").tree({"onClick":function(node){
          //获取被点击的节点的文本
          var title=node.text;
           //去除空格
           title=$.trim(title);
           //产生tab选项卡
            if(!$("#tabsID").tabs("exists",title)){
                $("#tabsID").tabs("add",{
                   "title":title,
                   "closable":true,
                   "href":"${pageContext.request.contextPath}/empList.jsp",
                   "iconCls":"icon-add"
                });
             }
       }});
     </script>
  </body>
</html>
