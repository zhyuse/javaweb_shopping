<%@ page import="Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-31
  Time: 上午 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 重用可以不用在引用 -->
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet">
    <style type="text/css">
        a:hover { color:orangered; }
    </style>
    <script src="js/jq.js"></script>
</head>
<body>
<!--  head  !-->
<div style="width: 1520px;height: 170px">
    <!-- first  -->
    <div id="head" style="width: 100%; height:30px; background-color:white;">
        <div style=" margin-top: 15px">
            <p style="display: inline; margin-left: 300px; font-family: 'Lucida Console', Monaco, monospace;">欢迎来到Shop商城</p>
            <c:if test="${sessionScope.user!=null}">
                <li class="dropdown" style="display: inline;margin-left: 700px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        我的账户
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="myinfo">我的信息</a></li>
                        <li><a href="#">我的订单</a> </li>
                        <li><a href="myinfo"  onclick="return login()">我的购物车</a> </li>
                        <li><a onClick="javascript:return confirm('您确认要退出账户吗？')" href="listproduct?quit=y">退出账户</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${sessionScope.user==null}">
                <span style="margin-left:700px; display: inline; ">你还未登录，请</span>
                <a href="login.jsp">登录</a>
                <span>或</span>
                <a href="register">注册</a>
                <span>!</span>
            </c:if>
            <a style="position: absolute;left: 1400px " href="#">客户服务</a>   <!-- 使用absolute可以绝对定位避免受前面控件影响-->
        </div>
    </div>
    <!-- second -->
    <div style="width: 100% ;height: 140px;background-color:orange">
        <div style="position: relative;top: 30px;width: 100%;height: 80px">  <!--relative相对父容器定位  -->
            <div id="brand" style=" position:absolute;left:160px;width:200px;height: 80px ">
                <a href="listproduct"><img style="width:100%; height:80px" src="img/brand/shop.jpg"></a>
            </div>
            <!--搜索框 -->
            <div style="width: 300px;height: 80px;position: absolute;left: 600px">
                <form action="listproduct" method="post">
                    <!--垂直居中 -->
                    <div class="input-group col-md-3" style="position: absolute;top: 50%;transform: translate(0, -50%);">
                        <input type="text" id="search_info" class="form-control" name="search" style="width: 300px" placeholder="输入想要寻找的宝贝"  >
                        <span class="input-group-btn">
                            <input class="btn btn-warning btn-search" style="width:60px" value="查找" type="submit">
                        </span>
                    </div>
                    <div id="showDiv" style="display: none;width: 300px;height:200px;top: 58px;position: absolute;border-color: black;z-index: 999;"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
