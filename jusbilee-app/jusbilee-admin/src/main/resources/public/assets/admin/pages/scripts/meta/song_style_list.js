var SongStyle = function () {
    var form = $('#form');
    var error = $('.alert-danger', form);
    var success = $('.alert-success', form);

    function clear() {
        success.hide();
        error.show();
        form.find('.form-group').removeClass('has-error');
        form.find(".help-block-error").remove();
    }

    var handSave = function () {
        form.validate({
            rules: {
                name: {
                    required: true
                },
                sortOrder: {
                    required: true,
                    digits: true
                }
            },

            messages: {
                name: {
                    required: "歌曲风格名称不能为空"
                },
                sortOrder: {
                    required: "排序序号不能为空",
                    digits: "请输入一个有效的整数"
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
                SongStyle.save();
            }
        });
    }

    return {
        add: function () {
            clear();

            $("#songStyleId").val("");
            $("#name").val("");
            $("#sortOrder").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name, sortOrder) {
            clear();

            $("#styleId").val(id);
            $("#name").val(name);
            $("#sortOrder").val(sortOrder);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            bootbox.confirm("确定要删除么？", function (sure) {
                if (!sure) return;
                var url = "/admin/meta/song/style/delete?songStyleId=" + id;
                $.get(url, {}, function (data) {
                    if (data.code == 200) {
                        Notific8.success("删除成功");
                        SongStyle.refresh();
                        return;
                    }
                    Notific8.error(data.msg);
                }, "json")
            });
        },
        save: function () {
            var _name = $.trim($("#name").val());
            var _sortOrder = $.trim($("#sortOrder").val());
            var id = $("#styleId").val();
            var url = !!id ? "/admin/meta/song/style/update?styleId=" + id : "/admin/meta/song/style/add";
            $.get(url, {name: _name, sortOrder: _sortOrder}, function (data) {
                if (data.code == 200) {
                    if (!!id) {
                        Notific8.success("更新成功");
                    } else {
                        Notific8.success("添加成功");
                    }
                    SongStyle.refresh();
                    return;
                }
                Notific8.error(data.msg);
            }, "json")
        },
        refresh: function () {
            $("#formModal").modal("hide");
            window.setTimeout(function () {
                Index.load("/admin/meta/song/style/list");
            },500)
        },
        init: function () {
            handSave();
        }
    };
}();


SongStyle.init();