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
    <title>用户注册</title>
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
<!-- bootstrap-pop-up 
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
-->
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
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            登录 & 注册
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><a href="${pageContext.request.contextPath}/VideoControl/index.do"><span style="color: black;font-size: small">返回首页</span></a></span></button>
                        </div>
                        <section>
                            <div class="modal-body">
                                <div class="w3_login_module">
                                    <div class="module form-module">
                                        <div class="toggle"><i class="fa fa-times fa-pencil"></i>
                                            <div class="tooltip">点我</div>
                                        </div>
                                        <div class="form">
                                            <h3>账户注册</h3>
                                            <form action="${pageContext.request.contextPath}/RegisterControl/reg.do" method="post">
                                                <input type="text" id="userName" name="Username" placeholder="用户名" required="required" onblur="checkUserName()">
                                                <span id="span01" style="float: right"></span>
                                                <input type="password" id="password" name="Password" placeholder="密码" required="required">
                                                <span id="span02" style="float: right"></span>
                                                <input type="password" id="repassword" name="Repassword" placeholder="确认密码" required="required">
                                                <span id="span03" style="float: right"></span>
                                                <input type="email" name="Email" placeholder="邮箱号码" required="">
                                                <input type="text" name="Phone" placeholder="电话号码" required="">
                                                <input type="submit" value="注册">
                                            </form>
                                        </div>
                                        <div class="form">
                                            <h3>账户登录</h3>
                                            <form action="${pageContext.request.contextPath}/LoginControl/UserLogin.do" method="post">
                                    			<input type="text" name="Username" placeholder="用户名" required="">
                                    			<input type="password" name="Password" placeholder="密码" required="">
                                    			<input type="submit" value="登录">
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
        <!-- 点我功能 -->
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
                <a href="${pageContext.request.contextPath}/PageVisitControl/index.do"><h2>my<span>Movies</span></h2></a>
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