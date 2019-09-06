<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="df" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>新闻</title>
	<!-- for-mobile-apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/faqstyle.css" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/static/css/single.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/contactstyle.css" type="text/css" media="all" />
	<!-- news-css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/news-css/news.css" type="text/css" media="all" />
	<!-- //news-css -->
	<!-- list-css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/list-css/list.css" type="text/css" media="all" />
	<!-- //list-css -->
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
	<!-- //font-awesome icons -->
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
   				<li><a href="${pageContext.request.contextPath}/PageVisitControl/userExit.do">退出</a></li>&nbsp;				
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
                                     <input type="text" name="Username" placeholder="用户名" required="required">                                
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
                        <li class="active"><a href="${pageContext.request.contextPath}/NewsControl/news.do">新闻资讯</a></li>
                        <li><a href="${pageContext.request.contextPath}/PageVisitControl/manage.do">个人中心</a></li>
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
<!-- faq-banner -->
<div class="faq">
	<div class="container">
		<div class="agileits-news-top">
			<ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/PageVisitControl/index.do">首页</a></li>
                <li class="active">新闻</li>
            </ol>
		</div>
		<div class="agileinfo-news-top-grids">
			<div class="col-md-8 wthree-top-news-left">
			
				<div class="wthree-news-left">
					<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
						<ul id="myTab" class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#home1" id="home1-tab" role="tab" data-toggle="tab" aria-controls="home1" aria-expanded="true">Latest News</a></li>
							<li role="presentation"><a href="#w3bsd" role="tab" id="w3bsd-tab" data-toggle="tab" aria-controls="w3bsd">Movie News</a></li>
						</ul>
						
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade in active" id="home1" aria-labelledby="home1-tab">
								<div class="wthree-news-top-left">
								<c:forEach items="${newsList }" var="news">
									<div class="col-md-6 w3-agileits-news-left">
										<div class="col-sm-5 wthree-news-img">
											<a href="news-single.html"><img src="${pageContext.request.contextPath}/static/images/m1.jpg" width="344px" height="200px"  alt="" /></a>
										</div>
										<div class="col-sm-7 wthree-news-info">
											<h5><a href="news-single.html">新闻标题：${news.news_Title }</a></h5>
											<span style="padding-bottom: 0px">											
											<ul>											
												<li>新闻简介：${news.news_Introduce }</li>												
												<li><i class="fa fa-eye" aria-hidden="true"></i>相关视频：${news.news_VideoTitle }</li>
												<li><i class="fa fa-clock-o" aria-hidden="true"></i> 更新日期:&nbsp;<df:formatDate value="${news.news_Date }" pattern="yyyy-MM-dd"></df:formatDate></li>													
											</ul>
											</span>
										</div>
										<div class="clearfix"> </div>
									</div>
									
								</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 wthree-news-right">
				<!-- news-right-top -->
				<div class="news-right-top">
					<div class="wthree-news-right-heading">
						<h3>Updated News</h3>
					</div>
					<div class="wthree-news-right-top">
						<div class="news-grids-bottom">
							<!-- date -->
							<div id="design" class="date">
								<div id="cycler">
									<div class="date-text">
										<a href="news-single.html">August 15,2016</a>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
									</div>
									<div class="date-text">
										<a href="news-single.html">July 08,2016 <span class="blinking"><img src="images/new.png" alt="" /></span></a>
										<p>Nullam non turpis sit amet metus tristique egestas et et orci.</p>
									</div>

									<div class="date-text">
										<a href="news-single.html">September 24,2016</a>
										<p>In lobortis ipsum mi, ac imperdiet elit pellentesque at.</p>
									</div>
								</div>
								<script>
                                    function blinker() {
                                        $('.blinking').fadeOut(500);
                                        $('.blinking').fadeIn(500);
                                    }
                                    setInterval(blinker, 1000);
								</script>
								<script>
                                    function cycle($item, $cycler){
                                        setTimeout(cycle, 2000, $item.next(), $cycler);

                                        $item.slideUp(1000,function(){
                                            $item.appendTo($cycler).show();
                                        });
                                    }
                                    cycle($('#cycler div:first'),  $('#cycler'));
								</script>
							</div>
							<!-- //date -->
						</div>
					</div>
				</div>
				<!-- //news-right-top -->
				<!-- news-right-bottom -->
				<div class="news-right-bottom">
					<div class="wthree-news-right-heading">
						<h3>Top News</h3>
					</div>
					<div class="news-right-bottom-bg">
						<div class="news-grids-bottom">
							<div class="top-news-grid">
								<div class="top-news-grid-heading">
									<a href="news-single.html">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean rutrum ac nulla</a>
								</div>
								<div class="w3ls-news-t-grid top-t-grid">
									<ul>
										<li><a href="#"><i class="fa fa-clock-o"></i> 1h</a></li>
										<li><a href="#"><i class="fa fa-user"></i> Vivamus nibh</a></li>
									</ul>
								</div>
							</div>
							<div class="top-news-grid">
								<div class="top-news-grid-heading">
									<a href="news-single.html">Duis orci enim, rutrum vel sodales ut, tincidunt nec turpis.</a>
								</div>
								<div class="w3ls-news-t-grid top-t-grid">
									<ul>
										<li><a href="#"><i class="fa fa-clock-o"></i> 3h</a></li>
										<li><a href="#"><i class="fa fa-user"></i> Cras pretium</a></li>
									</ul>
								</div>
							</div>

						</div>
					</div>
				</div>
				<!-- //news-right-bottom -->
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //faq-banner -->
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
<!-- //here ends scrolling icon -->
</body>
</html>