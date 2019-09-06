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
    <title>综艺</title>
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
    <link href="${pageContext.request.contextPath}/static/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
    <script src="${pageContext.request.contextPath}/static/js/owl.carousel.js"></script>
    <!-- video分类select -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/movie.css" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/static/css/ui-choose.css" rel="stylesheet" />
    <!--[if IE]>
    <script src="http://www.jq22.com/jquery/html5.min.js"></script>
    <![endif]-->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
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
<script src="${pageContext.request.contextPath}/static/js/ui-choose.js"></script>
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
                  登录 & 注册
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
                        <li><a href="${pageContext.request.contextPath}/PageVisitControl/index.do">首页</a></li>
                        <li><a href="${pageContext.request.contextPath}/PageVisitControl/movie.do">电影</a></li>
                        <li><a href="${pageContext.request.contextPath}/PageVisitControl/series.do">电视剧</a></li>
                        <li><a href="${pageContext.request.contextPath}/PageVisitControl/comic.do">动漫</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/PageVisitControl/variety.do">综艺</a></li>
                        <li><a href="${pageContext.request.contextPath}/NewsControl/news.do">新闻资讯</a></li>
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
<!-- /w3l-medile-movies-grids -->
<div class="general-agileits-w3l">
    <div class="w3l-medile-movies-grids">

        <!-- /movie-browse-agile -->

        <div class="movie-browse-agile">
            <!--/browse-agile-w3ls -->
            <div class="browse-agile-w3ls general-w3ls">
                <div class="tittle-head">
                    <h4 class="latest-text">综艺</h4>
                    <div class="container">
                        <div class="agileits-single-top">
                            <ol class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/PageVisitControl/index.do">首页</a></li>
                                <li class="active">类别</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="container">

                    <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                        <form name="form1" action="${pageContext.request.contextPath}/VideoControl/variety.do" method="post">
                            <div>
                             	<input type="hidden" name="pageIndex" value="1"/>
                                <input type="submit" style="position: relative;left: 90%;border-radius: 10%;width: 10%;height:30px;color: #a63d56" value="搜索"/>
                            </div>
                            <div class="clearfix"></div>

                            <div class="demo-box">
                                <table class="demo-table">
                                    <tr>
                                        <td>
                                            <label>按地区:&nbsp;</label>
                                        </td>
                                        <td>
                                            <select class="ui-choose" name="country" id="uc_01">
                                                <option value="全部">全部</option>
                                                <option value="中国大陆">中国大陆</option>
                                                <option value="韩国">韩国</option>
                                                <option value="日本">日本</option>
                                                <option value="港台">港台</option>                                                
                                                <option value="欧美">欧美</option>                                               
                                                <option value="新加坡">新加坡</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>按类型:&nbsp;</label>
                                        </td>
                                        <td>
                                            <select class="ui-choose" name="type" id="uc_02">
                                                <option value="全部">全部</option>
                                                <option value="情感">情感</option>
                                                <option value="搞笑">搞笑</option>
                                                <option value="选秀">选秀</option>
                                                <option value="旅游">旅游</option>
                                                <option value="美食">美食</option>
                                                <option value="曲艺">曲艺</option>
                                                <option value="游戏">游戏</option>
                                                <option value="音乐">音乐</option>
                                                <option value="真人秀">真人秀</option>
                                                <option value="少儿">少儿</option>
                                                <option value="脱口秀">脱口秀</option>
                                                <option value="纪实">纪实</option>
                                                <option value="盛会">盛会</option>
                                                <option value="其他">其他</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>按年份:&nbsp;</label>
                                        </td>
                                        <td>
                                            <select class="ui-choose" name="ageTime" id="uc_03">
                                                <option value="全部">全部</option>
                                                <option value="2019">2019</option>
                                                <option value="2018">2018</option>
                                                <option value="2017">2017</option>
                                                <option value="2016">2016</option>
                                                <option value="2015">2015</option>
                                                <option value="2010-2014">2010-2014</option>
                                                <option value="2000-2009">2000-2009</option>
                                                <option value="90年代">90年代</option>
                                                <option value="80年代">80年代</option>
                                                <option value="更早">更早</option>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </form>

                        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                            <ul id="myTab4" class="nav nav-tabs" role="tablist">
                                <li style="font-size: 1em;font-family: '微软雅黑 Light';font-weight: bold">排行:&nbsp;&nbsp;</li>
                                <li role="presentation" class="active"><a href="#a" role="tab" id="a-mlist" data-toggle="tab" aria-controls="a">热度</a></li>
                                <li role="presentation"><a href="#a" role="tab" id="b-mlist" data-toggle="tab" aria-controls="a">更新时间</a></li>
                                <li role="presentation"><a href="#a" role="tab" id="c-mlist" data-toggle="tab" aria-controls="a">评分</a></li>
                            </ul>
                        </div>
                    </div>


                    <div class="w3ls-news-result">
                        <h4>搜索 结果 : <span>${totalCount }条</span></h4>
                    </div>
                   
                           <ul class="main-member">
								<c:forEach var="message" items="${varietyList}">
									<li id="photoAddress" onclick="photoKick();">							 
									<a href="#" target="_blank">
								  		<img src="${pageContext.request.contextPath}/static/images/m7.jpg" width="182px" height="268px" class="img1" id="img1"/>
								  		<div class="w3l-movie-text">
		                                    <h6 style="text-align: center;"><a href="single.html">${message.video_Name}</a></h6>
		                                </div>
		                                <p class="mem-num">更新日期:&nbsp;<df:formatDate value="${message.video_Published}" pattern="yyyy-MM-dd"></df:formatDate></p>		                            
		                            	<p class="mem-num">期数:&nbsp;第${message.video_Season}期</p>	
								  		<p class="mem-num">时长:&nbsp;${message.video_Duration}分</p>
								  		<p class="mem-num">关键词:&nbsp;${message.video_KeyWords} </p>
							    	</a>					  
									</li>
								</c:forEach>					
							</ul>
							<div class="clearfix"></div>
				            <!--//browse-agile-w3ls -->
				            <div class="blog-pagenat-wthree">
				            	  <!--隐藏域，当前页码  --> 				            	  			
				                    <input type="hidden" id="totalPageCount" name="totalPageCount" value="${totalPageCount}"/>
				                    <c:import url="rollpage2.jsp">
									<c:param name="totalCount" value="${totalCount}"/>
									<c:param name="currentPageNo" value="${currentPageNo}"/>
									<c:param name="totalPageCount" value="${totalPageCount}"/>
						  			</c:import>				                
				            </div>		
                        </div>
                    </div>
                </div>
            </div>
           
        <!-- //movie-browse-agile -->
        <!--body wrapper start-->
        <!--body wrapper start-->
        <div class="review-slider">
            <h4 class="latest-text">Movie Reviews</h4>
            <div class="container">
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
                </div>
                <!--body wrapper end-->
            </div>
        </div>
    </div>
    <!-- //w3l-medile-movies-grids -->
</div>
<!-- //comedy-w3l-agileits -->
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
<script type="text/javascript">
    // 将所有.ui-choose实例化
    $('.ui-choose').ui_choose();
    // uc_02 select 单选
    var uc_01 = $('#uc_01').data('ui-choose');
    uc_01.click = function(value, item) {
        console.log('click', value);
    };
    uc_01.change = function(value, item) {
        console.log('change', value);
    };
    
    // uc_02 select 单选
    var uc_02 = $('#uc_02').data('ui-choose');
    uc_02.click = function(value, item) {
        console.log('click', value);
    };
    uc_02.change = function(value, item) {
        console.log('change', value);
    };
    // uc_02 select 单选
    var uc_03 = $('#uc_03').data('ui-choose');
    uc_03.click = function(value, item) {
        console.log('click', value);
    };
    uc_03.change = function(value, item) {
        console.log('change', value);
    };

</script>
<!-- //here ends scrolling icon -->
</body>
</html>