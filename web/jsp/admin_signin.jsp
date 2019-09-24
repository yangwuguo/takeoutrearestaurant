<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/7
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
    <style type="text/css">
        .infoName {
            width: 40%;
        }

        .infoText {
            width: 60%;
        }

        [type=button] {
            width: 80px;
        }

    </style>
</head>
<body>
<div class="contentBox">
    <table id="contentMain">
        <tr>
            <td class="infoName">用户名：</td>
            <td class="infoText"><input type="text" id="adName"></td>
        </tr>
        <tr>
            <td class="infoName">密码：</td>
            <td class="infoText"><input type="text" id="adPW"></td>
        </tr>
        <tr>
            <td class="infoName">确认密码：</td>
            <td class="infoText"><input type="text" id="confirmPW"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" id="signIn" value="提交注册"
                                   onclick="adSubmit()"></td>
        </tr>
    </table>
</div>
<script>
    $(function () {
        $("#adName").blur(function () {
            var adName= $("#adName").val();
            if (adName==""){
                $("#adName").next().text("菜品名不能为空！！！");
            }else {
                $("#adName").next().text("");
            }
        })
        $("#adPW").blur(function () {
            var adPW= $("#adPW").val();
            if (adPW==""){
                $("#adPW").next().text("菜品名不能为空！！！");
            }else {
                $("#adPW").next().text("");
            }
        })
    })
    function adSubmit() {
        var name = $("#adName").val();
        var adPW = $("#adPW").val();
        var confirmPW = $("#confirmPW").val();
        if (name == "") {
            alert("用户名不能为空");
        } else if (adPW == "") {
            alert("密码不能为空");
        } else if (adPW == confirmPW) {
            $.ajax({
                url: "../insert",
                type: "POST",
                dateType: "text/json",
                data: {
                    "name":name,
                    "password":adPW
                },
                success: function (message) {
                    alert(message.reply);
                    if (message.verify) {
                        $("#content").load("../jsp/admin_list.jsp");
                    }
                    // $('#contentMain').empty();
                    // getAdContent();
                }
            });
        } else {
            alert("前后密码不一致！！！")
        }

    }
</script>
</body>
</html>
