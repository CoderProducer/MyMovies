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
            <td width="10%" class="tableleft">电影类别</td>
            <td>
                <select name="movieBigTypeId">
                    <option value="0">爱情</option>
                    <option value='1'>&nbsp;动作</option>
                    <option value='7'>&nbsp;科幻</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所属地区</td>
            <td>
                <select name="movieSmallTypeId">
                    <option value="0">中国大陆</option>
                    <option value='1'>&nbsp;美国</option>
                    <option value='7'>&nbsp;日本</option>
                </select>
            </td>
        </tr>

        <tr>
            <td class="tableleft">视频名称</td>
            <td><input type="text" name="videosName" placeholder="视频名称"/></td>
            <td class="tableleft">视频大小</td>
            <td><input type="text" name="videosNumber" placeholder="以M为单位"/>&nbsp;&nbsp;M</td>
        </tr>
        <tr>
            <td class="tableleft">视频关键字</td>
            <td><input type="text" name="GoodsNormalPrice" placeholder="视频标签"/></td>
        </tr>
        <tr>
            <td class="tableleft">上映时间</td>
            <td style="height: 46px; "> <div style="margin:0 auto;">
                <input type="text" id="time1" value="选择时间" placeholder="请点击选择" onClick="return Calendar('time1');" class="text_time"/>
            </div>
            </td>
        </tr>
        <tr>
            <td class="tableleft">视频海报</td>
            <td class="tableleft" style="width: 196px; "><input type="file" name="GoodsPicture" id="GoodsPicture" multiple="multiple" /><td>
            <!--         <td class="tableleft">图片预览</td> -->
            <!--         <td><img name="showimg" id="showimg" src="" style="display:none;" alt="预览图片" /> </td> -->
        </tr>
        <tr>
            <td class="tableleft">选择视频</td>
            <td class="tableleft" style="width: 196px; "><input type="file" name="GoodsPicture" id="VideosPicture" multiple="multiple" /><td>
        </tr>
        <tr>
            <td class="tableleft">视频简介</td>
            <td><textarea name="GoodsIntroduce"  cols="40" rows="3" maxlength="300" minlength="1" placeholder="视频简单介绍">
                </textarea>
            </td>
            <td><input type="text" name="GoodsIntroduce" style="height: 63px;" placeholder="视频简单介绍"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button style="margin-left:5px;" class="btn btn-primary" type="button"  >保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
<div class="clearfix"></div>


</body>
</html>
