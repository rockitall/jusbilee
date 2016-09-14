var SongLevel = function () {
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
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            onfocusout: true,
            rules: {
                name: {
                    required: true
                },
                weight: {
                    required: true,
                    digits: true
                }
            },

            messages: {
                name: {
                    required: "闯关级别名称不能为空"
                },
                weight: {
                    required: "难易程度权重不能为空",
                    digits: "请输入一个有效的整数"
                }
            },

            invalidHandler: function (event, validator) {
                success.hide();
                error.show();
            },
            submitHandler: function (form) {
                SongLevel.save();
            }
        });
    }

    return {
        add: function () {
            clear();

            $("#levelId").val("");
            $("#name").val("");
            $("#weight").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name, weight) {
            clear();

            $("#levelId").val(id);
            $("#name").val(name);
            $("#weight").val(weight);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            bootbox.confirm("确定要删除么？", function (sure) {
                if (!sure) return;
                var url = "/admin/meta/song/level/delete?levelId=" + id;
                $.get(url, {}, function (data) {
                    if (data.code != 200) {
                        alert(data.msg);
                        return;
                    }
                    SongLevel.refresh();
                }, "json")
            });
        },
        save: function () {
            var _name = $.trim($("#name").val());
            var _weight = $.trim($("#weight").val());
            var id = $("#levelId").val();
            var url = !!id ? "/admin/meta/song/level/update?levelId=" + id : "/admin/meta/song/level/add";
            $.get(url, {name: _name, weight: _weight}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                $("#formModal").modal("hide");
                SongLevel.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m1").click();
            $(".modal-backdrop").remove();
        },
        init: function () {
            handSave();
        }
    };
}();

SongLevel.init();