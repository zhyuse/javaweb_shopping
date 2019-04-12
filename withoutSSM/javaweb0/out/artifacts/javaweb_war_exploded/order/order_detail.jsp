<%@ page import="Entity.Order" %>
<%@ page import="Entity.Address" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-2
  Time: 下午 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body style="overflow-x: hidden">
<div style="display: inline">
    <div style="position: relative; left: 20px; top: 0px; width: auto; height: auto;">
        <ul>
            <li style="list-style:none">收货人： <%=((Address)session.getAttribute("address")).getReceiver()%></li>
            <li style="list-style:none; ">联系电话： <%=((Address)session.getAttribute("address")).getPhone()%></li>
            <li style="list-style:none">收货地址： <%=((Address)session.getAttribute("address")).getAddress()%></li>
            <li style="list-style:none">订单号：  <%=((List< Order >)session.getAttribute("order")).get(0).getId()%></li>
        </ul>
    </div>
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
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${order}" var="order">
                            <tr>
                                <td style="width: 150px;">
                                    <a href="../listproduct?productid=${order.getProductid()}" class="a" style="color: green">
                                        <img style="text-align:center;width: 100px;height: 100px" src="../${order.getImage()}">
                                    </a>
                                </td>
                                <td>
                                    <label style=" text-align:center;margin-top: 40px"><a href="../listproduct?productid=${order.getProductid()}" class="a" style="color: green;text-decoration: none">${order.getProductname()}</a>
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
                    <li style="margin-top:50px; margin-left:820px;list-style:none;">总额：</li>
                    <li style="margin-top:0px; margin-left:820px;list-style:none;">¥<%=session.getAttribute("total")%></li>
                    <c:if test="${sessionScope.order.get(0).getStatus()==1}"><li style="margin-top:0px; margin-left:820px; list-style:none"><a href="cart?jiesuan=all" ><input type="button" class="btn-danger" value="去支付"></a> </li></c:if>
                    <c:if test="${sessionScope.order.get(0).getStatus()==3}"><li style="margin-top:0px; margin-left:820px; list-style:none"><a href="#" ><input type="button" class="btn-danger" value="确认收货"></a> </li></c:if>
                </div>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
