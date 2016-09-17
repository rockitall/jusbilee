var SongSubLevelManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/song/sublevel/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/song/sublevel/list", data);
            }
        },
        Editor: {
            show: function () {
                $("#editor").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#editor").hide();
            },
            reset: function () {
                var form = $('#editorForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#levelId", form).val("");
                $("#score", form).val("");
                $("#subLevelId", form).val("");
                $("#subLevelName", form).val("");
            },
            init: function () {
                $('#editorForm').validate({
                    //debug: true,
                    rules: {
                        levelId: {
                            required: true,
                        },
                        score: {
                            required: true,
                            integer: true
                        },
                        subLevelName: {
                            required: true,
                        }
                    },
                    messages: {
                        levelId: {
                            required: "请选择难易级别"
                        },
                        score: {
                            required: "分值不能为空",
                            integer: "分值必须是整数"
                        },
                        subLevelName: {
                            required: "段位名称不能为空"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#editorForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        !!$("#subLevelId", $(form)).val() ? SongSubLevelManager.Action.Update.submit() : SongSubLevelManager.Action.Add.submit();
                    }
                });
            }
        },
        Action: {
            Add: {
                show: function () {
                    $(".form-section").text("添加新段位");
                    SongSubLevelManager.Editor.reset()
                    SongSubLevelManager.Editor.show();
                },
                submit: function () {
                    var form = $("#editorForm");
                    var params = form.serialize();
                    $.post("/admin/meta/song/sublevel/add", params, function (data) {
                        if (data.code == 200) {
                            Notific8.success("添加成功");
                            SongSubLevelManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Update: {
                show: function (id, songName) {
                    $(".form-section").text("编辑歌曲段位");
                    SongSubLevelManager.Editor.reset();
                    $.get("/admin/meta/song/sublevel/" + id, {}, function (result) {
                        var sub = result.data;
                        var form = $("#editorForm");
                        $("#subLevelId", form).val(id);
                        $("#subLevelName", form).val(sub.subLevelName);
                        $("#levelId", form).val(sub.levelId);
                        $("#score", form).val(sub.score);

                        SongSubLevelManager.Editor.show();
                    }, 'json');
                },
                submit: function () {
                    var params = $("#editorForm").serialize();
                    $.post("/admin/meta/song/sublevel/update", params, function (data) {
                        if (data.code == 200) {
                            Notific8.success("更新成功");
                            SongSubLevelManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Remove: {
                submit: function (id) {
                    bootbox.confirm("确定要删除么？", function (sure) {
                        if (!sure) return;
                        $.get("/admin/meta/song/sublevel/delete?subLevelId=" + id, {}, function (data) {
                            if (data.code == 200) {
                                Notific8.success("删除成功");
                                SongSubLevelManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    });
                }
            },
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo").val();
                SongSubLevelManager.Pagination.goto(pageNo)
            },
            init: function () {
                SongSubLevelManager.Editor.init();
            }
        }
    };
}();