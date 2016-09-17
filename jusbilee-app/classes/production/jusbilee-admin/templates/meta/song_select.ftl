<form>
    <div class="form-body">
    <h3 class="form-section">Step 2:选择歌曲</h3>
    <div class="table-toolbar">
    <form id="pageForm">
        <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
        <input type="hidden" name="pageSize" value="${p.pageSize}"/>
        <input type="hidden" name="songName" value="${(c.songName)!''}"/>
        <input type="hidden" name="seasonId" value="${(c.seasonId)!''}"/>
        <input type="hidden" name="levelId" value="${(c.levelId)!''}"/>
        <input type="hidden" name="startTimeBegin" value="${(c.startTimeBegin)!""}"/>
        <input type="hidden" name="startTimeEnd" value="${(c.startTimeEnd)!''}"/>
    </form>
    <form class="form-horizontal" id="searchForm">
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label class="col-md-4 control-label">歌曲名称</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" id="songName" placeholder="歌曲名称" name="songName"
                               value="${(c.songName)!''}">
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label class="col-md-2 control-label">创建时间</label>
                    <div class="col-md-4">
                        <div class="input-group date date-picker" data-date-format="yyyy/mm/dd"
                             data-date-start-date="-10y" data-date-end-date="+0d">
                            <input type="text" class="form-control" readonly="" id="startTimeBegin" name="startTimeBegin" value="${(c.startTimeBegin)!''}">
                            <span class="input-group-btn">
                                <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group date date-picker" data-date-format="yyyy/mm/dd"
                             data-date-end-date="+1d">
                            <input type="text" class="form-control" readonly="" id="startTimeEnd" name="startTimeEnd"
                                   value="${(c.startTimeEnd)!''}">
                            <span class="input-group-btn">
                                                <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                            </span>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <button class="btn blue" type="button" onclick="RaceSeasonSongSelectManager.Search.search()">搜索<i class="fa fa-search"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
    <div class="table-scrollable" style="min-height: 500px" id="selectSong">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>歌曲ID</th>
            <th>歌曲名称</th>
            <th>歌曲图标</th>
            <th>歌曲风格</th>
            <th>难易级别</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th><input type="checkbox" id="all"/>全选</th>
        </tr>
        </thead>
        <tbody>
        <#if songs?? && (songs?size gt 0)>
            <#list songs as l>
            <tr>
                <td>${l.id}</td>
                <td>${l.songName}</td>
                <td>
                    <img src="${l.iconUrl}" style="width: 50px;height: 50px;">
                </td>
                <td>${l.styleName}</td>
                <td>${l.levelName}</td>
                <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                <td><input type="checkbox" value="${l.id}" class="id-select"/></td>
            </tr>
            </#list>
        <#else >
        <tr>
            <td colspan="6" style="color:red;text-align: center">未找到相关数据</td>
        </tr>
        </#if>
        </tbody>
    </table>
</div>
    <#import "../inc/functions.ftl" as my>
    <@my.page p "RaceSeasonSongSelectManager.Pagination.goto"></@my.page>

    <div class="form-actions">
        <div class="row">
            <div class="col-md-offset-3 col-md-9">
                <button type="button" class="btn blue" onclick="RaceSeasonSongSelectManager.Action.Add.submit()">提交</button>
            </div>
        </div>
    </div>
</div>
</form>
<script>
    $('.date-picker').datepicker({
        rtl: Metronic.isRTL(),
        orientation: "left",
        autoclose: true
    });
    $(':checkbox').iCheck({
        checkboxClass: 'icheckbox_flat-blue',
        radioClass: 'iradio_flat-blue'
    });

    $("#all").on("ifChecked", function () {
            $("#selectSong").find(":checkbox").iCheck("check");
    }).on("ifUnchecked", function () {
        $("#selectSong").find(":checkbox").iCheck("uncheck");
    });
</script>
