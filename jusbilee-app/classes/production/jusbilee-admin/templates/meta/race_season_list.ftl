<link href="assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>

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
                <a href="#">排位赛赛季管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>排位赛赛季管理
                    </div>
                    <div class="actions">
                        <a href="javascript:RaceSeasonManager.Action.Add.show()" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 添加赛季 </a>
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="seasonName" value="${(c.seasonName)!''}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">赛季名称</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="seasonName" placeholder="赛季名称" name="seasonName" value="${(c.seasonName)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                    <button class="btn blue" type="button" onclick="RaceSeasonManager.Search.search()">搜索<i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>赛季名称</th>
                                    <th>赛季开始时间</th>
                                    <th>赛季结束时间</th>
                                    <th>歌曲数</th>
                                    <th>状态</th>
                                    <th>创建时间</th>
                                    <th>最后更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#if seasons?? && (seasons?size gt 0)>
                                <#list seasons as l>
                                <tr>
                                    <td>${l.seasonName}</td>
                                    <td>${l.startTime?string("yyyy-MM-dd")}</td>
                                    <td>${l.endTime?string("yyyy-MM-dd")}</td>
                                    <td>${l.songCount}</td>
                                    <td>
                                            <#if l.online ==-1>
                                                <span class="label label-default">过往赛季</span>
                                            <#elseif l.online==1>
                                                <span class="label bg-yellow">将来赛季</span>
                                            <#else >
                                                <span class="label bg-blue">当前赛季</span>
                                            </#if>
                                    </td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"><span class="caret"></span> 操作</a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="javascript:RaceSeasonManager.Action.Update.show('${l.id}')"><i class="fa fa-edit"></i>编辑</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:RaceSeasonManager.Action.Remove.submit('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:RaceSeasonManager.Action.Song.manage('${l.id}')"><i class="fa fa-trash"></i>歌曲管理</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                            <#else >
                            <tr><td colspan="7" style="color:red;text-align: center">未找到相关数据</td></tr>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                <#import "../inc/functions.ftl" as my>
                <@my.page p "RaceSeasonManager.Pagination.goto" />
                </div>
                <div class="portlet-body form" id="editor" style="display: none">
                    <form class="form-horizontal" action="" id="editorForm" method="post">
                        <div class="form-body">
                            <h3 class="form-section">编辑</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">赛季名称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="seasonName" name="seasonName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">赛季开始时间</label>
                                <div class="col-md-4">
                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="+0d">
                                        <input type="text" class="form-control" readonly="" id="startTime" name="startTime">
                                        <span class="input-group-btn">
                                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">赛季结束时间</label>
                                <div class="col-md-4">
                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="+0d">
                                        <input type="text" class="form-control" readonly="" id="endTime" name="endTime">
                                        <span class="input-group-btn">
                                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="seasonId" id="seasonId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="RaceSeasonManager.Editor.hide()">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/meta/race_season_list.js" type="text/javascript"></script>
<script type="text/javascript">
    RaceSeasonManager.Initializer.init();
</script>
