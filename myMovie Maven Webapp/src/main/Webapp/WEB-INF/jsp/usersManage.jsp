<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        body {font-size: 20px;
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
</head>
<body >
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/UserControl/usersManage.do" method="post">
    <span style="color: #777777"><strong>用户名：</strong></span>
    <input type="text" name="menuname" id="menuname" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>电话号码</th>
        <th>邮箱号码</th>
        <th>QQ号码</th>
        <th>管理用户</th>
    </tr>
    </thead>
    
    <c:forEach var="user" items="${uList}">
    		<tr>
					<td id="userId">${user.user_Id}</td>
					<td>${user.user_Name}</td>
					<td>${user.user_Tel}</td>
					<td>${user.user_Email}</td>
					<td>${user.user_QQ}</td>
					<td><a id="delUser" href="${pageContext.request.contextPath}/UserControl/usersDeleteById.do?user_Id=${user.user_Id }">删除</a></td>
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
                 <a href="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=1">首页</a> 
                 <a href="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=${page.pageNow-1 }">上一页</a>
             </c:when>
         </c:choose>
         <!-- 遍历页码 -->
         <c:forEach begin="${begin }" end="${end }" var="index">
             <c:choose>
                 <c:when test="${page.pageNow == index }"><!-- 如果为当前页，则特殊显示 -->
                     <a style="height:24px; margin:0 3px; border:none; background:#C00;">${index}</a>
                 </c:when>
                 <c:otherwise><!-- 否则，普通显示 -->
                     <a href="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=${index }">${index }</a>
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <c:choose>
             <c:when test="${page.pageNow != page.totalPageCount }"><!-- 如果当前页为总的记录数，则不显示末页和下一页 -->
                 <a href="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=${page.pageNow+1 }">下一页</a> 
                 <a href="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=${page.totalPageCount }">末页</a>
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
                 window.location = "${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=" + pageNow;
             });
</script>
<script type="text/javascript" src="/aaa/js/jquery-1.10.2.js"></script> 
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
       
          url:"${pageContext.request.contextPath}/UserControl/usersDeleteById.do",
          	data:{"delarray":aa,"taskid":taskid},
            type:'post',
            dataType:'text',
             contentType:'application/x-www-form-urlencoded; charset=utf-8',
            success:function(msg){
             if(msg==1){
                 alert('删除成功！');
             	window.location="${pageContext.request.contextPath}/UserControl/usersManage.do?pageNow=index";
          }else{
                alert('删除失败！');
          }
            }
             
        });
        }
  });
  
});
</script>

</body>
</html>
