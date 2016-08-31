var SongStyle = function () {
    var form = $('#form');
    var error = $('.alert-danger', form);
    var success = $('.alert-success', form);

    function clear(){
        success.hide();
        error.show();
        form.find('.form-group').removeClass('has-error');
        form.find(".help-block-error").remove();
    }

    var handSave = function () {

        form.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            onfocusout: true,
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
                    required: "请输入歌曲风格名称"
                },
                sortOrder: {
                    required: "请输入排序序号",
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

            $("#songStyleId").val(id);
            $("#name").val(name);
            $("#sortOrder").val(sortOrder);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            var yes = window.confirm("确定要删除么？");
            if (!yes) {
                return;
            }
            var url = "/admin/meta/song/style/delete?songStyleId=" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongStyle.refresh();
            }, "json")
        },
        save: function () {
            var _name = $.trim($("#name").val());
            var _sortOrder = $.trim($("#sortOrder").val());
            var id = $("#songStyleId").val();
            var url = !!id ? "/admin/meta/song/style/update?songStyleId=" + id : "/admin/meta/song/style/add";
            $.get(url, {name: _name, sortOrder: _sortOrder}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                $("#formModal").modal("hide");
                SongStyle.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m2").click();
            $(".modal-backdrop").remove();
        },
        init: function() {
            handSave();
        }
    };
}();


SongStyle.init();