<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/24
  Time: 15:16
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
            <th colspan='10' style='background-color: #cfcfcf'>管理员维护</th>
        </tr>
        <tr class='showHeader'>
            <td>ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td>真实姓名</td>
            <td>住址</td>
            <td>性别</td>
            <td>联系方式</td>
            <td>E-mail</td>
            <td>QQ</td>
            <td>操作</td>
        </tr>
    </table>
    <div style="width: 820px;margin: 0 auto; text-align: right">
        <input type="button" id="adInsert" value="添加" onclick="adInsert()"/>
    </div>
</div>
<script>
    $(function () {
        var u = "../userShow"
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
                goodsJointOutPut(adMessage);
            }
        });
    }

    //动态打印列表
    function goodsJointOutPut(adMessage) {
        var html = [];
        $(adMessage).each(function () {
            if (this.goodsDel) {
                html.push("<tr><td >" + this.goodsID + "</td>");
                html.push("<td >" + this.goodsName + "</td>");
                html.push("<td class='goodsDesc'>" + this.goodsMiaoshu + "</td>");
                html.push("<td >" + this.goodsCatelog + "</td>");
                html.push("<td ><a href='javascript:void(0)' onclick='goodsImg(" + this.goodsID + ")'>查看图片</a></td>");
                html.push("<td >" + this.goodsShichangjia + "</td>");
                html.push("<td >" + this.goodsRenqun + "</td>");
                html.push("<td class='delOperation'><a href='javascript:void(0)' onclick='goodsDel(" + this.goodsID + ")'>删除</a>");
                html.push("&nbsp;&nbsp;<a href='javascript:void(0)' onclick='goodsDel(" + this.goodsID + ")'>编辑</a></td></tr>");
            }
        })
        $("#contentMain").append(html.join(""));
    }
</script>
</body>
</html>
