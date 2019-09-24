
//删除
function Del(id, url1, url2) {
    $.ajax({
        url: url1,
        type: "POST",
        async: false,
        dateType: "text/json",
        data: {"ID": id},
        success: function (message) {
            alert(message.reply);
            if (message.reply == "删除成功") {
                $("#content").load(url2);
            }
        }
    });
}

