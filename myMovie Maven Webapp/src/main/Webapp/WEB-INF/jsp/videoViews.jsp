<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="df" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>视频详情评论列表</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/static/css/medile.css" rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath}/static/css/single.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/contactstyle.css" type="text/css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/faqstyle.css" type="text/css" media="all" />
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
    <!-- //font-awesome icons -->
    <!-- news-css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/news-css/news.css" type="text/css" media="all" />
    <!-- //news-css -->
    <!-- list-css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/list-css/list.css" type="text/css" media="all" />
    <!-- //list-css -->
    <!-- js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!---<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>--->
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/move-top.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
    <!-- 评论列表收起-->
	<script>
	    (function($){
	        $.fn.moreText = function(options){
	            var defaults = {
	                maxLength:50,
	                mainCell:".branddesc",
	                openBtn:'显示全部',
	                closeBtn:'收起'
	            }
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
	            maxLength: 50, //默认最大显示字数，超过...
	            mainCell: '.branddesc' //文字容器
	        });
	    })
	</script>
    <script src="${pageContext.request.contextPath}/static/js/owl.carousel.js"></script>
    <script>
        $(document).ready(function() {
            $("#owl-demo").owlCarousel({

                autoPlay: 3000, //Set AutoPlay to 3 seconds

                items : 5,
                itemsDesktop : [640,5],
                itemsDesktopSmall : [414,4]

            });

        });
    </script>

   
</head>

<body>
<!-- header -->
<div class="header">
    <div class="container">
        <div class="w3layouts_logo">
            <a href="${pageContext.request.contextPath}/PageVisitControl/index.do"><h1>My<span>Movies</span></h1></a>
        </div>
        <div class="w3_search">
            <form action="${pageContext.request.contextPath}/UserControl/searchList.do" method="post">
                <input type="text" name="videoSearch" value="${videoSearch }" placeholder="Search" required="required">
                 <input type="hidden" name="pageIndex" value="1"/>
                <input type="submit" value="搜索">               
            </form>
        </div>
        <div class="w3l_sign_in_register">
			<ul>
                <li><i class="fa fa-phone" aria-hidden="true"></i> (+000) 123 345 653</li>
                <c:set var="isLogin" value="${empty sessionScope.user}"></c:set>
                <c:if test="${isLogin}">
   		  		<li><a href="${pageContext.request.contextPath}/PageVisitControl/UserLogin.do">用户登录</a></li>&nbsp;   	
   		  		<li><a href="${pageContext.request.contextPath}/PageVisitControl/reg.do">用户注册</a></li>&nbsp;	
   				</c:if>
   				<c:if test="${!isLogin}">
   				<li><a href="#" data-toggle="modal" data-target="#myModal" id="login03">您好！${username}</a></li>&nbsp;   	
   				<li><a href="#" data-toggle="modal" data-target="#myModal" id="login04">退出</a></li>&nbsp;				
   				</c:if>
            </ul>	
		</div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //header -->
<!-- bootstrap-pop-up -->
<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                登录 & 注册
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <section>
                <div class="modal-body">
                    <div class="w3_login_module">
                        <div class="module form-module">
                            <div class="toggle"><i class="fa fa-times fa-pencil"></i>
                                <div class="tooltip">点我</div>
                            </div>
                            <div class="form">
                                <h3>账户登录</h3>
                                <form action="${pageContext.request.contextPath}/LoginControl/UserLogin.do" method="post">
                                    <input type="text" name="Username" placeholder="用户名" required="">
                                    <input type="password" name="Password" placeholder="密码" required="">
                                    <input type="submit" value="登录">
                                </form>
                            </div>
                            <div class="form">
                                <h3>账户注册</h3>
                                <form action="${pageContext.request.contextPath}/RegisterControl/reg.do" method="post">
                                     <input type="text" name="Username" placeholder="用户名" required="required" onblur="checkUserName()">
                                     <span id="span01" style="float: right">不可用</span>
                                     <input type="password" name="Password" placeholder="密码" required="required">
                                     <input type="password" name="Repassword" placeholder="确认密码" required="required">
                                     <input type="email" name="Email" placeholder="邮箱号码" required="">
                                     <input type="text" name="Phone" placeholder="电话号码" required="">
                                     <input type="submit" value="注册">
                                </form>
                            </div>
                            <div class="cta"><a href="#">忘记密码?</a></div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
<script>
    $('.toggle').click(function(){
        // Switches the Icon
        $(this).children('i').toggleClass('fa-pencil');
        // Switches the forms
        $('.form').animate({
            height: "toggle",
            'padding-top': 'toggle',
            'padding-bottom': 'toggle',
            opacity: "toggle"
        }, "slow");
    });
</script>
<!-- //bootstrap-pop-up -->
<!-- nav -->
<div class="movies_nav">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="navbar-header navbar-left">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                <nav>
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/VideoControl/index.do">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/movie.do">电影</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/series.do">电视剧</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/comic.do">动漫</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/variety.do">综艺</a></li>
                        <li><a href="${pageContext.request.contextPath}/NewsControl/news.do">新闻资讯</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/UserControl/manage.do">个人中心</a></li>
                    </ul>
                </nav>
            </div>
        </nav>
    </div>
</div>
<!-- //nav -->
<div class="general_social_icons">
    <nav class="social">
        <ul>
            <li class="w3_twitter"><a href="#">Twitter <i class="fa fa-twitter"></i></a></li>
            <li class="w3_facebook"><a href="#">Facebook <i class="fa fa-facebook"></i></a></li>
            <li class="w3_dribbble"><a href="#">Dribbble <i class="fa fa-dribbble"></i></a></li>
            <li class="w3_g_plus"><a href="#">Google+ <i class="fa fa-google-plus"></i></a></li>
        </ul>
    </nav>
</div>

<!-- single -->
<div class="single-page-agile-main">
    <!--/browse-agile-w3ls -->
    <div class="browse-agile-w3ls general-w3ls">
        <div class="tittle-head">
            <h4 class="latest-text">评论列表 </h4>
            <div class="container">
                <div class="agileits-single-top">
                    <ol class="breadcrumb">
                        <li><a href="${pageContext.request.contextPath}/VideoControl/index.do">首页</a></li>
                        <li class="active">相关评论</li>
                    </ol>
                </div>
            </div>
        </div>
    <div class="container">
    	<div><a href="javascript:history.back()"  style="color: red;">返回上一界面</a></div>
                <div class="w3ls-news-result">
                    <h4>评论总数 : <span>${pages.totalCount }</span></h4>
                </div>

        <div class="single-page-agile-info">
            <!-- /movie-browse-agile -->
            <div class="show-top-grids-w3lagile">
                <div class="col-sm-8 single-left">                    
                    <div class="single-grid-right">
                        <div class="single-right-grids">

                            <div class="desc">
                                <ul style="list-style: none">
                                   <c:forEach var="message" items="${movieViewList}">                                                                   
                                   <li><span style="float: left; color: red">
                                   	   <df:formatDate value="${message.view_Date}" pattern="yyyy-MM-dd HH:mm:ss"></df:formatDate>
                                   		&nbsp;&nbsp;&nbsp;${message.user.user_Name}:&nbsp;&nbsp;&nbsp;
                                   	   </span>                                       
                                        <div class="branddesc" style="float: left">
                                           ${message.view_Detail}
                                        </div>
                                        <div class="clearfix"> </div><br>
                                    </li>                                   
                                    </c:forEach>                                   
                                </ul>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                  
                </div>
            </div>
            <div class="clearfix"> </div>
		<!--//browse-agile-w3ls -->
		<div class="blog-pagenat-wthree">
			<span style="text-align: left;">共${pages.totalPageCount }页，${pages.totalCount }条记录 </span>
				<div class="page_nav">
		         <c:choose>
		             <c:when test="${pages.totalPageCount <= 10}"><!-- 如果总页数小于10，则全部显示 -->
		                 <c:set var="begin" value="1"></c:set>
		                 <c:set var="end" value="${pages.totalPageCount }"></c:set>
		             </c:when>
		             <c:when test="${pages.pageNow <= 5 }"><!-- 如果总页数小于5，则显示1-10页 -->
		                 <c:set var="begin" value="1"></c:set>
		                 <c:set var="end" value="10"></c:set>
		             </c:when>
		             <c:otherwise><!-- 否则，显示前5页和后5页，保证当前页在中间 -->
		                 <c:set var="begin" value="${pages.pageNow }"></c:set>
		                 <c:set var="end" value="${pages.pageNow+5 }"></c:set>
		                 <c:if test="${end > pages.totalPageCount }"><!-- 如果end值小于总的记录数，则显示最后10页 -->
		                     <c:set var="end" value="${pages.totalPageCount}"></c:set>
		                     <c:set var="begin" value="${end-10 }"></c:set>
		                 </c:if>
		             </c:otherwise>
		         </c:choose>
		         <c:choose>
		             <c:when test="${pages.pageNow != 1 }"><!-- 如果当前页为1，则不显示首页和上一页 -->
					 <a href="${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=1&videoId=${videoId}">首页</a> 
					 <a href="${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=${pages.pageNow-1 }&videoId=${videoId}">上一页</a>
					 </c:when>
		         </c:choose>
		         <!-- 遍历页码 -->
		         <c:forEach begin="${begin }" end="${end }" var="index">
		             <c:choose>
		                 <c:when test="${pages.pageNow == index }"><!-- 如果为当前页，则特殊显示 -->
		                     <a style="height:24px; margin:0 3px; border:none; background:#C00;">${index}</a>
		                 </c:when>
		                 <c:otherwise><!-- 否则，普通显示 -->
		                     <a href="${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=${index }&videoId=${videoId}">${index }</a>
		                 </c:otherwise>
		             </c:choose>
		         </c:forEach>
		         <c:choose>
		             <c:when test="${pages.pageNow != pages.totalPageCount }"><!-- 如果当前页为总的记录数，则不显示末页和下一页 -->
		                 <a href="${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=${pages.pageNow+1 }&videoId=${videoId}">下一页</a> 
		                 <a href="${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=${pages.totalPageCount }&videoId=${videoId}">末页</a>
		             </c:when>
		         </c:choose>
		         	
		         	到第<input value="${pages.pageNow }" name="pn" id="pn_input" />页 
		         	<input id="pn_btn" type="button" value="确定">
		         
		     </div>
		 </div>
            <div class="clearfix"></div>            
        </div>
</div>


<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="w3ls_footer_grid">
            <div class="col-md-6 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_left1">
                    <h2>Subscribe to us</h2>
                    <div class="w3ls_footer_grid_left1_pos">
                        <form action="#" method="post">
                            <input type="email" name="email" placeholder="Your email..." required="">
                            <input type="submit" value="Send">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6 w3ls_footer_grid_right">
                <a href="${pageContext.request.contextPath}/PageVisitControl/index.do"><h2>My<span>Movies</span></h2></a>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="col-md-5 w3ls_footer_grid1_left">
            <p>Copyright &copy; 2019.School name All rights reserved.More Details <a href="www.jxust.cn/" target="_blank" title="江理之家">江理之家</a> - Collect from <a href="www.jxust.cn/" title="江理之家" target="_blank">江理之家</a></p>
        </div>
        <div class="col-md-7 w3ls_footer_grid1_right">
            <ul>
                <li>
                    <a href="genres.html">Movies</a>
                </li>
                <li>
                    <a href="faq.html">FAQ</a>
                </li>
                <li>
                    <a href="horror.html">Action</a>
                </li>
                <li>
                    <a href="genres.html">Adventure</a>
                </li>
                <li>
                    <a href="comedy.html">Comedy</a>
                </li>
                <li>
                    <a href="icons.html">Icons</a>
                </li>
                <li>
                    <a href="contact.html">Contact Us</a>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $(".dropdown").hover(
            function() {
                $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
                $(this).toggleClass('open');
            },
            function() {
                $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
                $(this).toggleClass('open');
            }
        );
    });
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
            var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
            };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>

    <!-- 评论页面填数字分页 -->
    <script type="text/javascript">
		             //为按钮绑定一个单击响应函数
		             $("#pn_btn").click(function() {
		                 //获取到要跳转的页码
		                 var pageNow = $("#pn_input").val();
		                 //通过修改window.location属性跳转到另一个页面
		                 window.location = "${pageContext.request.contextPath}/ViewControl/moviePinglun.do?pageNow=" + pageNow+"&videoId="+${videoId};
		             });
		</script>
<!-- //here ends scrolling icon -->
</body>
</html>