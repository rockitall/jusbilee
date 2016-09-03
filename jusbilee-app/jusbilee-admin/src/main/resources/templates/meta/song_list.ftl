<div class="page-content" style="min-height:800px">
    <form class="form-horizontal" action="" id="addForm" method="post" enctype="multipart/form-data">
        <div class="modal fade" id="addFormModal" tabindex="-1" role="dialog" aria-labelledby="addFormLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">添加歌曲</h4>
                </div>
                <div class="modal-body">
                        <input type="hidden" id="songId" value=""/>
                        <div class="form-group">
                            <label class="col-md-3 control-label">歌曲名称</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">小图标</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="iconFile" name="iconFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">乐谱截屏</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="screenshotFile" name="screenshotFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">乐谱图</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="opernFile" name="opernFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">wav文件</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="wavFile" name="wavFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">midi文件</label>
                            <div class="col-md-9">
                                <input type="file"  class="form-control" id="midiFile" name="midiFile">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">描述</label>
                            <div class="col-md-9">
                                <textarea type="text" class="form-control" id="description" placeholder="描述" name="description"></textarea>
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

    <form class="form-horizontal" action="" id="updateForm" method="post" enctype="multipart/form-data">
        <div class="modal fade" id="updateFormModal" tabindex="-1" role="dialog" aria-labelledby="addFormLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        <h4 class="modal-title">编辑歌曲</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="songId" value=""/>
                        <div class="form-group">
                            <label class="col-md-3 control-label">歌曲名称</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">小图标</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="iconFile" name="iconFile">
                            </div>
                            <div class="col-md-12"><img src="#" id="iconImg"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">乐谱截屏</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="screenshotFile" name="screenshotFile">
                            </div>
                            <div class="col-md-12"><img src="#" id="ssImg"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">乐谱图</label>
                            <div class="col-md-9">
                                <input type="file" class="form-control" id="opernUrl" name="opernUrl">
                            </div>
                            <div class="col-md-12"><img src="#" id="opernImg"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">wav文件</label>
                            <div class="col-md-6">
                                <input type="file" class="form-control" id="wavFile" name="wavFile">
                            </div>
                            <div class="col-md-3">
                               <a href="" id="wavDwUrl">WAV文件下载</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">midi文件</label>
                            <div class="col-md-6">
                                <input type="file"  class="form-control" id="midiFile" name="midiFile">
                            </div>
                            <div class="col-md-3">
                                <a href="" id="midiDwUrl">MIDI文件下载</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">描述</label>
                            <div class="col-md-9">
                                <textarea type="text" class="form-control" id="description" placeholder="描述" name="description"></textarea>
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
                <a href="#">歌曲管理</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>歌曲管理
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <button id="addBtn" class="btn green"  data-toggle="modal" data-target="#addFormModal">添加 <i class="fa fa-plus"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-scrollable">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>歌曲名称</th>
                                <th>图标</th>
                                <th>乐谱截图</th>
                                <th>曲谱图</th>
                                <th>音乐文件</th>
                                <th>设置闯关</th>
                                <th>设置练习</th>
                                <th>创建时间</th>
                                <th>最后更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list songs as l>
                                <tr>
                                    <td>${l.id}</td>
                                    <td>${l.name}</td>
                                    <td><img src="${l.iconUrl}" style="width: 50px;height: 50px;"></td>
                                    <td><img src="${l.opernScreenshotUrl}" style="width: 50px;height: 50px;"></td>
                                    <td><img src="${l.opernUrl}" style="width: 50px;height: 50px;"></td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle"aria-expanded="false"><span class="caret"></span> 音乐文件</a>
                                            <ul class="dropdown-menu">
                                                <li role="presentation" class="context-menu-item">
                                                    <a href="${l.wavUrl}"><i class="fa fa-eye-wav fa-fw"></i>WAV文件下载</a>
                                                </li>
                                                <li role="presentation" class="context-menu-item">
                                                    <a href="${l.midiUrl}"><i class="fa fa-eye-wav fa-fw"></i>MIDI文件下载</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>${l.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>
                                        <a href="javascript:SongLib.edit('${l.id}')">编辑<i class="fa fa-edit"></i></a> |
                                        <a href="javascript:SongLib.remove('${l.id}')">删除<i class="fa fa-trash"></i></a>
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
<script src="assets/admin/pages/scripts/meta/song_list.js" type="text/javascript"></script>