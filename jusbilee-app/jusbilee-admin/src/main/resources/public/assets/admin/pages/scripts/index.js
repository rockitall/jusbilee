var UserProfile = function () {
    return {
        Password: {
            show: function () {
                var form = $("#passwordModifyForm");
                $("#oldUserPassword", form).val("");
                $("#userPassword", form).val("");
                $("#c_userPassword", form).val("");
                $("#passwordModifyModal").modal("show");
            },
            hide: function () {
                $("#passwordModifyModal").modal("hide");
            },
            submit: function () {
                var form = $("#passwordModifyForm");
                var data = form.serialize();
                $.post("/admin/user/profile/pwd/reset", data, function (data) {
                    if (data.code == 200) {
                        Notific8.success("修改密码成功");
                        UserProfile.Password.hide();
                        return;
                    }
                    Notific8.error(data.msg);
                }, "json");
            },
            init: function () {
                $('#passwordModifyForm').validate({
                    rules: {
                        oldUserPassword: {
                            required: true
                        },
                        userPassword: {
                            required: true,
                            minlength: 6
                        },
                        c_userPassword: {
                            equalTo: "#userPassword"
                        }
                    },
                    messages: {
                        oldUserPassword: {
                            required: "原密码不能为空",
                        },
                        userPassword: {
                            required: "新密码不能为空",
                            minlength: "密码不能少于6个字符"
                        },
                        c_userPassword: {
                            equalTo: "新密码和确认密码不一致"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#passwordModifyForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        UserProfile.Password.submit();
                    }
                });
            }
        }
    }
}();

var Index = function () {
    var bindEvent = function () {

    };
    return {
        //main function to initiate the module
        init: function () {
            bindEvent();
            Index.heatbeat();
            UserProfile.Password.init();
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
            var settings = $.extend({theme: "ruby", heading: "Error!!!"}, settings);
            $.notific8(msg, settings);
        }
    }
}();

