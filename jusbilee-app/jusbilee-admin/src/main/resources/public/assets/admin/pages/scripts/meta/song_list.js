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
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/song/list", data);
            }
        },
        Add: {
            show: function () {
                $("#addRow").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#addRow").hide();
            },
            submit: function () {
                var formData = new FormData($("#addForm")[0]);
                $.ajax({
                    url: '/admin/meta/song/add',
                    type: 'POST',
                    data: formData,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (returndata) {
                        SongLib.refresh();
                    },
                    error: function (returndata) {
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
                        description: {
                            required: true
                        },
                        iconFile: {
                            required: true,
                            accept: "image/png,image/jpeg"
                        },
                        screenshotFile: {
                            required: true,
                            accept: "image/png,image/jpeg"
                        },
                        opernFile: {
                            required: true,
                            accept: "image/png,image/jpeg"
                        },
                        wavFile: {
                            required: true,
                            accept: "audio/wav"
                        },
                        midiFile: {
                            required: true,
                            accept: "audio/mid"
                        }
                    },
                    messages: {
                        name: {
                            required: "歌曲名称不能为空"
                        },
                        description: {
                            required: "描述不能为空"
                        },
                        iconFile: {
                            required: "请选择上传图片",
                            accept: "只支持jpg,png格式图片"
                        },
                        screenshotFile: {
                            required: "请选择上传图片",
                            accept: "只支持jpg,png格式图片"
                        },
                        opernFile: {
                            required: "请选择上传图片",
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
                    $('#midiDwUrl', form).val("href", song.midiPlayUrl);

                    SongManager.Edit.show();
                }, "json")
            },
            show: function () {
                $("#updateRow").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#updateRow").hide();
            },
            submit: function () {
                var id = $("#songId").val();
                var formData = new FormData($("#updateForm")[0]);
                formData.append("songId", id);
                $.ajax({
                    url: '/admin/meta/song/update',
                    type: 'POST',
                    data: formData,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (returndata) {
                        SongLib.refresh();
                    },
                    error: function (returndata) {
                        console.log("error");
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
                            accept: "audio/mid"
                        }
                    },
                    messages: {
                        name: {
                            required: "歌曲名称不能为空"
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
                var yes = window.confirm("确定要删除么？");
                if (!yes) {
                    return;
                }
                var url = "/admin/meta/song/delete?songId=" + id;
                $.get(url, {}, function (data) {
                    if (data.code != 200) {
                        alert(data.msg);
                        return;
                    }
                    SongLib.refresh();
                }, "json")
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
                        $("#stageLevelId", form).val(song.stageLevelId);
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
            },
            hide: function () {
                $("#listRow").show();
                $("#stageSongRow").hide();
            },
            submit: function () {
                var form = $("#stageSongForm");
                var id = $("#stageSongId", form).val();
                var isUpdate = (id != "");
                var url = (isUpdate ? "/admin/meta/stage/song/update" : "/admin/meta/stage/song/add");
                var queryString = form.serialize();
                $.post(url, queryString, function (result) {
                    SongManager.Stage.hide();
                    if (!isUpdate) {
                        id=result.data.id;
                        var songId = $("#songId", form).val();
                        var songName = $("#stageSongName", form).val();
                        var content = '<a href="javascript:SongManager.Stage.edit(\'' + songId + '\',\'' + songName + '\',\'' + id + '\')"><span style="color:red">已设置<i class="fa fa-edit" style="margin-left: 4px"></i></span></a>';
                        $("#S" + songId).html(content)
                    }
                }, "json");
            },
            init: function () {
                var form = $('#stageSongForm');
                var error2 = $('.alert-danger', form);
                var success2 = $('.alert-success', form);

                form.validate({
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
                        $("#songStyleId", form).val(song.styleId);
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
                    $("#songStyleId", form).val("");
                    $("#practiceSongId", form).val("");
                    SongManager.Practice.show();
                }
            },
            show: function () {
                $("#practiceSongRow").show();
                $("#listRow").hide();
            },
            hide: function () {
                $("#listRow").show();
                $("#practiceSongRow").hide();
            },
            submit: function () {
                var form = $('#practiceSongForm');
                var id = $("#practiceSongId", form).val();
                var isUpdate = (id != "");
                var url = (isUpdate ? "/admin/meta/practice/song/update" : "/admin/meta/practice/song/add");
                var queryString = $('#practiceSongForm').serialize()
                $.post(url, queryString, function (result) {
                    SongManager.Practice.hide();
                    if (!isUpdate) {
                        id=result.data.id;
                        var songId = $("#songId", form).val();
                        var songName = $("#practiceSongName", form).val();
                        var content = '<a href="javascript:SongManager.Practice.edit(\'' + songId + '\',\'' + songName + '\',\'' + id + '\')"><span style="color:red">已设置<i class="fa fa-edit" style="margin-left: 4px"></i></span></a>';
                        $("#P" + songId).html(content)
                    }
                }, "json");
            },
            init: function () {
                var form = $('#practiceSongForm');
                var error3 = $('.alert-danger', form);
                var success3 = $('.alert-success', form);

                form.validate({
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
                $("#basic_data_m3").click();
                $(".modal-backdrop").remove();
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