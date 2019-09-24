<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增菜品</title>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../js/list_show.js"></script>
    <script type="text/javascript" src="../js/goodsInsert.js"></script>
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

        span {
            color: red;
            padding-left: 12px;
        }
    </style>
    <script>
        //获取数据库中的分类名

    </script>
</head>
<body>
<div class="contentBox">
    <table id="contentMain">
        <tr>
            <td class="infoName">菜名：</td>
            <td class="infoText">
                <input type="text" id="goodsName" /><span>*</span>
            </td>
        </tr>
        <tr>
            <td class="infoName">菜品描述：</td>
            <td class="infoText">
                <textarea rows="6" cols="30" id="goodsMiaoShu" style="resize:none"/>
                <span></span>
            </td>
        </tr>
        <tr>
            <td class="infoName">分类：</td>
            <td class="infoText">
                <select id="goodsCateLog">
                </select>
            </td>
        </tr>
        <tr>
            <td class="infoName">图片：</td>
            <td class="infoText"><input type="file" name="img" id="input_img">
                <%--                <input type="button" value="提交" onclick="uploadPic()"></td>--%>
        </tr>
        <tr>
            <td class="infoName">单价：</td>
            <td class="infoText">
                <input type="text" id="goodsShiChangJia"/><span>*</span>
            </td>
        </tr>
        <tr>
            <td class="infoName">是否是特价：</td>
            <td class="infoText">
                <select id="goodsIsNotTeJia" onclick="specialOffer()">
                    <option selected="selected">否</option>
                    <option>是</option>
                </select></td>
        </tr>
        <tr>
            <td class="infoName">特价：</td>
            <td class="infoText">
                <input type="text" id="goodsTeJia" disabled="true"/><span></span></td>
        </tr>
        <tr>
            <td class="infoName">是否是推荐：</td>
            <td class="infoText">
                <select id="goodsIsNotTuiJan">
                    <option selected="selected">否</option>
                    <option>是</option>
                </select></td>
        </tr>
        <tr>
            <td class="infoName">适合人群：</td>
            <td class="infoText">
                <select id="goodsRenQun">
                    <option selected="selected">所有人</option>
                    <option>大学生</option>
                    <option>老人</option>
                    <option>小孩</option>
                    <option>工作人员</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="提交"
                                   onclick="goodsInsertButton()"></td>
            <%--            <td colspan="2"><input type="reset" id="goodsReset"/></td>--%>
        </tr>
    </table>
</div>
</body>
</html>
