<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分类搜索分页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 搜索分页 -->
    <!-- <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script> -->
	<script type="text/javascript">
		function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
}

function jump_to(frm,pageno){
    //alert(pageno);
	//验证用户的输入
	var regexp=/^[1-9]\d*$/;
	var totalPageCount = document.getElementById("totalPageCount").value;
	//alert(totalPageCount);
	if(!regexp.test(pageno)){
		alert("请输入大于0的正整数！");
		return false;
	}else if((pageno-totalPageCount) > 0){
		alert("请输入小于总页数的页码");
		return false;
	}else{
		page_nav(frm,pageno);
	}
}
	</script>
  </head>
  
  <body>
    <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${param.totalCount }条记录&nbsp;&nbsp; ${param.currentPageNo}/${param.totalPageCount}页</li>
				<c:if test="${param.currentPageNo > 1}">
					<a href="javascript:page_nav(document.forms[3],1);">首页</a>
					<a href="javascript:page_nav(document.forms[3],${param.currentPageNo-1});">上一页</a>
				</c:if>
				<c:if test="${param.currentPageNo < param.totalPageCount }">
					<a href="javascript:page_nav(document.forms[3],${param.currentPageNo+1 });">下一页</a>
					<a href="javascript:page_nav(document.forms[3],${param.totalPageCount });">最后一页</a>
				</c:if>
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" style="width: 10%" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[3],document.getElementById("inputPage").value)'>GO</button> 
		 <!--<button type="submit" class="page-btn"
                 onclick='go(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
                 -->
		</span>
		</div> 
  </body>

</html>
