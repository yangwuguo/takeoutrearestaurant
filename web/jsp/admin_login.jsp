<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/30
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <style type="text/css">
        .outside{
            width: 100%;
            height: 100%;
            margin: 0 auto;
        }
        .content{
            background-color: #ffd9a9;
            width: 500px;
            height: 240px;
            margin: 0 auto;
            position: relative; /*脱离文档流*/
            top:25%;
        }
        .content div{
            width: 500px;
            height: 80px;
            /*margin: 0 auto;*/
            text-align: center;
            line-height: 80px;
            /*margin-bottom: 0;*/

        }
    </style>
</head>
<body>
<div class="outside">
    <div class="content">
        <div>用户：<input type="text" id="userName"></div>
        <div>密码：<input type="password" id="userPW"></div>

        <div><input type="button" value="登录" onclick="login()"/></div>
    </div>
</div>
<script type="text/javascript">;

function login() {
    var userName = $("#userName").val();
    var userPW = $("#userPW").val();
    if (userName!=""){
        $.ajax({
            url: "adminLogin",
            type: "POST",
            datatype: "text/json",
            data: {
                "userName": userName,
                "userPW": userPW
            },
            success: function (adMessage) {
                if (adMessage.verify) {
<%--                    <%  response.sendRedirect("jsp/mainHome.jsp"); %>--%>
                    sessionStorage.setItem('userName',adMessage.userName);
                    // sessionStorage.setItem('userID',adMessage.userID);
                    window.location = "jsp/mainHome.jsp";
                } else {
                    alert(adMessage.reply)
                }
            }
        });
    } else {
        alert("用户名不能为空！！！")
    }

}
</script>
</body>
</html>
