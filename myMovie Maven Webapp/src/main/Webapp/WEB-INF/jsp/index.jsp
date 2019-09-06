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
	<title>首页</title>
	<!-- for-mobile-apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/contactstyle.css" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/faqstyle.css" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/static/css/single.css" rel='stylesheet' type='text/css' />
	<link href="${pageContext.request.contextPath}/static/css/medile.css" rel='stylesheet' type='text/css' />
	<!-- banner-slider -->
	<link href="${pageContext.request.contextPath}/static/css/jquery.slidey.min.css" rel="stylesheet">
	<!-- //banner-slider -->
	<!-- pop-up -->
	<link href="${pageContext.request.contextPath}/static/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //pop-up -->
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
	<!-- //font-awesome icons -->
	<!-- js -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
	<!-- //js -->
	<!-- banner-bottom-plugin -->
	<link href="${pageContext.request.contextPath}/static/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
	<script src="${pageContext.request.contextPath}/static/js/owl.carousel.js"></script>
	<script>
        $(document).ready(function() {        
            $("#owl-demo").owlCarousel({

                autoPlay: 3000, //Set AutoPlay to 3 seconds

                items : 5,
                itemsDesktop : [640,4],
                itemsDesktopSmall : [414,3]

            });                      
		　　　　
        });
	</script>
	
	<!-- //banner-bottom-plugin -->
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
								<form action="${pageContext.request.contextPath}/PageVisitControl/UserLogin.do" method="post">
									<input type="text" name="Username" placeholder="Username" required="">
									<input type="password" name="Password" placeholder="Password" required="">
									<input type="submit" value="登录">
								</form>
							</div>
							<div class="form">
								<h3>账户注册</h3>
								<form action="${pageContext.request.contextPath}/PageVisitControl/reg.do" method="post">
									<input type="text" name="Username" placeholder="Username" required="">
									<input type="password" name="Password" placeholder="Password" required="">
									<input type="email" name="Email" placeholder="Email Address" required="">
									<input type="text" name="Phone" placeholder="Phone Number" required="">
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
						<li class="active"><a href="${pageContext.request.contextPath}/VideoControl/index.do">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/movie.do">电影</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/series.do">电视剧</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/comic.do">动漫</a></li>
                        <li><a href="${pageContext.request.contextPath}/VideoControl/variety.do">综艺</a></li>
                        <li><a href="${pageContext.request.contextPath}/NewsControl/news.do">新闻资讯</a></li>
                        <li><a href="${pageContext.request.contextPath}/UserControl/manage.do">个人中心</a></li>
                    </ul>
				</nav>
			</div>
		</nav>
	</div>
</div>
<!-- //nav -->
<!-- banner -->
<div id="slidey" style="display:none;">	
	<ul>
	<c:forEach items="${mIndexList4 }" var="mIndex4">
		<li>
			<img src="${pageContext.request.contextPath}/static/images/2.jpg" alt=" ">
			<p class='title'>${mIndex4.video_Name}</p><p class='description'>${mIndex4.video_Introduce}</p>
		</li>
	</c:forEach>
	</ul>	
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.slidey.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.dotdotdot.min.js"></script>
<script type="text/javascript">
    $("#slidey").slidey({
        interval: 8000,
        listCount: 5,
        autoplay: false,
        showList: true
    });
    $(".slidey-list-description").dotdotdot();
</script>
<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
	<div class="container">
		<div class="w3_agile_banner_bottom_grid">
			<div id="owl-demo" class="owl-carousel owl-theme">
			<c:forEach items="${mIndexList5 }" var="mIndex5">
				<div class="item">
					<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
						<a href="${pageContext.request.contextPath}/PageVisitControl/single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/inages/m13.jpg" title="album-name" class="img-responsive" alt=" " />
							<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
						</a>
						<div class="mid-1 agileits_w3layouts_mid_1_home">
							<div class="w3l-movie-text">
								<h6><a href="${pageContext.request.contextPath}/PageVisitControl/single.html">${mIndex5.video_Name}</a></h6>
							</div>
							<div class="mid-2 agile_mid_2_home">
								<p><df:formatDate value="${mIndex5.video_Published}" pattern="yyyy-MM-dd"></df:formatDate></p>
								<div class="block-stars">
									评分:${mIndex5.video_Point}
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="ribben">
							<p>NEW</p>
						</div>
					</div>
				</div>
			</c:forEach>					
			</div>
		</div>
	</div>
</div>
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >电影网站</a></div>
<!-- //banner-bottom -->
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
<!-- general -->
<div class="general">
	<h4 class="latest-text w3_latest_text">特色电影 </h4>
	<div class="container">
		<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
			<ul id="myTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">按热度</a></li>
				<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="true">按评分</a></li>
				<li role="presentation"><a href="#rating" id="rating-tab" role="tab" data-toggle="tab" aria-controls="rating" aria-expanded="true">按时间</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
					<div class="w3_agile_featured_movies">
					<c:forEach items="${mIndexList2 }" var="mIndex2">
						<div class="col-md-2 w3l-movie-gride-agile">
						
							<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m15.jpg" title="album-name" class="img-responsive" alt=" " />
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h6><a href="single.html">${mIndex2.video_Name}</a></h6>
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p><df:formatDate value="${mIndex2.video_Published}" pattern="yyyy-MM-dd"></df:formatDate></p>
									<div class="block-stars">										
										评分:${mIndex2.video_Point}
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="w3l-movie-text">
									<h6 style="float: left;"><a href="#">热度:${mIndex2.video_HotPoint}</a></h6>
								</div>
							</div>
							<div class="ribben">
								<p>NEW</p>
							</div>
						
						</div>
						</c:forEach>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
					<c:forEach items="${mIndexList1 }" var="mIndex1">
					<div class="col-md-2 w3l-movie-gride-agile">
					
						<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m22.jpg" title="album-name" class="img-responsive" alt=" " />
							<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
						</a>
						<div class="mid-1 agileits_w3layouts_mid_1_home">
							<div class="w3l-movie-text">
								<h6><a href="single.html">${mIndex1.video_Name}</a></h6>
							</div>
							<div class="mid-2 agile_mid_2_home">
								<p><df:formatDate value="${mIndex1.video_Published}" pattern="yyyy-MM-dd"></df:formatDate></p>
								<div class="block-stars">
										评分:${mIndex1.video_Point}
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="ribben">
							<p>NEW</p>
						</div>					
					</div>
					</c:forEach>
					<div class="clearfix"> </div>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="rating" aria-labelledby="rating-tab">
					<c:forEach items="${mIndexList3 }" var="mIndex3">
					<div class="col-md-2 w3l-movie-gride-agile">					
						<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m7.jpg" title="album-name" class="img-responsive" alt=" " />
							<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
						</a>
						<div class="mid-1 agileits_w3layouts_mid_1_home">
							<div class="w3l-movie-text">
								<h6><a href="single.html">${mIndex3.video_Name}</a></h6>
							</div>
							<div class="mid-2 agile_mid_2_home">
								<p><df:formatDate value="${mIndex3.video_Published}" pattern="yyyy-MM-dd"></df:formatDate></p>
								<div class="block-stars">
									评分:${mIndex3.video_Point}
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="ribben">
							<p>NEW</p>
						</div>					
					</div>		
					</c:forEach>	
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- //general -->
<!-- Latest-tv-series -->
<div class="Latest-tv-series">
	<h4 class="latest-text w3_latest_text w3_home_popular">近期上映</h4>
	<div class="container">
		<section class="slider">
			<div class="flexslider">
				<ul class="slides">
					<li>
						<div class="agile_tv_series_grid">
							<div class="col-md-6 agile_tv_series_grid_left">
								<div class="w3ls_market_video_grid1">
									<img src="${pageContext.request.contextPath}/static/images/h1-1.jpg" alt=" " class="img-responsive" />
									<a class="w3_play_icon" href="#small-dialog">
										<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
									</a>
								</div>
							</div>
							<div class="col-md-6 agile_tv_series_grid_right">
								<p class="fexi_header">the conjuring 2</p>
								<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> 720p,Bluray HD Free Movie Downloads, Watch Free Movies Online with high speed Free Movie Streaming | MyDownloadTube Lorraine and Ed Warren go to north London to help a single...</p>
								<p class="fexi_header_para"><span>Date of Release<label>:</label></span> Jun 10, 2016 </p>
								<p class="fexi_header_para">
									<span>Genres<label>:</label> </span>
									<a href="genres.html">Drama</a> |
									<a href="genres.html">Adventure</a> |
									<a href="genres.html">Family</a>
								</p>
								<p class="fexi_header_para fexi_header_para1"><span>Star Rating<label>:</label></span>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								</p>
							</div>
							<div class="clearfix"> </div>
							<div class="agileinfo_flexislider_grids">
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m22.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Assassin's Creed 3</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m2.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Bad Moms</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m9.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Central Intelligence</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m7.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Light B/t Oceans</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m11.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">X-Men</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m17.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Peter</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</li>
					<li>
						<div class="agile_tv_series_grid">
							<div class="col-md-6 agile_tv_series_grid_left">
								<div class="w3ls_market_video_grid1">
									<img src="${pageContext.request.contextPath}/static/images/h2-1.jpg" alt=" " class="img-responsive" />
									<a class="w3_play_icon1" href="#small-dialog1">
										<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
									</a>
								</div>
							</div>
							<div class="col-md-6 agile_tv_series_grid_right">
								<p class="fexi_header">a haunting in cawdor</p>
								<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> Vivian Miller, sent to a rehabilitation programme for young offenders, where a theatre camp is used as an alternative to jail time. After she views tape ...</p>
								<p class="fexi_header_para"><span>Date of Release<label>:</label></span> Oct 09, 2015 </p>
								<p class="fexi_header_para">
									<span>Genres<label>:</label> </span>
									<a href="genres.html">Thriller</a> |
									<a href="genres.html">Horror</a>
								</p>
								<p class="fexi_header_para fexi_header_para1"><span>Star Rating<label>:</label></span>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								</p>
							</div>
							<div class="clearfix"> </div>
							<div class="agileinfo_flexislider_grids">
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m2.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Bad Moms</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m9.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Central Intelligence</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m7.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Light B/t Oceans</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m11.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">X-Men</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m17.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Peter</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m21.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">The Jungle Book</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</li>
					<li>
						<div class="agile_tv_series_grid">
							<div class="col-md-6 agile_tv_series_grid_left">
								<div class="w3ls_market_video_grid1">
									<img src="${pageContext.request.contextPath}/static/images/h3-1.jpg" alt=" " class="img-responsive" />
									<a class="w3_play_icon2" href="#small-dialog2">
										<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
									</a>
								</div>
							</div>
							<div class="col-md-6 agile_tv_series_grid_right">
								<p class="fexi_header">civil war captain America</p>
								<p class="fexi_header_para"><span class="conjuring_w3">Story Line<label>:</label></span> After the Avengers leaves some&nbsp;collateral damage, political pressure mounts to install a system of accountability.&nbsp;The new status quo deeply divides ...</p>
								<p class="fexi_header_para"><span>Date of Release<label>:</label></span> May 06, 2016 </p>
								<p class="fexi_header_para">
									<span>Genres<label>:</label> </span>
									<a href="genres.html">Action</a> |
									<a href="genres.html">Adventure</a>
								</p>
								<p class="fexi_header_para fexi_header_para1"><span>Star Rating<label>:</label></span>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
								</p>
							</div>
							<div class="clearfix"> </div>
							<div class="agileinfo_flexislider_grids">
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m2.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Bad Moms</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m9.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Central Intelligence</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m7.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Light B/t Oceans</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m11.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">X-Men</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m17.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">Peter</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${pageContext.request.contextPath}/static/images/m20.jpg" title="album-name" class="img-responsive" alt=" " />
										<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
									</a>
									<div class="mid-1 agileits_w3layouts_mid_1_home">
										<div class="w3l-movie-text">
											<h6><a href="single.html">The Secret Life of Pets</a></h6>
										</div>
										<div class="mid-2 agile_mid_2_home">
											<p>2016</p>
											<div class="block-stars">
												<ul class="w3l-ratings">
													<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</section>
		<!-- flexSlider -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/flexslider.css" type="text/css" media="screen" property="" />
		<script defer src="${pageContext.request.contextPath}/static/js/jquery.flexslider.js"></script>
		<script type="text/javascript">
            $(window).load(function(){
                $('.flexslider').flexslider({
                    animation: "slide",
                    start: function(slider){
                        $('body').removeClass('loading');
                    }
                });
            });
		</script>
		<!-- //flexSlider -->
	</div>
</div>
<!-- pop-up-box -->
<script src="${pageContext.request.contextPath}/static/js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box -->
<div id="small-dialog" class="mfp-hide">
	<!---<iframe src="https://player.vimeo.com/video/164819130?title=0&byline=0"></iframe>--->
</div>
<div id="small-dialog1" class="mfp-hide">
	<!---<iframe src="https://player.vimeo.com/video/148284736"></iframe>--->
</div>
<div id="small-dialog2" class="mfp-hide">
	<!---<iframe src="https://player.vimeo.com/video/165197924?color=ffffff&title=0&byline=0&portrait=0"></iframe>--->
</div>
<script>
    $(document).ready(function() {
        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
<!-- //Latest-tv-series -->
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
				<a href="${pageContext.request.contextPath}/PageVisitControl/index.do"><h2>One<span>Movies</span></h2></a>
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
      //成功登录显示名字
  window.onload=function(){
        alert("成功");
        var username ='<%=session.getAttribute("username")%>';
        if(username!="null"){
        alert("登陆成功！");
        document.getElementById("userLogin").innerHTML="<a href='${pageContext.request.contextPath}/PageVisitControl/UserLogin.do' target='_blank'>"+username+",你好</a>";
        }
</script>
<!-- //here ends scrolling icon -->
</body>
</html>