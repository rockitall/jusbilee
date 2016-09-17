<link href="assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/icheck/skins/all.css" rel="stylesheet" type="text/css"/>

<div class="page-content" style="min-height:600px">
    <div class="page-bar">
        <ul class="page-breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a href="index.html">Home</a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="#">基础数据管理</a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="#">赛季歌曲管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>赛季歌曲管理
                    </div>
                    <div class="actions">
                        <a href="javascript:RaceSeasonSongManager.Action.Add.show('${c.seasonId}')" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 添加歌曲 </a>
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="songName" value="${(c.songName)!''}"/>                            <input type="hidden" name="name" value="${(c.name)!''}"/>
                            <input type="hidden" name="seasonId" value="${(c.seasonId)!''}"/>
                            <input type="hidden" name="levelId" value="${(c.levelId)!""}"/>
                            <input type="hidden" name="styleId" value="${(c.styleId)!''}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">歌曲名称</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="songName" placeholder="歌曲名称" name="songName" value="${(c.songName)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">难易级别</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="styleId" name="styleId">
                                                <option value="">--全部--</option>
                                            <#list levels as l>
                                                <option value="${l.id}">${l.name}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                    <button class="btn blue" type="button" onclick="RaceSeasonSongManager.Search.search()">搜索<i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>歌曲ID</th>
                                    <th>歌曲名称</th>
                                    <th>歌曲图标</th>
                                    <th>难易级别</th>
                                    <th>段位</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#if songs?? && (songs?size gt 0)>
                                <#list songs as l>
                                <tr>
                                    <td>${l.songId}</td>
                                    <td>${l.songName}</td>
                                    <td>
                                        <img src="${l.iconUrl}" kesrc="${l.iconUrl}" style="width: 50px;height: 50px;">
                                    </td>
                                    <td>${l.levelName}</td>
                                    <td>${l.subLevelName}</td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"><span class="caret"></span> 操作</a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="javascript:RaceSeasonSongManager.Action.Remove.submit('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                            <#else >
                            <tr><td colspan="6" style="color:red;text-align: center">未找到相关数据</td></tr>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                <#import "../inc/functions.ftl" as my>
                <@my.page p "RaceSeasonSongManager.Pagination.goto" />
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/icheck/icheck.min.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/meta/race_season_song_list.js" type="text/javascript"></script>
<script type="text/javascript">
    <#if (c.levelId)??>$("#levelId").val("${c.levelId?string}")</#if>
    RaceSeasonSongManager.Initializer.init();
</script>
