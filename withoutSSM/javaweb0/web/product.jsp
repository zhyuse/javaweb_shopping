<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>产品介绍</title>
</head>
<%
    Product product=(Product) request.getAttribute("product");
%>
<body>
<!--    //注意括号,没有的话会报错，先转换
    //List list=(List) request.getAttribute("list");
    //Product product=(Product)list.get(0);
    -->
<!--  head  !-->
<jsp:include page="head.jsp"></jsp:include>
<!--  product  !-->
<form action="cart">
    <div style="position: absolute; left: 127px; top: 190px; width: 899px; height: 603px;">
        <img style="width:300px; height:300px" src="<%=product.getImage()%>">
        <font style=" font-size:24px;color:#000000;text-align:center;position: absolute; left: 525px; top: 0px;"><%=product.getName()%></font>
        <font style="font-size: 18px; position: absolute; left: 353px; top: 69px; width: 302px; height: 34px;">价格:
            <font style="color: orangered;font-size: 24px">¥<%=product.getPrice()%></font>
        </font>
        <font style="font-size: 18px; position: absolute; left: 353px; top: 110px; width: 302px; height: 34px;">剩余库存:
            <font style=";font-size: 18px"><%=product.getNum()%></font>
        </font>
        <font style="position: absolute; left: 13px; top: 353px; font-size: 24px;">介绍：</font>
        <font style="position: absolute; left: 13px; top: 390px; font-size: 16px;"><%=product.getJieshao()%></font>
        <input type="text" name="add_id" value="<%=product.getId()%>" style="display: none" >
        <input type="text" name="add_num" style=" font-size:24px;position: absolute; left: 348px; top: 198px; width: 90px; height: 29px;" value=1>
        <c:if test="${sessionScope.user!=null}">
            <input type="submit" class="btn-info" value="加入购物车" style="font-size: 18px; position: absolute; left: 450px; top: 198px; width: 106px; height: 33px;">
        </c:if>
        <c:if test="${sessionScope.user==null}">
            <a class="btn-info" href="login.jsp">登录账户加入购物车</a>
        </c:if>
    </div>
</form>
</body>
</html>