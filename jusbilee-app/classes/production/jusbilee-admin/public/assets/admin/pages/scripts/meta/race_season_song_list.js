var RaceSeasonSongManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                Index.load("/admin/meta/race/season/song/list", data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                Index.load("/admin/meta/race/season/song/list", data);
            }
        },
        Action: {
            Remove: {
                submit: function (id) {
                    bootbox.confirm("确定要删除么？", function (sure) {
                        if (!sure) return;
                        $.get("/admin/meta/race/season/song/delete?seasonSongId=" + id, {}, function (data) {
                            if (data.code == 200) {
                                Notific8.success("删除成功");
                                RaceSeasonSongManager.Initializer.refresh();
                                return;
                            }
                            Notific8.error(data.msg);
                        }, "json")
                    });
                }
            },
            Add: {
                show: function (seasonId) {
                    Index.load("/admin/meta/race/season/song/select/page", {seasonId: seasonId});
                }
            }
        },
        Initializer: {
            refresh: function () {
                var pageNo = $("#pageNo").val();
                RaceSeasonSongManager.Pagination.goto(pageNo)
            },
            init: function () {
            }
        }
    };
}();