$(function () {
    var u = "../getCatelogName";
    getContent(u);

    //监听失去焦点后内容是否为空
    /*调用焦点监听方法*/
    monitor();
});

/*获取用户列表*/
function getContent(u) {
    $.ajax({
        url: u,
        type: "GET",
        // async: false,
        datatype: "text/json",
        data: {},
        success: function (adMessage) {
            setCatelogNameToOption(adMessage);
        }
    });
}

/*将分类名放到下拉框中*/
function setCatelogNameToOption(adMessage) {
    var html = [];
    $.each(adMessage, function (indext, value) {
        html.push("<option>" + value.catelogName + "</option>");
    })
    $("#goodsCateLog").append(html.join(""));
}

/*选择是否是特价*/
function specialOffer() {
    var aa = $("#goodsIsNotTeJia").val();
    if (aa == "是") {
        $('#goodsTeJia').attr('disabled', false);
        $('#goodsTeJia').css("color", "#000000");
        $("#goodsTeJia").next().text("*");
    } else {
        $('#goodsTeJia').attr('disabled', true);
        $('#goodsTeJia').val("");
        $("#goodsTeJia").next().text("");
        $('#goodsTeJia').css("color", "#EBEBE4");
    }
}

/*验证上传文件是否是图片*/
function verifyFormat(fileName) {
    var strIndex = fileName.lastIndexOf(".");
    var suffix = fileName.substring(strIndex + 1).toUpperCase();
    suffix = suffix.toUpperCase();
    console.log(suffix);
    if (suffix != "BMP" && suffix != "JPG" && suffix != "JPEG" && suffix != "PNG" && suffix != "GIF") {
        alert("请注意图片格式仅为(BMP、JPG、JPEG、PNG、GIF)!");
        $("#input_img").val("");
    } else {
        return true;
    }
}

/*获取文本框内容*/
function getText(id) {
    return $("#" + id + "").val();
}

/*启动监听*/
function monitor() {
    $.monitorFocus("#goodsName", "菜名不能为空或者空格等空白字符！！！");
    $.monitorFocus("#goodsShiChangJia", "单价价格不能为空并且只是为数字！！！");
    $.monitorFocus("#goodsTeJia", "特价价格不能为空并且只能是数字！！！");
}

/*通用获取焦点与失去焦点判断是否为空和是否是正确的价格*/
$.monitorFocus = function (labelID, str) {
    var focusBlurId = $(labelID);
    var labelVal = focusBlurId.val();
    focusBlurId.focus(function () {
        var thisVal = $(this).val();
        if (thisVal == labelVal) {
            $(this).val("");
            $(this).css("color", "black");
        }
    });
    focusBlurId.blur(function () {
        // var thisVal = $(this).val();
        // if (judgeStringNull(thisVal)) {
        //     if (labelID == "#goodsShiChangJia" || labelID == "#goodsTeJia") {
        //         if (judgeFloat(thisVal)) {
        //             $(this).next().text("*");
        //             return true;
        //         } else {
        //             $(this).next().text("请输入正确的价格如：19.99");
        //         }
        //     } else {
        //         $(this).next().text("*");
        //         return true;
        //     }
        // } else {
        //     $(this).next().text(str);
        //
        // }
        judgeContent(labelID, str);
    });
}

/*判断内容合格并输出提示语*/
function judgeContent(labelID, str) {
    var focusBlurId = $(labelID);
    var labelVal = focusBlurId.val();
    if (judgeStringNull(labelVal)) {
        if (labelID == "#goodsShiChangJia" || labelID == "#goodsTeJia") {
            if (judgeFloat(labelVal)) {
                focusBlurId.next().text("*");
                return true;
            } else {
                focusBlurId.next().text("请输入正确的价格如：19.99");
            }
        } else {
            focusBlurId.next().text("*");
            return true;
        }
    } else {
        focusBlurId.next().text(str);

    }
}

/*判断输入字符是否为正浮点型或正整形*/
function judgeFloat(price) {
    var reg = new RegExp("^[0-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|[0-9]\\d*$");
    var reg1 = new RegExp("\\D+");
    var priceIndex = price.indexOf('.');
    if (priceIndex != -1) {
        var r1 = reg1.test(price.substring(0, priceIndex));
        var r2 = reg1.test(price.substring(priceIndex + 1));
        if (r1 || r2) {
            return false;
        } else {
            return reg.test(price);
        }
    } else {
        if (reg1.test(price)) {
            return false;
        } else {
            return reg.test(price);
        }
    }
}

/*判断值是否为空或空白字符*/
function judgeStringNull(labelVal) {
    if ((labelVal != undefined) && (labelVal.trim().length > 0)) {
        return true;
    } else {
        return false;
    }
}

/*将字符串转换为货币规格浮点型*/
function formatMoney(moneyVal) {
    var money = 0;
    if (judgeStringNull(moneyVal)) {
        var moneyIndex = moneyVal.indexOf('.');
        if (moneyIndex == -1) {
            money = parseFloat(moneyVal);
        } else {
            money = moneyVal.substring(0, moneyIndex + 3);
        }
        return parseFloat(money);
    }
}

/*将图片意外的信息装进Json*/
function goJson() {
    var con = {};
    con["Name"] = getText("goodsName");
    con["MiaoShu"] = getText("goodsMiaoShu");
    con["CateLog"] = getText("goodsCateLog");
    con["ShiChangJia"] = getText("goodsShiChangJia");
    con["IsNotTeJia"] = getText("goodsIsNotTeJia");
    con["TuiJan"] = getText("goodsIsNotTuiJan");
    con["RenQun"] = getText("goodsRenQun");
    if (getText("goodsIsNotTeJia") == "是") {
        con["TeJia"] = getText("goodsTeJia");
    }
    var json = JSON.stringify(con);
    return json;
}

/*提交数据*/
function goodsInsertButton() {
    judgeContent("#goodsName", "菜名不能为空或者空格等空白字符！！！");
    judgeContent("#goodsShiChangJia", "单价价格不能为空并且只是为数字！！！");
    var na = $("#goodsName").next().text();
    var scj = $("#goodsShiChangJia").next().text();
    var tj = "*";
    var goodsIsNotTeJia = getText("goodsIsNotTeJia");
    if (goodsIsNotTeJia == "是") {
        judgeContent("#goodsTeJia", "特价价格不能为空并且只能是数字！！！");
        tj = $("#goodsTeJia").next().text();
    }
    if (na == "*" && scj == "*" && tj == "*") {
        upDataGoods();
    }
}


/*上传*/
function upDataGoods() {
    var goodsJson = goJson();
    var formData = new FormData();
    var fileName = $("#input_img").val();

    if (verifyFormat(fileName)) {
        formData.append("file", $("#input_img")[0].files[0]);
        formData.append("goodsJson", goodsJson);
        $.ajax({
            url: "../goodsInsert",
            type: "POST",
            // dataType: "text/json",
            processData: false, // 使数据不做处理
            contentType: false, // 不要设置Content-Type请求头
            data: formData,
            success: function (adMessage) {
                alert(adMessage.reply);
                $("#content").load("../jsp/goods_all_list.jsp");
            },
        })
    }
}



