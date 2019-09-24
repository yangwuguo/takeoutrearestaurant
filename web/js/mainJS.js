$(function () {
    $.ajax({
        url: "../nav",
        type: "POST",
        datatype: "text/json",
        data: {
            "aa": "进来了"
        },
        success: function (navMessage) {
            strJoint(navMessage);
        }
    });
    $("#takeOutMain").on("click", " .navOne",function () {
        var node = $(".navTwo");
        if ($(this).next().is(":hidden")) {
            if (node.is(":hidden")) {
                node.hide();
            } else {
                node.hide();
            }

            $(this).next().show();
        } else {
            if (node.is(":hidden")) {
                node.hide();
            } else {
                node.hide();
            }
        }
    });
    $("body").on("click", ".navTwoSon a",function () {
        var onHref = $(this).attr("href");
        $("#content").load(onHref);
        return false;
    });

})

function strJoint(navMessage) {
    var html = [];
    var id = 0;
    $.each(navMessage, function (index, value) {
        // console.log(index);
        var json = JSON.parse(JSON.stringify(value));
        // console.log(json.navOneName);

        if (json.navOneID != id) {
            html.push("</div><div class=\"navOne\">" + json.navOneName + "</div>");
            html.push("<div class=\"navTwo\"><div class=\"navTwoSon\"><a href=\"" + json.navTwoUrl + "\">" + json.navTwoName + "</a></div>");
        } else {
            html.push("<div class=\"navTwoSon\"><a href=\"" + json.navTwoUrl + "\">" + json.navTwoName + "</a></div>");
        }
        id = json.navOneID;
    })
    // console.log(html)
    html.push("</div><div class=\"navOne\">安全退出系统</div>");
    $("#navLeft").append(html.join(""));
}
