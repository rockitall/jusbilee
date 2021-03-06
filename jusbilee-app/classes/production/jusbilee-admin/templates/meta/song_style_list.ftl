<div class="page-content" style="min-height:800px">
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
                        <div class="form-group">
                            <label class="col-md-3 control-label">歌曲风格名称</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="name"  placeholder="歌曲风格名称" name="name" maxlength="16">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">排序序号</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="sortOrder"  placeholder="排序序号" name="sortOrder" maxlength="5">
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="styleId" value=""/>
                    <button type="submit" class="btn blue">提交</button>
                    <button type="button" class="btn default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    </form>
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
                <a href="#">歌曲风格管理</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>歌曲风格管理
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <button id="addBtn" class="btn green" onclick="SongStyle.add()">
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
                                <th>歌曲风格名称</th>
                                <th>排序</th>
                                <th>创建时间</th>
                                <th>最后更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list styles as l>
                            <tr>
                                <td>${l_index+1}</td>
                                <td>${l.name}</td>
                                <td>${l.sortOrder}</td>
                                <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                <td>
                                    <div class="dropdown">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"> 操作<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="javascript:SongStyle.edit('${l.id}','${l.name}', '${l.sortOrder}')"><i class="fa fa-edit"></i>编辑</a>
                                            </li>
                                            <li>
                                                <a href="javascript:SongStyle.remove('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                            </li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/admin/pages/scripts/meta/song_style_list.js" type="text/javascript"></script>