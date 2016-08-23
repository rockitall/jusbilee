var SongLevel = function () {
    return {
        add: function () {
            $("#songLevelId").val("");
            $("#name").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name) {
            $("#songLevelId").val(id);
            $("#name").val(name);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            var yes = window.confirm("确定要删除么？");
            if (!yes) {
                return;
            }
            var url = "/admin/meta/song/level/delete?songLevelId=" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongLevel.refresh();
            }, "json")
        },
        save: function () {
            var _name = $.trim($("#name").val());
            if (!_name) {
                alert("闯关级别名称不能为空")
                return;
            }
            var id = $("#songLevelId").val();
            var url = !!id ? "/admin/meta/song/level/update?songLevelId=" + id : "/admin/meta/song/level/add";
            $.get(url, {name: _name}, function (data) {
                $("#formModal").modal("hide");
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongLevel.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m1").click();
            $(".modal-backdrop").remove();
        }
    };
}();