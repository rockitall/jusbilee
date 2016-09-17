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
                <a href="#">歌曲段位管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>歌曲段位管理
                    </div>
                    <div class="actions">
                        <a href="javascript:SongSubLevelManager.Action.Add.show()" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 添加歌曲段位 </a>
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="levelId" value="${(c.levelId)!''}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">难易级别</label>
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
                                <div class="col-md-1">
                                    <button class="btn blue" type="button" onclick="SongSubLevelManager.Search.search()">搜索<i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>段位名称</th>
                                    <th>难易级别</th>
                                    <th>分值</th>
                                    <th>创建时间</th>
                                    <th>最后更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#if sublevels?? && (sublevels?size gt 0)>
                                <#list sublevels as l>
                                <tr>
                                    <td>${l.subLevelName}</td>
                                    <td>${l.levelName}</td>
                                    <td>${l.score}</td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"><span class="caret"></span> 操作</a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="javascript:SongSubLevelManager.Action.Update.show('${l.id}')"><i class="fa fa-edit"></i>编辑</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:SongSubLevelManager.Action.Remove.submit('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                            <#else >
                            <tr><td colspan="5" style="color:red;text-align: center">未找到相关数据</td></tr>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                <#import "../inc/functions.ftl" as my>
                <@my.page p "SongSubLevelManager.Pagination.goto" />
                </div>
                <div class="portlet-body form" id="editor" style="display: none">
                    <form class="form-horizontal" action="" id="editorForm" method="post">
                        <div class="form-body">
                            <h3 class="form-section">编辑</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">难易级别</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="levelId" name="levelId">
                                        <option value="">--请选择难易级别--</option>
                                    <#list levels as l>
                                        <option value="${l.id}">${l.name}</option>
                                    </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">段位名称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="subLevelName" name="subLevelName" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">分值</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="score" name="score">
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="levelId" id="levelId" />
                                    <input type="hidden" name="subLevelId" id="subLevelId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="SongSubLevelManager.Editor.hide()">取消</button>
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
<script src="assets/admin/pages/scripts/meta/song_sub_level_list.js" type="text/javascript"></script>
<script type="text/javascript">
    var from =$("#searchForm")
    <#if (c.levelId)??>$("#levelId", from).val("${c.levelId?string}")</#if>
    SongSubLevelManager.Initializer.init();
</script>
