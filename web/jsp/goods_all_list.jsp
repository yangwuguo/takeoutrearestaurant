<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品管理</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../js/list_show.js"></script>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
    <style>
        .goodsImg {
            /*padding-top: 150px;*/
            display: none;
            float: left;
            position:absolute;
            /*margin-top: 150px;*/
            top: 100px;
            left: 300px;
        }

        .goodsDesc {
            width: 240px;
        }
    </style>
</head>
<body>
<div class="contentBox" style="position:relative;">

    <table id="contentMain">
        <tr>
            <th colspan='8' style='background-color: #cfcfcf'>菜品管理</th>
        </tr>
        <tr class='showHeader'>
            <td>ID</td>
            <td>菜品名称</td>
            <td>菜品描述</td>
            <td>分类</td>
            <td>菜品图片</td>
            <td>单价</td>
            <td>适合人群</td>
            <td>操作</td>
        </tr>
    </table>
    <div class="goodsImg">
        <img border="0" src="" id="imgShow" alt="picture" width="250" height="250"/>
    </div>
    <div style="width: 820px;margin: 0 auto; text-align: right">
        <input type="button" id="adInsert" value="添加" onclick="goodsInsert()"/>
    </div>


</div>
<script>
    $(function () {
        var u = "../goodsShow"
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

    //查看图片
    function goodsImg(srcPath) {
        $.ajax({
            url: "../imgShow",
            type: "post",
            datatype: "text/json",
            data: {
                "dishID": srcPath
            },
            success: function (adMessage) {
                $("#imgShow").attr("src", adMessage.imgPath);
                $(".goodsImg").fadeIn("fast");
            }
        });
        $("#imgShow").click(function(){//点击图片淡出消失弹出层
            $(".goodsImg").fadeOut("fast");
        });

    }

    //删除菜品
    function goodsDel(goodsID) {
        var url1="../goodsDel";
        var url2="../jsp/goods_all_list.jsp";
        Del(goodsID,url1,url2);
    }

    //新增菜品
    function goodsInsert() {
        $("#content").load("../jsp/goods_insert.jsp");
    }
</script>
</body>
</html>
