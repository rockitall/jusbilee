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
                <a href="#">闯关歌曲管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>闯关歌曲管理
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="name" value="${(c.name)!''}"/>
                            <input type="hidden" name="passScoreStart" value="${(c.passScoreStart)!""}"/>
                            <input type="hidden" name="passScoreEnd" value="${(c.passScoreEnd)!""}"/>
                            <input type="hidden" name="levelId" value="${(c.levelId)!""}"/>
                            <input type="hidden" name="sortOrder" value="${(c.sortOrder)!""}"/>
                            <input type="hidden" name="online" value="<#if c.online??>${c.online?string}</#if>"/>
                            <input type="hidden" name="onlineStartTime" value="${(c.onlineStartTime)!''}"/>
                            <input type="hidden" name="onlineEndTime" value="${(p.onlineEndTime)!''}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">在线状态</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="online" name="online">
                                                <option value="">--全部--</option>
                                                <option value="true">在线</option>
                                                <option value="false">不在线</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">难易程度级别</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="levelId" name="levelId">
                                                <option value="">--全部--</option>
                                            <#list levels as l>
                                                <option value="${l.id}">${l.name}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">歌曲名称</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name" value="${(c.name)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">排序值</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="sortOrder" placeholder="排序值" name="sortOrder" value="${(c.sortOrder)!''}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">过关分数</label>
                                        <div class="col-md-4">
                                            <input type="text" class="form-control input-small" placeholder="最小值" id="passScoreStart" name="passScoreStart" value="${(c.passScoreStart)!''}">
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" class="form-control input-small" placeholder="最大值" id="passScoreEnd" name="passScoreEnd" value="${(c.passScoreEnd)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">在线时间区间</label>
                                        <div class="col-md-4">
                                            <div class="input-group date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="-10y" data-date-end-date="+10y">
                                                <input type="text" class="form-control" readonly="" id="onlineStartTime" name="onlineStartTime" value="${(c.onlineStartTime)!''}">
                                                <span class="input-group-btn">
                                                    <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="input-group date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="-10y" data-date-end-date="+10y">
                                                <input type="text" class="form-control" readonly="" id="onlineEndTime" name="onlineEndTime" value="${(c.onlineEndTime)!''}">
                                            <span class="input-group-btn">
                                                <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                            </span>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <button class="btn blue" type="button" onclick="StageSongManager.Search.search()">搜索<i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>歌曲名称</th>
                                    <th>排序</th>
                                    <th>难易程度</th>
                                    <th>是否上线</th>
                                    <th>上线时间区间</th>
                                    <th>过关分数</th>
                                    <th>创建时间</th>
                                    <th>最后更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#if songs?? && (songs?size gt 0)>
                                <#list songs as l>
                                <tr>
                                    <td>${l.name}</td>
                                    <td>${l.sortOrder}</td>
                                    <td>${l.levelName}</td>
                                    <td>${(l.status==0)?string("已上线","未上线")}</td>
                                    <td>
                                        <#if l.status==0 && l.startTime??>
                                            ${l.startTime?string("yyyy/MM/dd")} - ${l.endTime?string("yyyy/MM/dd")}
                                            <#if l.online ==-1>
                                                <span class="label label-default">已过期</span>
                                            <#elseif l.online==1>
                                                <span class="label bg-yellow">即将上线</span>
                                            <#else >
                                                <span class="label bg-blue">在线</span>
                                            </#if>
                                        </#if>
                                    </td>
                                    <td>${l.passScore}</td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"><span class="caret"></span> 操作</a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="javascript:StageSongManager.Action.Update.show('${l.id}','${l.name}')"><i class="fa fa-edit"></i>编辑</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:StageSongManager.Action.Remove.submit('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                            <#else >
                            <tr><td colspan="9" style="color:red;text-align: center">未找到相关数据</td></tr>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                <#import "../inc/functions.ftl" as my>
                <@my.page p "StageSongManager.Pagination.goto" />
                </div>
                <div class="portlet-body form" id="stageSongRow" style="display: none">
                    <form class="form-horizontal" action="" id="stageSongForm" method="post">
                        <div class="form-body">
                            <h3 class="form-section">添加到闯关库</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲名称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" disabled="" id="stageSongName" name="stageSongName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">是否上线</label>
                                <div class="col-md-4">
                                    <input type="checkbox" id="online" name="online" value="true" class="stage-song-online">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">上线开始时间</label>
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
                                <label class="col-md-3 control-label">上线结束时间</label>
                                <div class="col-md-4">
                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="+0d">
                                        <input type="text" class="form-control" readonly="" id="endTime" name="endTime">
                                        <span class="input-group-btn">
                                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">过关分数</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="passScore" name="passScore">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">排序</label>
                                <div class="col-md-4">
                                    <input type="tex" class="form-control" id="sortOrder" name="sortOrder">
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="songId" id="songId" />
                                    <input type="hidden" name="stageSongId" id="stageSongId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="StageSongManager.Editor.hide()">取消</button>
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
<script src="assets/global/plugins/icheck/icheck.min.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/meta/stage_song_list.js" type="text/javascript"></script>
<script type="text/javascript">
    <#if (c.online)??>$("#online").val("${c.online?string}")</#if>
    <#if (c.levelId)??>$("#levelId").val("${c.levelId?string}")</#if>
    StageSongManager.Initializer.init();
</script>
