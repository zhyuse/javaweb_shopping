<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
<meta charset="utf-8">
<link href="css/bootstrap" rel="stylesheet">
    <link href="css/mycss.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        *{
            padding: 0;
            margin: 0;
            list-style: none;
        }
        .main{
            width: 500px;
            margin:0 auto;
        }
        .main>ul>li{
            width: 500px;
            height: 80px;
            border-bottom: 1px solid #666;
            text-align: center;
            line-height: 80px;
        }
        .disabled{
            cursor: not-allowed;
        }

    </style>
</head>
<body>

<div class="main">
    <ul>
        <li>
            <p>这是1个</p>
        </li>
        <li>
            <p>这是2个</p>
        </li>
        <li>
            <p>这是3个</p>
        </li>
        <li>
            <p>这是4个</p>
        </li>
        <li>
            <p>这是5个</p>
        </li>
        <li>
            <p>这是6个</p>
        </li>
        <li>
            <p>这是7个</p>
        </li>
        <li>
            <p>这是8个</p>
        </li>
        <li>
            <p>这是9个</p>
        </li>
        <li>
            <p>这是10个</p>
        </li>
        <li>
            <p>这是11个</p>
        </li>
        <li>
            <p>这是12个</p>
        </li>
        <li>
            <p>这是13个</p>
        </li>
        <li>
            <p>这是14个</p>
        </li>
        <li>
            <p>这是15个</p>
        </li>
        <li>
            <p>这是16个</p>
        </li>
        <li>
            <p>这是17个</p>
        </li>
        <li>
            <p>这是18个</p>
        </li>
        <li>
            <p>这是19个</p>
        </li>
        <li>
            <p>这是20个</p>
        </li>
    </ul>
    <!--bootstrap 生成的分页-->
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li id="last">
                <a href="javascript:void(0);" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <!--伪代码-->
            <!--<li id="firstPage"><a href="#" >1</a></li>-->
            <!--&lt;!&ndash;<li><a href="#">2</a></li>&ndash;&gt;-->
            <!--<li><a href="#">3</a></li>-->
            <!--<li><a href="#">4</a></li>-->
            <!--<li><a href="#">5</a></li>-->
            <li id="next">
                <a href="javascript:void(0);" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
<script>
    /***
     * 渲染页面
     * 动态创建底部分页的li
     * 给li绑定点击事件 点击到哪一页就展示哪一页的内容
     * 设置上翻一页 下翻一页
     */
    var ul=$(".main>ul");
    var lis=ul.children();
    var allColum=lis.length;//总数
    var onlyPage=8;//每一个的个数
    var pages=Math.ceil(allColum/onlyPage)//总页数
    var currentPage=1//当前页面

    //动态创建底部分页的li
    for(var i=pages-1;i>=0;i--){
        var li=  $("<li class='num'><a href='javascript:void(0)'>"+(i+1)+"</a></li>")
        $("#last").after(li)
    }
    //   渲染页面

    render(lis,onlyPage,pages,currentPage)
    function render(lis,onlyPage,pages,currentPage) {

        for(var j=1;j<=pages;j++){
            if(currentPage==j) {
                for (var i = 0; i < lis.length; i++) {
                    lis[i].style.display="block";
                    if(i<(currentPage-1)*onlyPage || i>currentPage*onlyPage-1){
                        lis[i].style.display="none";
                    }
                }
            }
        }
    }
    //给所有的a绑定点击事件
    var as=$(".num")
    for (var i = 0; i < as.length; i++) {
        as[i].index=i;
        as[i].onclick=function () {
            currentPage=this.index+1
            render(lis,onlyPage,pages,currentPage)
        }
    }
    // 设置上翻一页 下翻一页
    //上翻一页 最前一页禁用
    $("#last").click(function () {
        currentPage--;

        if(currentPage<=1){
            $(this).addClass("disabled")
        }
        render(lis,onlyPage,pages,currentPage)
    })
    //    下翻一页 最后一页禁用
    $("#next").click(function () {
        currentPage++;
        if(currentPage>=pages){
            $(this).addClass("disabled")
        }
        render(lis,onlyPage,pages,currentPage)
    })
</script>
</html>