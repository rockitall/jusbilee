var AdminUserManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/user/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                var form = $("#pageForm");
                $("#pageNo", form).val(pageNo);
                var data = form.serialize();
                Index.load("/admin/user/list", data);
            }
        },
        Editor: {
            show: function () {
                $("#adminUserEditor").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#adminUserEditor").hide();
            },
            reset: function () {
                var form = $('#adminUserForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#username", form).val("");
                $("#nickname", form).val("");
                $("#password", form).val("");
                $("#c_password", form).val("");
                $("#mobile", form).val("");
                $("#email", form).val("");
                $("#userId", form).val("");
            },
            init: function () {
                $('#adminUserForm').validate({
                    //debug: true,
                    rules: {
                        username: {
                            required: true,
                            alphanumeric: true,
                            minlength: 4
                        },
                        nickname: {
                            required: true
                        },
                        password: {
                            requireWhenEnabled: true,
                            minlength: 6
                        },
                        c_password: {
                            equalTo: ".pwd"
                        }
                    },
                    messages: {
                        username: {
                            required: "登录名不能为空",
                            alphanumeric: "登录名只能为大小写字母、数字",
                            minlength: "登录名长度不能少于4个字符"
                        },
                        nickname: {
                            required: "用户昵称不能为空"
                        },
                        password: {
                            requireWhenEnabled: "登录密码不能为空",
                            minlength: "登录密码不能少于6个字符"
                        },
                        c_password: {
                            equalTo: "登录密码和确认密码不一致"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#adminUserForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        !!$("#userId", $(form)).val() ? AdminUserManager.Action.Update.submit() : AdminUserManager.Action.Add.submit();
                    }
                });
            }
        },
        Action: {
            Add: {
                show: function () {
                    AdminUserManager.Editor.reset();
                    AdminUserManager.Editor.show();
                    var form = $("#adminUserForm");
                    $("#password", form).val("").removeAttr("disabled").closest(".form-group").show();
                    $("#c_password", form).val("").removeAttr("disabled").closest(".form-group").show();
                    $("#username", form).val("").removeAttr("readonly");
                },
                submit: function () {
                    var form = $("#adminUserForm");
                    var queryString = form.serialize();
                    $.post("/admin/user/add", queryString, function (data) {
                        if(data.code==200){
                            Notific8.success("添加成功");
                            AdminUserManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Update: {
                show: function (id) {
                    AdminUserManager.Editor.reset();
                    $.get("/admin/user/" + id, {}, function (result) {
                        var user = result.data;
                        var form = $("#adminUserForm");
                        $("#userId", form).val(id);
                        $("#username", form).val(user.username);
                        $("#nickname", form).val(user.nickname);
                        $("#mobile", form).val(user.mobile);
                        $("#email", form).val(user.email);

                        $("#username", form).attr("readonly", "readonly");
                        $("#password", form).val("").attr("disabled", "disabled").closest(".form-group").hide();
                        $("#c_password", form).val("").attr("disabled", "disabled").closest(".form-group").hide();
                        var check = (user.isAdmin == 1 ? "check" : "uncheck");
                        $("#isAdmin", form).iCheck(check);
                        AdminUserManager.Editor.show();
                    }, 'json');
                },
                submit: function () {
                    var queryString = $("#adminUserForm").serialize();
                    $.post("/admin/user/update", queryString, function (data, xhr) {
                        if(data.code==200){
                            Notific8.success("更新成功");
                            AdminUserManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Remove: {
                submit: function (id) {
                    if (window.confirm("确定要删除么？")) {
                        $.get("/admin/user/delete?id=" + id, {}, function (data) {
                            if(data.code==200){
                                Notific8.success("删除成功");
                                AdminUserManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    }
                }
            },
            Lock: {
                submit: function (id) {
                    if (window.confirm("确定要锁定该用户么？")) {
                        $.get("/admin/user/lock?id=" + id, {}, function (data) {
                            if(data.code==200){
                                Notific8.success("锁定成功");
                                AdminUserManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    }
                },
            },
            Unlock: {
                submit: function (id) {
                    if (window.confirm("确定要解锁该用户么？")) {
                        $.get("/admin/user/unlock?id=" + id, {}, function (data) {
                            if(data.code==200){
                                Notific8.success("解锁成功");
                                AdminUserManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    }
                }
            },
            ResetPassword: {
                submit: function (id) {
                    if (window.confirm("确定要重设该用户密码么？")) {
                        $.get("/admin/user/pwd/reset?id=" + id, {}, function (data) {
                            if(data.code==200){
                                Notific8.success("重设密码成功");
                                AdminUserManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    }
                }
            }
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo", ("#pageForm")).val();
                AdminUserManager.Pagination.goto(pageNo);
            },
            init: function () {
                $(':checkbox').iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });
                AdminUserManager.Editor.init();
            }
        }
    };
}();