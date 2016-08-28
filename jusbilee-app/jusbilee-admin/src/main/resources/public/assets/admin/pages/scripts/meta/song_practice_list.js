var SongPracties = function () {
    return {
        add: function () {
            $("#songPracticeId").val("");
            $("#name").val("");
            $("#lockGoldCoin").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, songId, styleId,lockGoldCoin) {
            $("#songPracticeId").val(id);
            $("#songId").val(songId);  
            $("#styleId").val(styleId); 
            $("#lockGoldCoin").val(lockGoldCoin);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            var yes = window.confirm("确定要删除么？");
            if (!yes) {
                return;
            }
            var url = "/admin/meta/song/practice/delete?id=" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongPracties.refresh();
            }, "json")
        },
        save: function () {
            var _lockGoldCoin = $.trim($("#lockGoldCoin").val());
            var _styleId = $("#styleId").val();
            var _songId = $("#songId").val();
            if (!_lockGoldCoin) {
                alert("解锁金币不能为空")
                return;
            }
            
            var id = $("#songPracticeId").val();
            var url = !!id ? "/admin/meta/song/practice/update?id=" + id : "/admin/meta/song/practice/add";
            $.get(url, {styleId: _styleId, lockGoldCoin:_lockGoldCoin, songId:_songId}, function (data) {
                $("#formModal").modal("hide");
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongPracties.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m4").click();
            $(".modal-backdrop").remove();
        }
    };
}();