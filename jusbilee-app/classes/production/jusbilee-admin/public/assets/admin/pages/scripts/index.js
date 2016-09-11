var Index = function () {
    var bindEvent = function () {

    };
    return {
        //main function to initiate the module
        init: function () {
            bindEvent();
            Index.heatbeat();
        },
        menuLink: function (url) {
            Index.load(url, {});
        },
        load: function (url, data, method) {
            if (!!method && method.toLowerCase() == "post") {
                $.post(url, data, function (data, xhr) {
                    $(".page-content-wrapper").html(data);
                }, "text");
            } else {
                $.get(url, data, function (data, xhr) {
                    $(".page-content-wrapper").html(data);
                }, "text");
            }
        },
        heatbeat: function () {
            setInterval(function () {
                $.get("/admin/heartbeat", function () {
                });
            }, 1000 * 60 * 5);
        },
    };
}();

var Notific8 = function () {
    var settings = {
        horizontalEdge: "top",
        verticalEdge: "right",
        life: 1000
    };
    $.notific8('zindex', 11500);
    return {
        success: function (msg) {
            var settings = $.extend({theme: "teal", heading: "Success!"}, settings);
            $.notific8(msg, settings);
        },
        error: function (msg) {
            var settings = $.extend({theme: "teal", heading: "Error!!!"}, settings);
            $.notific8(msg, settings);
        }
    }
}();