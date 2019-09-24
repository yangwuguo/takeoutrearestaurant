<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统信息</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="styleSheet"  href="../css/tables.css" />
    <script>
        $(function () {
            $.ajax({
                url: "../info",
                type: "POST",
                datatype: "text/json",
                data: {
                    "demand": "系统信息"
                },
                success: function (navMessage) {
                    strJoint(navMessage);
                }

            });

            function strJoint(navMessage) {
                var html = [];
                html.push("<tr><th colspan='2'>系统基本信息</th></tr>")
                html.push("<tr><td class='infoName'>操作系统版本：</td><td class='infoText'>" + navMessage.name + "</td></tr>");
                html.push("<tr><td class='infoName'>操作系统类型：</td><td class='infoText'>" + navMessage.arch + "</td></tr>");
                html.push("<tr><td class='infoName'>用户、目录、临时目录：</td><td class='infoText'>" + navMessage.tmpdir + "</td></tr>");
                html.push("<tr><td class='infoName'>JDK版本：</td><td class='infoText'>" + navMessage.version + "</td></tr>");
                html.push("<tr><td class='infoName'>JDK安装目录：</td><td class='infoText'>" + navMessage.home + "</td></tr>");
                html.push("<tr><td class='infoName'>总内存/剩余内存：</td><td class='infoText'>" + navMessage.memory + "</td></tr>");
                $("#systemInfoContent").append(html.join(""));
            }
        })
    </script>
</head>
<body>
<div class="contentBox">
    <table id="systemInfoContent">

    </table>
</div>
</body>
</html>
