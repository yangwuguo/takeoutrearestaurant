<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品管理</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="styleSheet" href="../css/tables.css"/>
</head>
<body>

菜名儿：<input type="text" name="goodName" id="goodName">

图片格式为：BMP、JPG、JPEG、PNG、GIF<br/>
<input type="file" name="img" id="input_img">
<input type="button" value="提交" onclick="uploadPic()">
<br/>
<input type="button" value="显示" onclick="show()">

<img border="0" src="" id="imgShow" alt="picture" width="160" height="100"/>

<script>

    //上传图片
    function uploadPic() {
        var goodName = $("#goodName").val();
        var formData = new FormData();
        var fileName = $("#input_img").val();

        if ($("#input_img")[0].files[0] != null) {
            if (verifyFormat(fileName)) {
                formData.append("file", $("#input_img")[0].files[0]);
                formData.append("goodName", goodName);

                $.ajax({
                    url: "../upload",
                    type: "POST",
                    dataType: "text/json",
                    processData: false, // 使数据不做处理
                    contentType: false, // 不要设置Content-Type请求头
                    data: formData,
                    success: function (adMessage) {
                        alert(111)
                    }
                })}
        } else {
            alert("图片不能为空！！！")
        }
    }

    //获取图片路径
    function show() {
        var dishID = 1;
        $.ajax({
            url: "../imgShow",
            type: "post",
            datatype: "text/json",
            data: {
                "dishID": dishID
            },
            success: function (adMessage) {
                $("#imgShow").attr("src", adMessage.imgPath);
            },
            error: function (a) {
                alert(a.valueOf().toString() + "挂了")
            }
        })
    }

    //验证上传文件是否是图片
    function verifyFormat(fileName) {
        var strIndex = fileName.lastIndexOf(".");
        var suffix = fileName.substring(strIndex + 1).toUpperCase();
        suffix=suffix.toUpperCase();
        console.log(suffix);
        if (suffix != "BMP" && suffix != "JPG" && suffix != "JPEG" && suffix != "PNG" && suffix != "GIF") {
            alert("请注意图片格式仅为(BMP、JPG、JPEG、PNG、GIF)!");
            $("#input_img").val("");
        } else {
            return true;
        }
    }
</script>
</body>
</html>