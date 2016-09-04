var Index = function () {
    var bindEvent = function () {

    };
    return {
        //main function to initiate the module
        init: function () {
            bindEvent();
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
        }
    };
}();