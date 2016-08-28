<div class="page-content" style="min-height:800px">
    <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">Modal</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <input type="hidden" id="songPracticeId" value=""/>
                        <div class="form-group">
                            <label class="col-md-3 control-label">歌曲名称</label>
                            <div class="col-md-9">
                                <div class="input-icon right">
                                    <i class="fa fa-info-circle tooltips" data-original-title="Email address" data-container="body"></i>
                                    <select class="form-control" id="songId">
    									<#list songs as l>
										    <option value="${l.id}">
										       ${l.name}
										    </option>
										</#list>  
									</select>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label class="col-md-3 control-label">难易程度</label>
                            <div class="col-md-9">
                                <div class="input-icon right">
                                    <i class="fa fa-info-circle tooltips" data-original-title="Email address" data-container="body"></i>
                                    <select class="form-control" id="levelId">
    									<#list levels as l>
										    <option value="${l.id}">
										       ${l.name}
										    </option>
										</#list>  
									</select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-md-3 control-label">通关所需分数</label>
                            <div class="col-md-9">
                                <div class="input-icon right">
                                    <i class="fa fa-info-circle tooltips" data-original-title="Email address" data-container="body"></i>
                                    <input type="text" class="form-control" id="passScore"  placeholder="解锁需要金币" name="passScore">
                                </div>
                            </div>
                        </div>
                        
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn blue" onclick="SongStage.save()">提交</button>
                    <button type="button" class="btn default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
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
                <a href="#">闯关库管理</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>闯关库管理
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <button id="serchBtn" class="btn blue" style=" right: 10px;"  onclick="SongStage.add()">
                                      	  查询
                                    </button>
                                    <button id="addBtn" class="btn green" onclick="SongStage.add()">
                                      	  添加 <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-scrollable">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>歌曲名称</th>
                                <th>难易程度名称</th>
                                <th>过关所需分数</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list criteria.rows as l>
                            <tr>
                                <td>${l.songName}</td>
                                <td>${l.stageName}</td>
                                <td>${l.passScore}</td>
                                <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                <td>
                                    <a href="javascript:SongStage.edit('${l.id}','${l.songId}','${l.stageLevelId}','${l.passScore}')">编辑<i class="fa fa-edit"></i></a> |
                                    <a href="javascript:SongStage.remove('${l.id}')">删除<i class="fa fa-trash"></i></a>
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
<script src="assets/admin/pages/scripts/meta/song_stage_list.js" type="text/javascript"></script>