var SongLib = function () {
    var handleAdd = function () {
        var form = $('#addForm');
        var error = $('.alert-danger', form);
        var success = $('.alert-success', form);
        form.validate({
            errorElement: 'span',
            errorClass: 'help-block help-block-error',
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
            highlight: function (element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            submitHandler: function (form) {
                SongLib.add();
            }
        });
    }
    var handleUpdate = function () {
        var form = $('#updateForm');
        var error1 = $('.alert-danger', form);
        var success1 = $('.alert-success', form);
        form.validate({
            errorElement: 'span',
            errorClass: 'help-block help-block-error',
            onfocusout: true,
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
                    required: "请选择上传WAV文件",
                    accept: "只支持WAV格式音乐文件"
                },
                midiFile: {
                    required: "请选择上传MIDI文件",
                    accept: "只支持MIDI格式音乐文件"
                }
            },
            invalidHandler: function (event, validator) {
                success1.hide();
                error1.show();
            },
            highlight: function (element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            submitHandler: function (form) {
                SongLib.update();
            }
        });
    }
    return {
        edit: function (id) {
            $("#songId").val(id);
            var url = "/admin/meta/song/" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }

                var song = data.data;

                var form = $('#updateForm');
                $('#name', form).val(song.name);
                $('#description', form).val(song.description);
                $('#iconImg', form).attr("src", song.iconUrl);
                $('#ssImg', form).attr("src", song.opernScreenshotUrl);
                $('#opernImg', form).attr("src", song.opernUrl);
                $('#wavDwUrl', form).attr("href", song.wavPlayUrl);
                $('#midiDwUrl', form).val("href", song.midiPlayUrl);
            }, "json")
        },
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
        },
        refresh: function () {
            $("#basic_data_m3").click();
            $(".modal-backdrop").remove();
        },
        add: function () {
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
        update: function () {
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
            handleAdd();
            handleUpdate();
        }
    };
}();

SongLib.init();