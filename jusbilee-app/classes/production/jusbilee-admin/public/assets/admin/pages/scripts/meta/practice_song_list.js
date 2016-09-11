var PracticeSongManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/practice/song/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/practice/song/list", data);
            }
        },
        Editor: {
            show: function () {
                $("#practiceSongRow").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#practiceSongRow").hide();
            },
            reset: function () {
                var form = $('#practiceSongRow');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#practiceSongName", form).val("");
                $("#songStyleId", form).val("");
                $("#online", form).iCheck("uncheck");
                $("#startTime", form).val("");
                $("#endTime", form).val("");
                $("#passStageUnlock", form).val("uncheck");
                $("#unlockGoldCoin", form).val("");
            },
            init: function () {
                var form = $('#practiceSongForm');
                var error3 = $('.alert-danger', form);
                var success3 = $('.alert-success', form);

                form.validate({
                    debug: true,
                    rules: {
                        songStyleId: {
                            required: true
                        },
                        startTime: {
                            requireDependOn: ".practice-song-online"
                        },
                        endTime: {
                            requireDependOn: ".practice-song-online"
                        },
                        unlockGoldCoin: {
                            required: true,
                            integer: true
                        }
                    },
                    messages: {
                        songStyleId: {
                            required: "请选择歌曲风格"
                        },
                        startTime: {
                            requireDependOn: "上线开始时间不能为空"
                        },
                        endTime: {
                            requireDependOn: "下线开始时间不能为空"
                        },
                        unlockGoldCoin: {
                            required: "解锁所需金币数不能为空",
                            integer: "解锁所需金币数必须为整数类型"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        success3.hide();
                        error3.show();
                    },
                    submitHandler: function (form) {
                        !!$("#practiceSongId", $(form)).val() ?PracticeSongManager.Action.Update.submit() : PracticeSongManager.Action.Add.submit();
                    }
                });
            },
        },
        Action: {
            Add: {
                show: function (songId, name) {
                    PracticeSongManager.Editor.reset();
                    $("#songId", form).val(songId);
                    $("#practiceSongName", form).val(name);
                },
                submit: function () {
                    var form = $("#practiceSongRow");
                    var queryString = form.serialize();
                    $.post("/admin/meta/practice/song/add", queryString, function (data) {
                        if(data.code==200){
                            Notific8.success("添加成功");
                            PracticeSongManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Update: {
                show: function (id, songName) {
                    PracticeSongManager.Editor.reset();
                    $.get("/admin/meta/practice/song/" + id, {}, function (result) {
                        var song = result.data;
                        var form = $("#practiceSongForm");
                        $("#songStyleId", form).val(song.styleId);
                        $("#songId", form).val(song.songId);
                        $("#practiceSongId", form).val(id);
                        $("#practiceSongName", form).val(songName);
                        if (song.online) {
                            $("#online", form).iCheck("check");
                            $("#startTime", form).val(song.startTime);
                            $("#endTime", form).val(song.endTime);
                        } else {
                            $("#online", form).iCheck("uncheck");
                            $("#startTime", form).val("");
                            $("#endTime", form).val("");
                        }
                        $("#unlockGoldCoin", form).val(song.unlockGoldCoin);
                        if (song.passStageUnlock == 1) {
                            $("#passStageUnlock", form).iCheck("check");
                        } else {
                            $("#passStageUnlock", form).iCheck("uncheck");
                        }
                        PracticeSongManager.Editor.show();
                    }, 'json');
                },
                submit: function () {
                    var queryString = $("#practiceSongForm").serialize();
                    $.post("/admin/meta/practice/song/update", queryString, function (data, xhr) {
                        if(data.code==200){
                            Notific8.success("更新成功");
                            PracticeSongManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json");
                }
            },
            Remove: {
                submit: function (id) {
                    if (window.confirm("确定要删除么？")) {
                        $.get("/admin/meta/practice/song/delete?id=" + id, {}, function (data) {
                            if(data.code==200){
                                Notific8.success("删除成功");
                                PracticeSongManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    }
                }
            },
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo").val();
                PracticeSongManager.Pagination.goto(pageNo)
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

                PracticeSongManager.Editor.init();
            }
        }
    };
}();