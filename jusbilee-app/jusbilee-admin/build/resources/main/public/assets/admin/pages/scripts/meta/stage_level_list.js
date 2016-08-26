var StageLevel = function () {
    return {
        add: function () {
            $("#stageLevelId").val("");
            $("#name").val("");
            $("#weight").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name, weight) {
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
            if (!_name) {
                alert("闯关级别名称不能为空")
                return;
            }
            if (!_weight) {
                alert("难易程度权重不能为空")
                return;
            }
            var id = $("#stageLevelId").val();
            var url = !!id ? "/admin/meta/stage/level/update?stageLevelId=" + id : "/admin/meta/stage/level/add";
            $.get(url, {name: _name, weight:_weight}, function (data) {
                $("#formModal").modal("hide");
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                StageLevel.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m1").click();
            $(".modal-backdrop").remove();
        }
    };
}();