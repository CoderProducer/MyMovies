<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/showdate.js"></script>


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
<form action="#" method="post" class="definewidth m20" enctype="multipart/form-data">
    <table class="table table-bordered table-hover m10" style="margin-left:10px;margin-top:3px;">
        <tr>
            <td width="20%"  class="tableleft">视频名称</td>
            <td><input type="text" name="videosName" placeholder="视频名称"/></td>
        </tr>
        <tr>
            <td class="tableleft">新闻名称</td>
            <td><input type="text" name="videosName" placeholder="新闻名称"/></td>
        </tr>
        <tr>
            <td class="tableleft">新闻图片</td>
            <td class="tableleft" style="width: 196px; "><input type="file" name="GoodsPicture" id="GoodsPicture" multiple="multiple" /><td>
            <!--         <td class="tableleft">图片预览</td> -->
            <!--         <td><img name="showimg" id="showimg" src="" style="display:none;" alt="预览图片" /> </td> -->
        </tr>
        <tr>
            <td class="tableleft">新闻内容</td>
            <td><input type="text" name="GoodsIntroduce" style="height: 80px;" maxlength="50" minlength="1" placeholder="不多于50字"/></td>

        </tr>
        <tr>
            <td class="tableleft"></td>
            <td><button style="margin-left:5px;" class="btn btn-primary" type="button"  >保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button></td>
        </tr>
    </table>
</form>

<div class="clearfix"></div>


</body>
</html>
