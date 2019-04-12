<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-2-26
  Time: 下午 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding = "UTF-8"%>
<%@ page import="java.sql.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<script>
  function panduan1() {
    var id=document.form1.searchid.value;
    if(id=="")
    {
      alert("请输入要查询书本号");
    }
    else
    {
      alert("还没连接数据库呢,老哥???");
    }
  }
  function  panduan2() {
    alert("只是测试，这个就不弄了把");
  }
</script>
<head>
  <title>$Title$</title>
</head>
<body>

<%
  String driver = "com.mysql.cj.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/blog?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  String user = "root";
  String password = "7885211";
  Class.forName(driver);
  Connection conn = DriverManager.getConnection(url, user, password);
  if(conn!=null)
    out.print("连接成功");
  else {
    out.print("连接失败");
  }
%>
</body>
</html>
