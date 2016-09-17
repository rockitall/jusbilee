var SongManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/song/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                var form = $("#pageForm");
                $("#pageNo", form).val(pageNo);
                var data = form.serialize();
                Index.load("/admin/meta/song/list", data);
            }
        },
        Add: {
            show: function () {
                $("#addRow").show();
                $("#listRow").hide();
                $("#updateRow").hide();
                $("#stageSongRow").hide();
                $("#practiceSongRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#addRow").hide();
                $("#updateRow").hide();
                $("#stageSongRow").hide();
                $("#practiceSongRow").hide();
            },
            submit: function () {
                Metronic.blockUI({
                    target: '#addRow',
                    animate: true
                });
                var formData = new FormData($("#addForm")[0]);
                $.ajax({
                    url: '/admin/meta/song/add',
                    type: 'POST',
                    data: formData,
                    async: true,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        Metronic.unblockUI("#addRow");
                        if (data.code == 200) {
                            Notific8.success("添加歌曲成功");
                            SongManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    },
                    error: function (returndata) {
                        Metronic.unblockUI("#addRow");
                        console.log("error");
                    }
                });
            },
            init: function () {
                var form = $('#addForm');
                var error = $('.alert-danger', form);
                var success = $('.alert-success', form);
                form.validate({
                    rules: {
                        name: {
                            required: true
                        },
                        levelId: {
                            required: true
                        },
                        styleId: {
                            required: true
                        },
                        description: {
                            required: true
                        },
                        iconFile: {
                            required: true,
                            accept: "image/png,image/jpeg"
                        },
                        screenshotFile: {
                            required: false,
                            accept: "image/png,image/jpeg"
                        },
                        opernFile: {
                            required: false,
                            accept: "image/png,image/jpeg"
                        },
                        wavFile: {
                            required: true,
                            accept: "audio/wav"
                        },
                        midiFile: {
                            required: true,
                            accept: "audio/mid,audio/midi"
                        }
                    },
                    messages: {
                        name: {
                            required: "歌曲名称不能为空"
                        },
                        levelId: {
                            required: "请选择歌曲难易级别"
                        },
                        styleId: {
                            required: "请选择歌曲风格"
                        },
                        description: {
                            required: "描述不能为空"
                        },
                        iconFile: {
                            required: "请选择上传图片",
                            accept: "只支持jpg,png格式图片"
                        },
                        screenshotFile: {
                            accept: "只支持jpg,png格式图片"
                        },
                        opernFile: {
                            accept: "只支持jpg,png格式图片"
                        },
                        wavFile: {
                            required: "请选择上传WAV文件",
                            accept: "只支持WAV格式音乐文件"
                        },
                        midiFile: {
                            required: "请选择上传MIDI文件",
                            accept: "只支持MIDI格式音乐文件"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        success.hide();
                        error.show();
                    },
                    submitHandler: function (form) {
                        SongManager.Add.submit();
                    }
                });
            }
        },
        Edit: {
            edit: function (id) {
                var form = $('#updateForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");
                $("#songId", form).val(id);
                $.get("/admin/meta/song/" + id, {}, function (data) {
                    if (data.code != 200) {
                        alert(data.msg);
                        return;
                    }
                    var song = data.data;
                    $('#name', form).val(song.name);
                    $('#description', form).val(song.description);
                    $('#iconImg', form).attr("src", song.iconUrl);
                    $('#ssImg', form).attr("src", song.opernScreenshotUrl);
                    $('#opernImg', form).attr("src", song.opernUrl);
                    $('#wavDwUrl', form).attr("href", song.wavPlayUrl);
                    $('#midiDwUrl', form).attr("href", song.midiPlayUrl);
                    $('#levelId', form).val(song.levelId);
                    $('#styleId', form).val(song.styleId);

                    SongManager.Edit.show();
                }, "json")
            },
            show: function () {
                $("#updateRow").show();
                $("#listRow").hide();
                $("#addRow").hide();
                $("#stageSongRow").hide();
                $("#practiceSongRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#addRow").hide();
                $("#updateRow").hide();
                $("#stageSongRow").hide();
                $("#practiceSongRow").hide();
            },
            submit: function () {
                var id = $("#songId").val();
                var formData = new FormData($("#updateForm")[0]);
                formData.append("songId", id);
                Metronic.blockUI({
                    target: '#updateRow',
                    animate: true
                });
                $.ajax({
                    url: '/admin/meta/song/update',
                    type: 'POST',
                    data: formData,
                    async: true,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        Metronic.unblockUI("#updateRow");
                        if (data.code == 200) {
                            Notific8.success("更新歌曲成功");
                            SongManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    },
                    error: function (returndata) {
                        Metronic.unblockUI("#updateRow");
                    }
                });
            },
            init: function () {
                var form = $('#updateForm');
                var error1 = $('.alert-danger', form);
                var success1 = $('.alert-success', form);
                form.validate({
                    rules: {
                        name: {
                            required: true
                        },
                        levelId: {
                            required: true
                        },
                        styleId: {
                            required: true
                        },
                        description: {
                            required: true
                        },
                        iconFile: {
                            accept: "image/png,image/jpeg"
                        },
                        screenshotFile: {
                            accept: "image/png,image/jpeg"
                        },
                        opernFile: {
                            accept: "image/png,image/jpeg"
                        },
                        wavFile: {
                            accept: "audio/wav"
                        },
                        midiFile: {
                            accept: "audio/mid,audio/midi"
                        }
                    },
                    messages: {
                        name: {
                            required: "歌曲名称不能为空"
                        },
                        levelId: {
                            required: "请选择歌曲难易级别"
                        },
                        styleId: {
                            required: "请选择歌曲风格"
                        },
                        description: {
                            required: "描述不能为空"
                        },
                        iconFile: {
                            accept: "只支持jpg,png格式图片"
                        },
                        screenshotFile: {
                            accept: "只支持jpg,png格式图片"
                        },
                        opernFile: {
                            accept: "只支持jpg,png格式图片"
                        },
                        wavFile: {
                            accept: "只支持WAV格式音乐文件"
                        },
                        midiFile: {
                            accept: "只支持MIDI格式音乐文件"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        success1.hide();
                        error1.show();
                    },
                    submitHandler: function (form) {
                        SongManager.Edit.submit();
                    }
                });
            }
        },
        Removal: {
            remove: function (id) {
                bootbox.confirm("确定要删除么？", function (sure) {
                    if (!sure) return;
                    var url = "/admin/meta/song/delete?songId=" + id;
                    $.get(url, {}, function (data) {
                        if (data.code == 200) {
                            Notific8.success("删除成功");
                            SongManager.Initializer.refresh()
                            return;
                        }
                        Notific8.error("删除失败");
                    }, "json")
                });
            }
        },
        Stage: {
            edit: function (songId, name, stageSongId) {
                var form = $('#stageSongForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#songId", form).val(songId);
                $("#stageSongName", form).val(name);
                if (stageSongId != null) { //update model
                    $("#stageSongId", form).val(stageSongId);
                    $.get("/admin/meta/stage/song/" + stageSongId, {}, function (result) {
                        var song = result.data;
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
                        SongManager.Stage.show();
                    })
                } else {
                    SongManager.Stage.show();
                }
            },
            show: function () {
                $("#stageSongRow").show();
                $("#listRow").hide();
                $("#addRow").hide();
                $("#practiceSongRow").hide();
                $("#updateRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#stageSongRow").hide();
                $("#addRow").hide();
                $("#practiceSongRow").hide();
                $("#updateRow").hide();
            },
            submit: function () {
                var form = $("#stageSongForm");
                var id = $("#stageSongId", form).val();
                var isUpdate = (id != "");
                var url = (isUpdate ? "/admin/meta/stage/song/update" : "/admin/meta/stage/song/add");
                var queryString = form.serialize();
                $.post(url, queryString, function (data) {
                    if (data.code == 200) {
                        Notific8.success("设置闯关成功");
                        SongManager.Initializer.refresh();
                        return;
                    }
                    Notific8.error("设置闯关失败");
                }, "json");
            },
            init: function () {
                var form = $('#stageSongForm');
                var error2 = $('.alert-danger', form);
                var success2 = $('.alert-success', form);

                form.validate({
                    rules: {
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
                        success2.hide();
                        error2.show();
                    },
                    submitHandler: function (form) {
                        SongManager.Stage.submit();
                    }
                });
            }
        },
        Practice: {
            edit: function (songId, name, practiceSongId) {
                var form = $('#practiceSongForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");

                $("#songId", form).val(songId);
                $("#practiceSongName", form).val(name);
                if (practiceSongId != null) { //update model
                    $("#practiceSongId", form).val(practiceSongId);
                    $.get("/admin/meta/practice/song/" + practiceSongId, {}, function (result) {
                        var song = result.data;
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
                        if (song.passStageUnlock) {
                            $("#passStageUnlock", form).iCheck("check");
                        } else {
                            $("#passStageUnlock", form).iCheck("uncheck");
                        }
                        SongManager.Practice.show();
                    })
                } else {
                    $("#online", form).iCheck("uncheck");
                    $("#passStageUnlock", form).iCheck("uncheck");
                    $("#unlockGoldCoin", form).val("");
                    $("#startTime", form).val("");
                    $("#endTime", form).val("");
                    $("#practiceSongId", form).val("");
                    SongManager.Practice.show();
                }
            },
            show: function () {
                $("#practiceSongRow").show();
                $("#listRow").hide();
                $("#addRow").hide();
                $("#stageSongRow").hide();
                $("#updateRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#practiceSongRow").hide();
                $("#addRow").hide();
                $("#stageSongRow").hide();
                $("#updateRow").hide();
            },
            submit: function () {
                var form = $('#practiceSongForm');
                var id = $("#practiceSongId", form).val();
                var isUpdate = (id != "");
                var url = (isUpdate ? "/admin/meta/practice/song/update" : "/admin/meta/practice/song/add");
                var queryString = $('#practiceSongForm').serialize()
                $.post(url, queryString, function (data) {
                    if (data.code == 200) {
                        Notific8.success("设置练习成功");
                        SongManager.Initializer.refresh();
                        return;
                    }
                    Notific8.error("设置练习失败");
                }, "json");
            },
            init: function () {
                var form = $('#practiceSongForm');
                var error3 = $('.alert-danger', form);
                var success3 = $('.alert-success', form);

                form.validate({
                    rules: {
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
                        SongManager.Practice.submit();
                    }
                });
            },
            resetForm: function () {
                var form = $('#practiceSongForm');
                form.validate().resetForm();
                $('.has-error', form).removeClass("has-error");
            }
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo", $("#pageForm")).val();
                SongManager.Pagination.goto(pageNo)
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

                SongManager.Add.init();
                SongManager.Edit.init();
                SongManager.Stage.init();
                SongManager.Practice.init();
            }
        }
    };
}();