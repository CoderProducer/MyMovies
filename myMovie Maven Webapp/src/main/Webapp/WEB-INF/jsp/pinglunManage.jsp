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

    <!-- 全选事件-->
    <script>
        function check() {
            var oInput=document.getElementsByName("pingluns");
            for(var i=0;i<oInput.length;i++){
                oInput[i].checked=document.getElementById("all").checked;
            }
            }
            //批量删除
			function alldel(){
				var f=false;
				//得到要删除的主键id
				var arr=new Array();//用于存要删除的选中的id值
				
				var pingluns=document.getElementsByName("pingluns");//得到一组checkbox  相当于数组
				alert("id值："+pingluns);
				//循环这一组checkbox让每一个checkbox选中
				for(var i=0;i<pingluns.length;i++){
					if(pingluns[i].checked==true){//代表选中
						arr.push(pingluns[i].value);
						f=true;
					}
				}
				
				//alert(arr);
				//跳到删除的servlet里去
				if(f==true){
					if(confirm("您确认要删除吗？"))
						location.href="${pageContext.request.contextPath}/ViewControl/viewAdminDelete.do?viewIds="+arr;
				}else{
					alert("请至少选中一条进行批量删除");
				}
			}
    </script>

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
</head>
<body >
<h4>评论总数 : <span>${page.totalCount }</span></h4>
    <div>
        <div>
            <div class="desc" >
                <ul style="list-style: none">
                    <input id="all" type="checkbox" style="float: left" value="" onclick="check();" />全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0);" onclick="alldel();">批量删除</a>
                    <!-- <input type="submit" value="删除"/> -->
                    <c:forEach var="viewlist2" items="${viewAdminList}">
                    <c:set value="${viewlist2.viewList }" var="h"/>
                    <c:forEach var="message" items="${h}">
                    <li>
                        <input type="checkbox" style="float: left" name="pingluns" value="${viewlist2.view_Id}" /><br>
                        <span style="float: left;color: red">评论者:${viewlist2.user.user_Name}&nbsp;&nbsp;&nbsp;
                        	时间:<df:formatDate value="${message.video_Published}" pattern="yyyy-MM-dd HH:mm:ss"></df:formatDate>&nbsp;&nbsp;&nbsp;视频名:${message.video_Name}&nbsp;&nbsp;&nbsp;</span>
                        <div class="branddesc" style="float: left">
                          ${viewlist2.view_Detail}
                        </div>
                        <div class="clearfix"> </div><br>
                    </li>
                    </c:forEach>
                    </c:forEach>                   
                </ul>
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
				                 <a href="${pageContext.request.contextPath}/ViewControl/pinglunManage.do?pageNow=1">首页</a> 
				                 <a href="${pageContext.request.contextPath}/ViewControl/pinglunManage.do?pageNow=${page.pageNow-1 }">上一页</a>
				             </c:when>
				         </c:choose>
				         <!-- 遍历页码 -->
				         <c:forEach begin="${begin }" end="${end }" var="index">
				             <c:choose>
				                 <c:when test="${page.pageNow == index }"><!-- 如果为当前页，则特殊显示 -->
				                     <a style="height:24px; margin:0 3px; border:none; background:#C00;">${index}</a>
				                 </c:when>
				                 <c:otherwise><!-- 否则，普通显示 -->
				                     <a href="${pageContext.request.contextPath}/ViewControl/pinglunManage.do?pageNow=${index }">${index }</a>
				                 </c:otherwise>
				             </c:choose>
				         </c:forEach>
				         <c:choose>
				             <c:when test="${page.pageNow != page.totalPageCount }"><!-- 如果当前页为总的记录数，则不显示末页和下一页 -->
				                 <a href="${pageContext.request.contextPath}/ViewControl/pinglunManage.do?pageNow=${page.pageNow+1 }">下一页</a> 
				                 <a href="${pageContext.request.contextPath}/ViewControl/pinglunManage.do?pageNow=${page.totalPageCount }">末页</a>
				             </c:when>
				         </c:choose>
				         	
				         	到第<input value="${page.pageNow }" name="pn" id="pn_input" />页 
				         	<input id="pn_btn" type="button" value="确定">			         
			     	</div>
		 	</div>
            <div class="clearfix"></div>            
        </div>
     </div>
</div>

<!-- 评论列表收起-->
<script type="text/javascript">
    (function($){
        $.fn.moreText = function(options){
            var defaults = {
                maxLength:50,
                mainCell:".branddesc",
                openBtn:'显示全部',
                closeBtn:'收起'
            };
            return this.each(function() {
                var _this = $(this);

                var opts = $.extend({},defaults,options);
                var maxLength = opts.maxLength;
                var TextBox = $(opts.mainCell,_this);
                var openBtn = opts.openBtn;
                var closeBtn = opts.closeBtn;

                var countText = TextBox.html();
                var newHtml = '';
                if(countText.length > maxLength){
                    newHtml = countText.substring(0,maxLength)+'...<span class="more">'+openBtn+'</span>';
                }else{
                    newHtml = countText;
                }
                TextBox.html(newHtml);
                TextBox.on("click",".more",function(){
                    if($(this).text()==openBtn){
                        TextBox.html(countText+' <span class="more">'+closeBtn+'</span>');
                    }else{
                        TextBox.html(newHtml);
                    }
                })
            })
        }
    })(jQuery);


    $(function(){
        //调用
        $(".desc ul li").moreText({
            maxLength: 100, //默认最大显示字数，超过...
            mainCell: '.branddesc' //文字容器
        });
    })
</script>
</body>
</html>
