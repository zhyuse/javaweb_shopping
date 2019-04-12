<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-7
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <title>购物车</title>
    <style type="text/css">
	a:hover { color:orangered; }
	</style>
</head>
<body style="overflow-x: hidden">
<div style="display: inline">
    <!--  购物车!-->
    <div  style="position: relative; left: 0px; top:0px; width: 1240px; height: 480px;">
        <c:if test="${requestScope.msg_cart!=null}">
            <p style="color: red">${requestScope.msg_cart}</p>
        </c:if>
        <c:if test="${requestScope.msg_cart==null}">
            <form action="cart"  >
                <div  style="position: relative; left: 20px; top: 0px; width: auto; height: 539px;">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品图片</th>
                            <th>商品名称</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>金额</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list_cart}" var="cart">
                            <tr>
                                <td style="width: 150px;">
                                    <a href="listproduct?productid=${cart.getProductid()}" class="a" style="color: green">
                                        <img style="text-align:center;width: 100px;height: 100px" src="${cart.getImage()}">
                                    </a>
                                </td>
                                <td>
                                    <label style=" text-align:center;margin-top: 40px"><a href="listproduct?productid=${cart.getProductid()}" class="a" style="color: green;text-decoration: none">${cart.getProductname()}</a>
                                    </label>
                                </td>
                                <td>
                                    <label  style="margin-top: 40px" >${cart.getNum()}</label>
                                </td>
                                <td>
                                    <label style="margin-top: 40px">${cart.getDanjia()}</label>
                                </td>
                                <td>
                                    <label style="margin-top: 40px">${cart.getPrice()}</label>
                                </td>
                                <td><a href="cart?id_del=${cart.getProductid()}"><input type="button"  class="btn-info" style="color: black;margin-top: 38px" value="删除"></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <li style="margin-top:50px; margin-left:820px;list-style:none;">总额：</li>
                    <li style="margin-top:0px; margin-left:820px;list-style:none;">¥<%=session.getAttribute("total")%></li>
                    <li style="margin-top:0px; margin-left:820px; list-style:none"><a href="cart?jiesuan=all" ><input type="button" class="btn-danger" value="结算"></a> </li>
                </div>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
