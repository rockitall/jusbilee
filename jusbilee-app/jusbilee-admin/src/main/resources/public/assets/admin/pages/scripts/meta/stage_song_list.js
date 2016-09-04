var StageSongManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/stage/song/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/stage/song/list", data);
            }
        },
        Editor: {
            show: function () {
                $("#stageSongRow").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#stageSongRow").hide();
            },
            reset: function () {
                var form = $('#stageSongForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#stageSongName", form).val("");
                $("#stageLevelId", form).val("");
                $("#online", form).iCheck("uncheck");
                $("#startTime", form).val("");
                $("#endTime", form).val("");
                $("#passScore", form).val("");
                $("#sortOrder", form).val("");
            },
            init: function () {
                $('#stageSongForm').validate({
                    //debug: true,
                    rules: {
                        stageLevelId: {
                            required: true
                        },
                        startTime: {
                            requireDependOn: ".stage-song-online"
                        },
                        endTime: {
                            requireDependOn: ".stage-song-online"
                        },
                        passScore: {
                            required: true,
                            integer: true
                        },
                        sortOrder: {
                            required: true,
                            integer: true
                        }
                    },
                    messages: {
                        stageLevelId: {
                            required: "请选择难易程度级别"
                        },
                        startTime: {
                            requireDependOn: "上线开始时间不能为空"
                        },
                        endTime: {
                            requireDependOn: "下线开始时间不能为空"
                        },
                        passScore: {
                            required: "过关分数不能为空",
                            integer: "过关分数必须为整数类型"
                        },
                        sortOrder: {
                            required: "排序不能为空",
                            integer: "排序必须为整数类型"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#stageSongForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        !!$("#stageSongId", $(form)).val() ? StageSongManager.Action.Update.submit() : StageSongManager.Action.Add.submit();
                    }
                });
            }
        },
        Action: {
            Add: {
                show: function (songId, name) {
                    StageSongManager.Editor.reset();
                    $("#songId", form).val(songId);
                    $("#stageSongName", form).val(name);
                },
                submit: function () {
                    var form = $("#stageSongForm");
                    var queryString = form.serialize();
                    $.post("/admin/meta/stage/song/add", queryString, function (result) {
                        StageSongManager.Editor.hide();
                        var content = '<a href="javascript:StageSongManager.Action.Update.show(\'' + result.data.id + '\')">';
                        content += '<span style="color:red">已设置<i class="fa fa-edit" style="margin-left: 4px"></i></span></a>';
                        $("#S" + result.data.id).html(content)
                    }, "json");
                }
            },
            Update: {
                show: function (id, songName) {
                    StageSongManager.Editor.reset();
                    $.get("/admin/meta/stage/song/" + id, {}, function (result) {
                        var song = result.data;
                        var form = $("#stageSongForm");
                        $("#stageLevelId", form).val(song.stageLevelId);
                        $("#songId", form).val(song.songId);
                        $("#stageSongId", form).val(id);
                        $("#stageSongName", form).val(songName);
                        if (song.online) {
                            $("#online", form).iCheck("check");
                            $("#startTime", form).val(song.startTime);
                            $("#endTime", form).val(song.endTime);
                        } else {
                            $("#online", form).iCheck("uncheck");
                            $("#startTime", form).val("");
                            $("#endTime", form).val("");
                        }
                        $("#passScore", form).val(song.passScore);
                        $("#sortOrder", form).val(song.sortOrder);

                        StageSongManager.Editor.show();
                    }, 'json');
                },
                submit: function () {
                    var queryString = $("#stageSongForm").serialize();
                    $.post("/admin/meta/stage/song/update", queryString, function (data, xhr) {
                        StageSongManager.Editor.hide();
                        if (StageSongManager.Action.Update.onSubmitCompleted) {
                            StageSongManager.Action.Update.onSubmitCompleted(data);
                        }
                    }, "json");
                },
                onSubmitCompleted: function (data) {
                    var pageNo = $("#pageNo").val();
                    StageSongManager.Pagination.goto(pageNo)
                }
            },
            Remove: {
                submit: function (id) {
                    if (window.confirm("确定要删除么？")) {
                        $.get("/admin/meta/stage/song/delete?id=" + id, {}, function (data) {
                            if (data.code != 200) {
                                alert(data.msg);
                                return;
                            }
                            StageSongManager.Initializer.refresh();
                        }, "json")
                    }
                }
            },
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo").val();
                StageSongManager.Pagination.goto(pageNo)
            },
            init: function () {
                $('.date-picker').datepicker({
                    rtl: Metronic.isRTL(),
                    orientation: "left",
                    autoclose: true
                });
                $(':checkbox').iCheck({
                    checkboxClass: 'icheckbox_flat-blue',
                    radioClass: 'iradio_flat-blue'
                });

                StageSongManager.Editor.init();
            }
        }
    };
}();