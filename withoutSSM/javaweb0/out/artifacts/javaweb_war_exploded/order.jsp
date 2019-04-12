<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Order" %>
<%@ page import="Entity.Address" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
<title>待支付</title>
</head>

<body style="overflow-x: hidden">
<!-- 待付款 -->
<c:if test="${requestScope.msg_pay!=null}">
    <p style="color:red;">你还没有待付款的订单，快去下单吧！</p>
</c:if>
<c:if test="${requestScope.msg_pay==null}">
    <div style="position: relative; left: 20px; top: 0px; width: auto; height: auto;">
        <ul>
            <li style="list-style:none">收货人： <%=((Address)session.getAttribute("address")).getReceiver()%></li>
            <li style="list-style:none; ">联系电话： <%=((Address)session.getAttribute("address")).getPhone()%></li>
            <li style="list-style:none">收货地址： <%=((Address)session.getAttribute("address")).getAddress()%></li>
            <li style="list-style:none">订单号：  <%=((List< Order >)session.getAttribute("list_paying")).get(0).getId()%></li>
        </ul>
    </div>
    <div  style="position: relative; left: 20px; top: 0px; width: auto; height: 539px;">
        <table class="table">
            <thead>
            <tr>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>数量</th>
                <th>单价</th>
                <th>金额</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list_paying}" var="order">
                <tr>
                    <td style="width: 150px;">
                        <a href="listproduct?productid=${order.getProductid()}" class="a" style="color: green">
                        <img style="text-align:center;width: 100px;height: 100px" src="${order.getImage()}">
                        </a>
                    </td>
                    <td>
                        <label style=" text-align:center;margin-top: 40px"><a href="listproduct?productid=${order.getProductid()}" class="a" style="color: green;text-decoration: none">${order.getProductname()}</a>
                        </label>
                    </td>
                    <td>
                        <label  style="margin-top: 40px" >${order.getNum()}</label>
                    </td>
                    <td>
                        <label style="margin-top: 40px">${order.getDanjia()}</label>
                    </td>
                    <td>
                        <label style="margin-top: 40px">${order.getPrice()}</label>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <li style="margin-top:50px; margin-left:1000px;list-style:none;">总额：</li>
        <li style="margin-top:0px; margin-left:1000px;list-style:none;">¥<%=session.getAttribute("total")%></li>
        <li style="margin-top:0px; margin-left:1000px; list-style:none">
    </div>
</c:if>
</body>
</html>