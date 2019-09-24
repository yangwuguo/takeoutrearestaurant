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
    <title>用户信息展示</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../js/list_show.js"></script>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
</head>
<body>
<div class="contentBox">

    <table id="contentMain">
        <tr>
            <th colspan='4' style='background-color: #cfcfcf'>管理员维护</th>
        </tr>
        <tr class='showHeader'>
            <td>ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
    </table>
    <div style="width: 820px;margin: 0 auto; text-align: right">
        <input type="button" id="adInsert" value="添加" onclick="adInsert()"/>
    </div>


</div>

<script>
    //进来页面开始请求数据
    $(function () {
        var u = "../adShow"
        getContent(u);
    })

    //获取用户列表
    function getContent(u) {
        $.ajax({
            url: u,
            type: "GET",
            // async: false,
            datatype: "text/json",
            data: {},
            success: function (adMessage) {
                adJointOutPut(adMessage);
            }
        });
    }

    //动态打印用户列表
    function adJointOutPut(adMessage) {
        // $.each(adMessage,function (index,value) {
        //      value.name
        // })
        var html = [];
        $(adMessage).each(function () {
            html.push("<tr><td >" + this.userID + "</td>");
            html.push("<td >" + this.userName + "</td>");
            html.push("<td >" + this.password + "</td>");
            html.push("<td class='delOperation'><a href='javascript:void(0)' onclick='adDel(" + this.userID + ")'>删除</a></td></tr>");
        })
        // console.log(html)
        $("#contentMain").append(html.join(""));
    }

    //删除
    function adDel(userID) {
        var url1 = "../adDel";
        var url2 = "../jsp/admin_list.jsp";
        Del(userID, url1, url2);
    }

    //添加用户
    function adInsert() {
        $("#content").load("../jsp/admin_signin.jsp");
    }
</script>
</body>
</html>
