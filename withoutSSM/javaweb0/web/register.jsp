<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-3-3
  Time: 下午 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/jq.js"></script>
    <script type="text/javascript">
        function panduan()
        {

            var p1=document.form1.userpd.value;
            var p2=document.form1.userpda.value;
            if(p1!=p2)
            {
                $("#userpdinfo").css("display","block");
                return false;
            }
            else { return true;}
        }
    </script>
</head>
<body class="text-center">
<c:if test="${requestScope.step==1}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="register" onSubmit="return panduan()" name="form1" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤一：输入用户信息</h1>
        <label class="sr-only">用户名</label>
        <input type="text" id="userid" name="userid" class="form-control" placeholder="用户名" required autofocus>
        <p id="useridinfo" style="display: none;" ></p>
        <label class="sr-only"></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="姓名" required autofocus>
        <label class="sr-only">登录密码</label>
        <input type="password" id="userpd" name="userpd" class="form-control" placeholder="密码" required autofocus>
        <label class="sr-only"></label>
        <input type="password" id="userpda" name="userpda" class="form-control" placeholder="再次输入密码" required autofocus>
        <P id="userpdinfo" style="color: red;display: none">密码输入不一致</P>
        <label class="sr-only"></label>
        <input type="text" id="usermail" name="usermail" class="form-control" placeholder="邮箱" required autofocus>
        <p id="usermailinfo" style="display: none;color: red">邮箱格式有误</p>
        <div class="checkbox mb-3">
        </div>
        <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">下一步</button>
    </form>
</c:if>
<c:if test="${requestScope.step==2}">
    <form style="position: absolute; left: 595px; width: 421px; top: 195px;" class="form-signin" action="register" name="form2" method="post">
        <h1 class="h3 mb-3 font-weight-normal" >步骤二:输入邮箱验证码</h1>
        <c:if test="${requestScope.msg!=null}">
            <p  style="color: red" ><%=request.getAttribute("msg")%></p>
        </c:if>
        <label class="sr-only">验证码</label>
        <input type="text" id="yzm" name="yzm" class="form-control" placeholder="验证码" required autofocus>
        <div class="checkbox mb-3">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">完成注册</button>
    </form>
</c:if>
</body>
</html>
