var RaceSeasonSongSelectManager = function () {
    return {
        Search: {
            search: function () {
                var data = $("#searchForm").serialize();
                RaceSeasonSongSelectManager.Step2.load(data);
            }
        },
        Pagination: {
            goto: function (pageNo) {
                $("#pageNo").val(pageNo);
                var data = $("#pageForm").serialize();
                RaceSeasonSongSelectManager.Step2.load(data);
            }
        },
        Step1: {
            init: function () {
                $("#subLevelForm").validate({
                    rules: {
                        levelId: {
                            required: true
                        }
                    },
                    messages: {
                        levelId: {
                            required: "请选择歌曲段位"
                        }
                    },
                    invalidHandler: function (event, validator) {
                        var form = $('#subLevelForm');
                        $('.alert-danger', form).hide();
                        $('.alert-success', form).show();
                    },
                    submitHandler: function (form) {
                        RaceSeasonSongSelectManager.Step2.init();
                    }
                });
            }
        },
        Step2: {
            init: function () {
                $("#subLevelRow").hide();
                $("#listRow").show();
                var form = $("#subLevelForm");
                var levelId = $("#levelId", form).val();
                levelId = levelId.split('-')[0];
                var seasonId = $("#seasonId", form).val();
                RaceSeasonSongSelectManager.Step2.load({levelId: levelId, seasonId: seasonId});
            },
            load: function (data) {
                $.get("/admin/meta/race/season/song/select", data, function (text) {
                    $("#listRow").html(text);
                });
            }
        },
        Action: {
            Add: {
                submit: function () {
                    var idArr = [];
                    var idSelect = $(".id-select");
                    idSelect.each(function () {
                        if ($(this).parent().hasClass("checked")) {
                            idArr.push($(this).val());
                        }
                    });
                    if (idArr.length <= 0) {
                        alert("请选择歌曲");
                        return;
                    }
                    var songIdList = idArr.join(',');
                    var form = $("#subLevelForm");
                    var levelId = $("#levelId", form).val();
                    var subLevelId = levelId.split('-')[1];
                    levelId = levelId.split('-')[1];
                    var seasonId = $("#seasonId", form).val();
                    var params = {
                        songIdList: songIdList,
                        seasonId: seasonId,
                        subLevelId: subLevelId
                    };
                    $.get("/admin/meta/race/season/song/add", params, function (data) {
                        if (data.code == 200) {
                            Notific8.success("添加歌曲成功");
                            RaceSeasonSongSelectManager.Initializer.refresh();
                            return;
                        }
                        Notific8.error(data.msg);
                    }, "json")
                }
            },
        },
        Initializer: {
            refresh: function () {
                var form = $("#subLevelForm");
                var seasonId = $("#seasonId", form).val();
                Index.load("/admin/meta/race/season/song/list?seasonId=" + seasonId)
            },
            init: function () {
                RaceSeasonSongSelectManager.Step1.init();
            }
        }
    };
}();