var SongStyle = function () {
    return {
        add: function () {
            $("#songStyleId").val("");
            $("#name").val("");
            $("#sortOrder").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, name, sortOrder) {
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
            if (!_name) {
                alert("歌曲风格名称不能为空")
                return;
            }
            if (!_sortOrder) {
                alert("排序不能为空")
                return;
            }
            var id = $("#songStyleId").val();
            var url = !!id ? "/admin/meta/song/style/update?songStyleId=" + id : "/admin/meta/song/style/add";
            $.get(url, {name: _name, sortOrder:_sortOrder}, function (data) {
                $("#formModal").modal("hide");
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongStyle.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m2").click();
            $(".modal-backdrop").remove();
        }
    };
}();