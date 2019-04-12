{   //搜索
    function overFn(obj) {
        $(obj).css("background", "#DBEAF9");
    }

    function outFn(obj) {
        $(obj).css("background", "#fff");
    }

    function clickFn(obj) {
        $("#search_info").val($(obj).html());
        $("#showDiv").css("display", "none");
    }

    $(function () {
        $("#search_info").bind('input propertychange', function () {
            var serch_info = $(this).val();
            var content = "";
            if (serch_info == "") {
                $("#showDiv").css("display", "none");
                return;
            }
            $.ajax({
                url: "listproduct",
                async: true,
                type: "post",
                data: {"search_info": serch_info},
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        content += "<div style='padding:5px;cursor:pointer;background-color: white' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>" + data[i] + "</div>";
                    }
                    if (data.length == 0) {
                        content = "<div style='padding:5px;cursor:pointer;background-color: white'>没有找到你要的宝贝。。。</div>";
                    }
                    $("#showDiv").css("display", "block");
                    $("#showDiv").html(content);
                },
                error: function () {
                    alert("请求失败");
                },
                dataType: "json"
            })
        })
    })
}
{   //注册
    $(function () {

        //为输入框绑定事件
        $("#userid").blur(function () {
            var userid = $(this).val();
            if (userid == "") {
                $("#useridinfo").css("display", "none")
                return;
            }
            //ajax
            $.ajax({
                url: "register",
                async: true,
                type: "POST",
                data: {"userid": userid},
                success: function (data) {
                    var exist_id = data;
                    var useridinfo = "";
                    if (exist_id == "n") {
                        useridinfo = "用户名已存在~~";
                        $("#useridinfo").css("color", "red");
                        $("#submit").attr("disabled", true);
                    } else {
                        useridinfo = "用户名可以使用";
                        $("#useridinfo").css("color", "green");
                        $("#submit").attr("disabled", false);
                    }
                    $("#useridinfo").css("display", "block")
                    $("#useridinfo").html(useridinfo);
                },
                error: function () {
                    alert("请求失败");
                }
            });
        });
        $("#usermail").blur(function () {
            var mail = $(this).val();
            var geshi = /^\w+@[a-z0]+(\.[a-z]+){1,3}$/;
            if (mail == "") {
                $("#usermailinfo").css("display", "none")
                return;
            }
            if (!geshi.test(mail)) {
                $("#usermailinfo").css("display", "block");
                $("#submit").attr("disabled", true);
            } else {
                $("#usermailinfo").css("display", "none");
                $("#submit").attr("disabled", false);
            }
        })
    });
}