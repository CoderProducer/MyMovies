<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="df" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
    <!--//browse-agile-w3ls翻页的修饰 -->
    <link href="${pageContext.request.contextPath}/static/css/medile.css" rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery2.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>

    <style type="text/css">
        body {font-size: 10px;
            padding-bottom: 40px;
            padding-left: 40px;
            padding-top: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    <!-- 全选事件-->
    <script>
        function check() {
            var oInput=document.getElementsByName("xinwen");
            for(var i=0;i<oInput.length;i++){
                oInput[i].checked=document.getElementById("all").checked;
            }
            }
            //批量删除
			function alldel(){
				var f=false;
				//得到要删除的主键id
				var arr=new Array();//用于存要删除的选中的id值
				
				var xinwen=document.getElementsByName("xinwen");//得到一组checkbox  相当于数组
				alert("id值："+xinwen);
				//循环这一组checkbox让每一个checkbox选中
				for(var i=0;i<xinwen.length;i++){
					if(xinwen[i].checked==true){//代表选中
						arr.push(xinwen[i].value);
						f=true;
					}
				}
				
				//alert(arr);
				//跳到删除的servlet里去
				if(f==true){
					if(confirm("您确认要删除吗？"))
						location.href="${pageContext.request.contextPath}/NewsControl/newsAdminDelete.do?newsIds="+arr;
				}else{
					alert("请至少选中一条进行批量删除");
				}
			}
    </script>
</head>
<body >
<form class="form-inline definewidth m20" action="#" method="get">
    <span style="color: #777777"><strong>新闻名称：</strong></span>
    <input type="text" name="menuname" id="menuname" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
    <button type="button"  id="addnew"><a href="videosAdd.html">添加新闻</a></button>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	    <tr>
	    	<th colspan="6">
	    		<input id="all" type="checkbox" style="float: left" value="" onclick="check();" />全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		<a href="javascript:void(0);" onclick="alldel();">批量删除</a>
	    	</th>
	    </tr>
	</thead>	 
    <tr>
    	<td style="text-align: center">标记</td>
        <td style="text-align: center">新闻标题</td>
        <td style="text-align: center">相关视频</td>
        <td style="text-align: center">新闻图片</td>
        <td style="text-align: center">上传日期</td>
        <td style="text-align: center">新闻内容</td>        
    </tr>
   

    <c:forEach var="message" items="${newsAdminList}">
  		<tr>
  			<td style="width: 5%">
  				<input type="checkbox" style="text-align: center" name="xinwen" value="${message.news_Id}" />
			</td>
			<td style="width: 15%;text-align: center">${message.news_Title}</td>
			<td style="width: 15%;text-align: center">${message.news_VideoTitle}</td>
			<td style="width: 25%;text-align: center"><img src="${pageContext.request.contextPath}/${message.news_PictureAddress}" title="album-name" alt=" " width="120px" height="110px" /></td>			
			<td style="width: 10%;text-align: center"><df:formatDate value="${message.news_Date}" pattern="yyyy-MM-dd"></df:formatDate></td>	
			<td style="width: 30%;text-align: center">${message.news_Introduce}</td>		
		</tr>   					
	</c:forEach>
</table>
<div class="clearfix"></div>
<!--//browse-agile-w3ls -->
<div class="blog-pagenat-wthree">
	<span style="text-align: left;">共${page.totalPageCount }页，${page.totalCount }条记录 </span>
		<div class="page_nav">
         <c:choose>
             <c:when test="${page.totalPageCount <= 10}"><!-- 如果总页数小于10，则全部显示 -->
                 <c:set var="begin" value="1"></c:set>
                 <c:set var="end" value="${page.totalPageCount }"></c:set>
             </c:when>
             <c:when test="${page.pageNow <= 5 }"><!-- 如果总页数小于5，则显示1-10页 -->
                 <c:set var="begin" value="1"></c:set>
                 <c:set var="end" value="10"></c:set>
             </c:when>
             <c:otherwise><!-- 否则，显示前5页和后5页，保证当前页在中间 -->
                 <c:set var="begin" value="${page.pageNow }"></c:set>
                 <c:set var="end" value="${page.pageNow+5 }"></c:set>
                 <c:if test="${end > page.totalPageCount }"><!-- 如果end值小于总的记录数，则显示最后10页 -->
                     <c:set var="end" value="${page.totalPageCount}"></c:set>
                     <c:set var="begin" value="${end-10 }"></c:set>
                 </c:if>
             </c:otherwise>
         </c:choose>
         <c:choose>
             <c:when test="${page.pageNow != 1 }"><!-- 如果当前页为1，则不显示首页和上一页 -->
                 <a href="${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=1">首页</a> 
                 <a href="${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=${page.pageNow-1 }">上一页</a>
             </c:when>
         </c:choose>
         <!-- 遍历页码 -->
         <c:forEach begin="${begin }" end="${end }" var="index">
             <c:choose>
                 <c:when test="${page.pageNow == index }"><!-- 如果为当前页，则特殊显示 -->
                     <a id="index" style="height:24px; margin:0 3px; border:none; background:#C00;">${index}</a>
                 </c:when>
                 <c:otherwise><!-- 否则，普通显示 -->
                     <a id="index" href="${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=${index }">${index }</a>
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <c:choose>
             <c:when test="${page.pageNow != page.totalPageCount }"><!-- 如果当前页为总的记录数，则不显示末页和下一页 -->
                 <a href="${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=${page.pageNow+1 }">下一页</a> 
                 <a href="${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=${page.totalPageCount }">末页</a>
             </c:when>
         </c:choose>
         	
         	到第<input value="${page.pageNow }" name="pn" id="pn_input" />页 
         	<input id="pn_btn" type="button" value="确定">
         
     </div>
</div>

<script type="text/javascript">
             //为按钮绑定一个单击响应函数
             $("#pn_btn").click(function() {
                 //获取到要跳转的页码
                 var pageNow = $("#pn_input").val();
                 //通过修改window.location属性跳转到另一个页面
                 window.location = "${pageContext.request.contextPath}/NewsControl/newsManage.do?pageNow=" + pageNow;
             });
</script>

<script type="text/javascript" src="/aaa/js/jquery-1.10.2.js"></script> 
<!-- 
<script> 
$(document).ready(function(){
  
   $("#delUser").click(function(){ 
    var user_Id=document.getElementsById("userId");
    var aa='';
    var index=document.getElementsById("index");
    for(var i=0;i<user_Id.length;i++){
         if(user_Id[i].checked){
            aa += user_Id[i].value+",";
        }
    };
    if(!aa){
        alert("请选择需要删除的数据！");return false;
    }
    if (confirm('确实要永久删除选择项吗？')){
     var  taskid =${user.user_Id};
  	 var  user = {
 
  };
        $.ajax({
       
          url:"${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=index",
          	data:{"delarray":aa,"taskid":taskid},
            type:'post',
            dataType:'text',
            contentType:'application/x-www-form-urlencoded; charset=utf-8',
            success:function(msg){
             if(msg==1){
                 alert('删除成功！');
             	window.location.href ="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=index";
          }else{
                alert('删除失败！');
          }
            }
             
        });
        }
  });
});
</script>
 -->
</body>
</html>
