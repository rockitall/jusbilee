
<div class="page-content" style="min-height:800px">
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
                <a href="#">歌曲难易级别管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>歌曲难易级别管理
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <button id="addBtn" class="btn green" onclick="SongLevel.add()">
                                        添加 <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>歌曲级别名称</th>
                                <th>难易程度权重</th>
                                <th>创建时间</th>
                                <th>最后更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#if levels?? && (levels?size gt 0)>
                                    <#list levels as l>
                                    <tr>
                                        <td>${l_index+1}</td>
                                        <td>${l.name}</td>
                                        <td>${l.weight}</td>
                                        <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                        <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                        <td>
                                            <div class="dropdown">
                                                <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"><span class="caret"></span> 操作</a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="javascript:SongLevel.edit('${l.id}','${l.name}', '${l.weight}')"><i class="fa fa-edit"></i>编辑</a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:SongLevel.remove('${l.id}')">删除<i class="fa fa-trash"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                    </#list>
                                <#else >
                                    <tr><td colspan="11" style="color:red;text-align: center">未找到相关数据</td></tr>
                                </#if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form class="form-horizontal" id="form">
        <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        <h4 class="modal-title">Modal</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="levelId" value=""/>
                        <div class="form-group">
                            <label class="col-md-3 control-label">歌曲级别名称</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="name"  placeholder="歌曲级别名称" name="name" maxlength="16">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">难易程度权重</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="weight"  placeholder="难易程度权重" name="weight" maxlength="5">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn blue">提交</button>
                        <button type="button" class="btn default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="assets/admin/pages/scripts/meta/song_level_list.js" type="text/javascript"></script>