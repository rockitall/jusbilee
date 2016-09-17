var RaceSeasonManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/race/season/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/race/season/list", data);
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

                $("#seasonId", form).val("");
                $("#seasonName", form).val("");
                $("#startTime", form).val("");
                $("#endTime", form).val("");
            },
            init: function () {
                $('#editorForm').validate({
                    rules: {
                        startTime: {
                            required: true
                        },
                        endTime: {
                            required: true
                        },
                        seasonName: {
                            required: true
                        }
                    },
                    messages: {
                        startTime: {
                            requireDependOn: "赛季开始时间不能为空"
                        },
                        endTime: {
                            requireDependOn: "赛季结束时间不能为空"
                        },
                        seasonName: {
                            required: "赛季名称不能为空"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#editorForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        !!$("#seasonId", $(form)).val() ? RaceSeasonManager.Action.Update.submit() : RaceSeasonManager.Action.Add.submit();
                    }
                });
            }
        },
        Action: {
            Add: {
                show: function () {
                    RaceSeasonManager.Editor.reset();
                    RaceSeasonManager.Editor.show();
                    $(".form-section").text("添加新赛季");
                },
                submit: function () {
                    var form = $("#editorForm");
                    var queryString = form.serialize();
                    $.post("/admin/meta/race/season/add", queryString, function (data) {
                        if (data.code == 200) {
                            Notific8.success("添加成功");
                            RaceSeasonManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Update: {
                show: function (id, songName) {
                    RaceSeasonManager.Editor.reset();
                    $(".form-section").text("编辑赛季");
                    $.get("/admin/meta/race/season/" + id, {}, function (result) {
                        var season = result.data;
                        var form = $("#editorForm");
                        $("#seasonId", form).val(id);
                        $("#seasonName", form).val(season.seasonName);
                        $("#startTime", form).val(season.startTime);
                        $("#endTime", form).val(season.endTime);
                        RaceSeasonManager.Editor.show();
                    }, 'json');
                },
                submit: function () {
                    var params = $("#editorForm").serialize();
                    $.post("/admin/meta/race/season/update", params, function (data) {
                        if (data.code == 200) {
                            Notific8.success("更新成功");
                            RaceSeasonManager.Initializer.refresh();
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
                        $.get("/admin/meta/race/season/delete?seasonId=" + id, {}, function (data) {
                            if (data.code == 200) {
                                Notific8.success("删除成功");
                                RaceSeasonManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    });
                }
            },
            Song: {
                manage: function (id) {
                    Index.load("/admin/meta/race/season/song/list", {seasonId: id})
                }
            },
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo").val();
                RaceSeasonManager.Pagination.goto(pageNo)
            },
            init: function () {
                $('.date-picker').datepicker({
                    rtl: Metronic.isRTL(),
                    orientation: "left",
                    autoclose: true
                });
                RaceSeasonManager.Editor.init();
            }
        }
    };
}();