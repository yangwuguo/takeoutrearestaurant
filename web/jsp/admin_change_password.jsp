<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
</head>
<body>
<div class="contentBox">
    <table>
        <tr>
            <th colspan="2">密码修改</th>
        </tr>
        <tr>
            <td class='infoName'>登录名：</td>
            <td class='infoText'><input type="text" readonly="readonly" id="userName" style="color: #ababab"></td>
        </tr>
        <tr>
            <td class='infoName'>原密码：</td>
            <td class='infoText'><input type="text" id="oldPW"></td>
        </tr>
        <tr>
            <td class='infoName'>新密码：</td>
            <td class='infoText'><input type="text" id="newPW"></td>
        </tr>
        <tr>
            <td class='infoName'>确认密码：</td>
            <td class='infoText'><input type="text" id="affirmPW"></td>
        </tr>
        <tr>
            <td class='infoName'></td>
            <td class='infoText'>
                <input type="button" id="update" value="修改" onclick="changePW()">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" id="reset" value="重置" onclick="resetPW()" style="background-color: #ece9d8">
            </td>
        </tr>
    </table>
</div>
<script>
    var uName = sessionStorage.getItem("userName");
    // var uID = sessionStorage.getItem("userID");
    $("#userName").val(uName);

    function resetPW() {
        $("#userName").val(uName);
        $("#oldPW").val("");
        $("#newPW").val("");
        $("#affirmPW").val("");
    }

    function changePW() {
        var adName = uName;
        var oldPW = $("#oldPW").val();
        var newPW = $("#newPW").val();
        var affirmPW = $("#affirmPW").val();
        var admin = {
            "name": adName,
            "oldPW": oldPW,
            "newPW": newPW
        };
        if (newPW == null) {
            alert("输入的新密码不能为空！！！");
        } else if (newPW == affirmPW) {
            setMessage(admin);
        } else {
            alert("更改密码前后不一致，请检查并重新输入！！！")
        }

    }

    function setMessage(admin) {
        $.ajax({
            url: "../change",
            type: "POST",
            datatype: "json/text",
            data: admin,
            success: function (adMessage) {
                alert(adMessage.reply);
            }
        })
    }
</script>
</body>
</html>
