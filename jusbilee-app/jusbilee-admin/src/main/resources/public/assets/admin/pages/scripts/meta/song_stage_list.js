var SongStage = function () {
    return {
        add: function () {
            $("#songPracticeId").val("");
            $("#passScore").val("");
            $("#formModal .modal-title").text("添加");
            $("#formModal").modal();
        },
        edit: function (id, songId, stageLevelId, passScore) {
            $("#songPracticeId").val(id);
            $("#songId").val(songId);  
            $("#levelId").val(stageLevelId); 
            $("#passScore").val(passScore);
            $("#formModal .modal-title").text("编辑");
            $("#formModal").modal();
        },
        remove: function (id) {
            var yes = window.confirm("确定要删除么？");
            if (!yes) {
                return;
            }
            var url = "/admin/meta/song/stage/delete?id=" + id;
            $.get(url, {}, function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongStage.refresh();
            }, "json")
        },
        save: function () {
            var _passScore = $.trim($("#passScore").val());
            var _levelId = $("#levelId").val();
            var _songId = $("#songId").val();
            if (!_passScore) {
                alert("闯关所需分数不能为空")
                return;
            }
            
            var id = $("#songPracticeId").val();
            var url = !!id ? "/admin/meta/song/stage/update?id=" + id : "/admin/meta/song/stage/add";
            $.get(url, {stageLevelId: _levelId, passScore:_passScore, songId:_songId}, function (data) {
                $("#formModal").modal("hide");
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                SongStage.refresh();
            }, "json")
        },
        refresh: function () {
            $("#basic_data_m5").click();
            $(".modal-backdrop").remove();
        }
    };
}();