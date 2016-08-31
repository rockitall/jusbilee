var StageLevel = function () {
    var form = $('#form');
    var error = $('.alert-danger', form);
    var success = $('.alert-success', form);

    function clear(){
        success.hide();
        error.show();
        form.find('.form-group').removeClass('has-error');
        form.find(".help-block-error").remove();
    }

    var handSave = function() {

        form.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            onfocusout:true,
            rules: {
                name: {
                    required: true
                },
                weight: {
                    required: true,
                    digits:true
                }
            },

            messages: {
                name: {
                    required: "请输入闯关级别名称"
                },
                weight: {
                    required: "请输入难易程度权重",
                    digits:"请输入一个有效的整数"
                }
            },

            invalidHandler: function(event, validator) {
                success.hide();
                error.show();
            },
            highlight: function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function(element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            submitHandler: function(form) {
                StageLevel.save();
            }
        });
    }

    return {
        add: function () {
            clear();

            $("#stageLevelId").val("");
            $("#name").val("");
            $("#weight").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name, weight) {
            clear();

            $("#stageLevelId").val(id);
            $("#name").val(name);
            $("#weight").val(weight);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            var yes = window.confirm("确定要删除么？");
            if (!yes) {
                return;
            }
            var url = "/admin/meta/stage/level/delete?stageLevelId=" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                StageLevel.refresh();
            }, "json")
        },
        save: function () {
            var _name = $.trim($("#name").val());
            var _weight = $.trim($("#weight").val());
            var id = $("#stageLevelId").val();
            var url = !!id ? "/admin/meta/stage/level/update?stageLevelId=" + id : "/admin/meta/stage/level/add";
            $.get(url, {name: _name, weight:_weight}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                $("#formModal").modal("hide");
                StageLevel.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m1").click();
            $(".modal-backdrop").remove();
        },
        init: function() {
            handSave();
        }
    };
}();

StageLevel.init();