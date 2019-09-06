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
    <title>电影详情页</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <link href="${pageContext.request.contextPath}/static/css/video-js.min.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/video.min.js"></script>
    <script>
        videojs.options.flash.swf = "video-js.swf";
    </script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/static/css/medile.css" rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath}/static/css/single.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/contactstyle.css" type="text/css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/faqstyle.css" type="text/css" media="all" />
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
    <link href="${pageContext.request.contextPath}/static/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
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
    <script src="${pageContext.request.contextPath}/static/js/simplePlayer.js"></script>
    <script>
        $("document").ready(function() {
            $("#video").simplePlayer();
        });
    </script>
    <script type="text/javascript">
    	function vPost(){
    		var viewDetail=document.getElementById("viewDetail").value;
    		var videoId=document.getElementById("videoId").value;
    		<!--var commentForm=document.getElementById("#handleForm");-->
    		<!--var time=new Date();-->
    	 	if(viewDetail==""){
				alert("评论不能为空！");
				}else{
				alert(viewDetail);
				alert(videoId);				
				window.location.href="${pageContext.request.contextPath}/ViewControl/viewPost.do?viewDetail="+viewDetail+"&videoId="+videoId;
				<!-- commentForm.submit(); -->
				};  
		         
        }
    </script> 
    <script type="text/javascript">
    	function getView() {
    		var videoId=document.getElementById("videoId").value;
			window.location.href = "${pageContext.request.contextPath}/ViewControl/moviePinglun.do?videoId="+videoId;
		}   
    </script>   
    <style type="text/css">
        a:hover{color: red;text-decoration: none;}
    </style>

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
                        <li><a href="${pageContext.request.contextPath}/NewsControl/news.do">新闻资讯</a></li>
                        <li><a href="${pageContext.request.contextPath}/UserControl/manage.do">个人中心</a></li>
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
    <div class="container">
        <!-- /w3l-medile-movies-grids -->
        <div class="agileits-single-top">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/PageVisitControl/index.do">首页</a></li>
                <li class="active">详情页</li>
            </ol>
        </div>

        <div class="single-page-agile-info">
            <!-- /movie-browse-agile -->
            <div class="show-top-grids-w3lagile">
                <div class="col-sm-8 single-left">
                   
                    <div class="song">
                        <div class="song-info">
                            <h3>${vDetail.video_Name }</h3>
                        </div>
                        <div class="video-grid-single-page-agileits">
                            <div data-video="dLmKio67pVQ" id="video"> <img src="${pageContext.request.contextPath}/${vDetail.video_PictureAddress }" alt="" class="img-responsive" /> </div>
                        </div>
                    </div>
                    <div class="song-grid-right">
                        <div class="share">
                            <h5>BD1280高清</h5>
                            <div>
                                <ul>
                                    <li><span>演员：</span>
                                    <c:forEach items="${mDetail }" var="message">
                                    ${message.actor_Name }&nbsp;&nbsp;
                                    </c:forEach>
                                    </li>
                                    <li><span>类型：</span>${vDetail.video_SmallType }&nbsp;&nbsp;</li>
                                    <li><span>地区：</span>${vDetail.video_Country }&nbsp;&nbsp;</li>
                                    <li><span>导演：</span>${vDetail.video_Director }&nbsp;&nbsp;</li>
                                    <li><span>上映时间：</span><df:formatDate value="${vDetail.video_Published}" pattern="yyyy-MM-dd"></df:formatDate>&nbsp;&nbsp;</li>
                                    <li><span>评分：</span>${vDetail.video_Point }&nbsp;&nbsp;</li>
                                    <li><span>片长：</span>${vDetail.video_Duration }&nbsp;&nbsp;</li>
                                    <li><span>剧情简介：</span>${vDetail.video_Introduce }&nbsp;&nbsp;</li>
                                
                                    </ul><br>
                                    <video controls="controls">
                                    <source src="${pageContext.request.contextPath}/${vDetail.video_Address }" type="video/webm"/>
							        <source src="${pageContext.request.contextPath}/${vDetail.video_Address }" type="video/mp4"/>
							        <source src="${pageContext.request.contextPath}/${vDetail.video_Address }" type="video/ogg"/>
                                    </video>
                                 <a href="${pageContext.request.contextPath}/VideoControl/player.do?video_Id={${vDetail.video_Id }" target="_blank"><input type="button" value="立即播放"></a><br><br> 
                                <a href="http://xunleib.zuida360.com/1812/X辰变-11.mp4" download="文件名" style="font-size: 20px">立即下载</a>   
                           
                            </div>

                        </div>
                    </div>
                    <div>
                        <!--<form id="handleForm" action="${pageContext.request.contextPath}/ViewControl/viewPost.do" method="post">  -->
                            <p style="font-size: 20px">评论框:&nbsp;&nbsp;&nbsp;<textarea style="height: 30px;width: 50%" id="viewDetail" name="viewDetail" placeholder="少于100字" maxlength="100"></textarea>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="hidden" id="videoId" value="${vDetail.video_Id }">
                            <a href="javascript:void(0);" onclick="vPost()">评论</a>
                            <!-- <input class="cf60" type="button" value="评论" onclick="vPost()"> -->
                            </p>                       		
                    </div>
                    <div class="clearfix"> </div><br>
                </div>

                <div class="col-md-4 single-right">
                <button onclick="getView();">查看评论</button>
                 <!--<a href="javascript:void(0);" onclick="getView();">查看评论</a>
                    <h3>网友留言:<button onclick="getView();"></button>查看评论</h3> -->                                    
                </div>
            </div>



            <div class="clearfix"> </div>
            </div>
            <!-- //movie-browse-agile -->
            <!--body wrapper start-->
            <div class="w3_agile_banner_bottom_grid">
                <div id="owl-demo" class="owl-carousel owl-theme">
                    <div class="item">
                        <div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
                            <a href="single.html" class="hvr-shutter-out-horizontal"><img src="images/m13.jpg" title="album-name" class="img-responsive" alt=" " />
                                <div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
                            </a>
                            <div class="mid-1 agileits_w3layouts_mid_1_home">
                                <div class="w3l-movie-text">
                                    <h6><a href="single.html">Citizen Soldier</a></h6>
                                </div>
                                <div class="mid-2 agile_mid_2_home">
                                    <p>2016</p>
                                    <div class="block-stars">
                                        <ul class="w3l-ratings">
                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <div class="ribben">
                                <p>NEW</p>
                            </div>
                        </div>
                    </div>                                    
                </div>
            </div>
            <!--body wrapper end-->


        </div>
        <!-- //w3l-latest-movies-grids -->
    </div>
</div>
<!-- //w3l-medile-movies-grids -->

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
<!-- //here ends scrolling icon -->
</body>
</html>