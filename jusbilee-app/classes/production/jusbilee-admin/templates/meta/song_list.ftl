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
                    <div class="actions">
                        <a href="javascript:SongManager.Add.show()" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 添加歌曲 </a>
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="name" value="${(c.name)!''}"/>
                            <input type="hidden" name="levelId" value="${(c.levelId)!''}"/>
                            <input type="hidden" name="styleId" value="${(c.styleId)!''}"/>
                            <input type="hidden" name="stageModel" value="<#if c.stageModel??>${c.stageModel?string}</#if>"/>
                            <input type="hidden" name="practiceModel" value="<#if c.practiceModel??>${c.practiceModel?string}</#if>"/>
                            <input type="hidden" name="startTime" value="${(c.startTime)!''}"/>
                            <input type="hidden" name="endTime" value="${(p.endTime)!''}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">难易级别</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="levelId" name="levelId">
                                                <option value="">---全部---</option>
                                            <#list levels as l>
                                                <option value="${l.id}">${l.name}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">歌曲风格</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="styleId" name="styleId">
                                                <option value="">---全部---</option>
                                            <#list styles as l>
                                                <option value="${l.id}">${l.name}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">闯关模式</label>
                                        <div class="col-md-8">
                                            <select type="text" class="form-control" id="stageModel" placeholder="歌曲名称" name="stageModel">
                                                <option value="">---全部---</option>
                                                <option value="true">已设置</option>
                                                <option value="false">未设置</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">练习模式</label>
                                        <div class="col-md-8">
                                            <select type="text" class="form-control" id="practiceModel" placeholder="歌曲名称" name="practiceModel">
                                                <option value="">---全部---</option>
                                                <option value="true">已设置</option>
                                                <option value="false">未设置</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">歌曲名称</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name" value="${(c.name)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">创建时间</label>
                                        <div class="col-md-4">
                                            <div class="input-group date date-picker" data-date-format="yyyy/mm/dd" data-date-start-date="-10y" data-date-end-date="+0d">
                                                <input type="text" class="form-control" readonly="" id="startTime" name="startTime" value="${(c.startTime)!''}">
                                                <span class="input-group-btn">
                                                    <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="input-group date date-picker" data-date-format="yyyy/mm/dd" data-date-end-date="+1d">
                                                <input type="text" class="form-control" readonly="" id="endTime" name="endTime" value="${(c.endTime)!''}">
                                            <span class="input-group-btn">
                                                <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                            </span>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <button class="btn blue" type="button" onclick="SongManager.Search.search()">搜索<i class="fa fa-search"></i></button>
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
                                <th>ID</th>
                                <th>歌曲名称</th>
                                <th>难易级别</th>
                                <th>风格</th>
                                <th>图标</th>
                                <th>乐谱图</th>
                                <th>音乐文件</th>
                                <th>设置闯关</th>
                                <th>设置练习</th>
                                <th>创建时间</th>
                                <th>最后更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#if songs?? && (songs?size gt 0)>
                                    <#list songs as l>
                                <tr>
                                    <td>${l.id}</td>
                                    <td>${l.name}</td>
                                    <td>${l.levelName}</td>
                                    <td>${l.styleName}</td>
                                    <td>
                                        <img src="${l.iconUrl}" kesrc="${l.iconUrl}" style="width: 50px;height: 50px;">
                                    </td>
                                    <td>
                                        <#if l.screenshotUrl=="" && l.opernUrl=="">
                                            无
                                        <#else>
                                            <div class="dropdown">
                                                <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"> 乐谱图<span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <#if l.opernUrl!="">
                                                        <li><a href="javascript:download('${l.opernUrl}')">乐谱图下载<i class="fa fa-download"></i></a></li>
                                                    <#else>
                                                        <li>（无）</li>
                                                    </#if>
                                                    <#if l.screenshotUrl!="">
                                                        <li><a href="javascript:download('${l.screenshotUrl}')">乐谱截图下载<i class="fa fa-download"></i></a></li>
                                                    <#else>
                                                        <li>（无）</li>
                                                    </#if>
                                                    <#if l.screenshotUrl!="" && l.opernUrl!="">
                                                        <li class="divider"></li>
                                                        <li><a href="javascript:alert('暂未实现，敬请期待'))">乐谱图对比<i class="fa fa-bookmark"></i></a></li>
                                                    </#if>
                                                </ul>
                                            </div>
                                        </#if>
                                    </td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle"aria-expanded="false"> 音乐文件<span class="caret"></span></a>
                                            <ul class="dropdown-menu dropdown-menu-default">
                                                <li>
                                                    <a href="${l.wavUrl}">WAV文件<i class="fa fa-download" style="margin-left:4px;"></i></a>
                                                </li>
                                                <li>
                                                    <a href="${l.midiUrl}">MIDI文件<i class="fa fa-download" style="margin-left:4px;"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                    <td>
                                        <#if !l.stageSongId??>
                                             <a href="javascript:SongManager.Stage.edit('${l.id}', '${l.name}')">未设置<i class="fa fa-gear" style="margin-left: 4px"></i></a>
                                        <#else>
                                            <a href="javascript:SongManager.Stage.edit('${l.id}', '${l.name}', '${l.stageSongId}')"><span style="color:red">已设置<i class="fa fa-edit" style="margin-left: 4px"></i></span></a>
                                        </#if>
                                    </td>
                                    <td>
                                        <#if !l.practiceSongId??>
                                            <a href="javascript:SongManager.Practice.edit('${l.id}', '${l.name}')">未设置<i class="fa fa-gear" style="margin-left: 4px"></i></a>
                                        <#else>
                                            <a href="javascript:SongManager.Practice.edit('${l.id}', '${l.name}', '${l.practiceSongId}')"><span style="color:red">已设置<i class="fa fa-edit" style="margin-left: 4px"></i></span></a>
                                        </#if>
                                    </td>
                                    <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"> 操作<span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="javascript:SongManager.Edit.edit('${l.id}')"><i class="fa fa-edit"></i>编辑</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:SongManager.Removal.remove('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                                <#else >
                                    <tr><td colspan="13" style="color:red;text-align: center">未找到相关数据</td></tr>
                                </#if>
                            </tbody>
                        </table>
                    </div>
                    <#import "../inc/functions.ftl" as my>
                    <@my.page p "SongManager.Pagination.goto" />
                </div>
                <div class="portlet-body form" id="addRow" style="display: none" >
                    <form class="form-horizontal" action="" id="addForm" method="post" enctype="multipart/form-data">
                        <div class="form-body">
                            <h3 class="form-section">添加歌曲</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲名称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">难易级别</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="levelId" name="levelId">
                                        <option value="">-请选择难易级别-</option>
                                    <#list levels as l>
                                        <option value="${l.id}">${l.name}</option>
                                    </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲风格</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="styleId" name="styleId">
                                        <option value="">-请选择歌曲风格-</option>
                                    <#list styles as l>
                                        <option value="${l.id}">${l.name}</option>
                                    </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">小图标</label>
                                <div class="col-md-4">
                                    <input type="file" class="form-control" id="iconFile" name="iconFile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">乐谱截屏</label>
                                <div class="col-md-4">
                                    <input type="file" class="form-control" id="screenshotFile" name="screenshotFile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">乐谱图</label>
                                <div class="col-md-4">
                                    <input type="file" class="form-control" id="opernFile" name="opernFile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">wav文件</label>
                                <div class="col-md-4">
                                    <input type="file" class="form-control" id="wavFile" name="wavFile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">midi文件</label>
                                <div class="col-md-4">
                                    <input type="file"  class="form-control" id="midiFile" name="midiFile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">描述</label>
                                <div class="col-md-6">
                                    <textarea type="text" class="form-control" id="description" placeholder="描述" name="description" rows="6"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="SongManager.Add.hide()">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="portlet-body form" id="updateRow" style="display: none" >
                    <form class="form-horizontal" action="" id="updateForm" method="post" enctype="multipart/form-data">
                        <div class="form-body">
                            <h3 class="form-section">编辑歌曲</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲名称</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="name" placeholder="歌曲名称" name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">难易级别</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="levelId" name="levelId">
                                        <option value="">-请选择难易级别-</option>
                                    <#list levels as l>
                                        <option value="${l.id}">${l.name}</option>
                                    </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲风格</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="styleId" name="styleId">
                                        <option value="">-请选择歌曲风格-</option>
                                    <#list styles as l>
                                        <option value="${l.id}">${l.name}</option>
                                    </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">小图标</label>
                                <div class="col-md-6">
                                    <input type="file" class="form-control" id="iconFile" name="iconFile">
                                </div>
                                <div class="col-md-3"><img src="#" id="iconImg" style="width: 50px;height: 50px"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">乐谱截屏</label>
                                <div class="col-md-6">
                                    <input type="file" class="form-control" id="screenshotFile" name="screenshotFile">
                                </div>
                                <div class="col-md-3"><img src="#" id="ssImg" style="width: 50px;height: 50px"></div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">乐谱图</label>
                                <div class="col-md-6">
                                    <input type="file" class="form-control" id="opernFile" name="opernFile">
                                </div>
                                <div class="col-md-3"><img src="#" id="opernImg" style="width: 50px;height: 50px"></div>
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
                                <div class="col-md-6">
                                    <textarea type="text" class="form-control" id="description" placeholder="描述" name="description"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="songId" id="songId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="SongManager.Edit.hide()">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="portlet-body form" id="stageSongRow" style="display: none" >
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
                                    <button type="button" class="btn default" onclick="SongManager.Stage.hide()">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="portlet-body form" id="practiceSongRow" style="display: none" >
                    <form class="form-horizontal" action="" id="practiceSongForm" method="post">
                        <div class="form-body">
                            <h3 class="form-section">添加到练习库</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">歌曲名称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" disabled="" id="practiceSongName" name="practiceSongName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">是否上线</label>
                                <div class="col-md-4">
                                    <input type="checkbox" id="online" name="online" class="practice-song-online" value="true">
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
                                <label class="col-md-3 control-label">解锁所需金币数</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="unlockGoldCoin" name="unlockGoldCoin">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">是否可以闯关解锁</label>
                                <div class="col-md-4">
                                    <input type="checkbox" id="passStageUnlock" name="passStageUnlock" value="true">
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="songId" id="songId" />
                                    <input type="hidden" name="practiceSongId" id="practiceSongId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="SongManager.Practice.hide()">取消</button>
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
<script src="assets/admin/pages/scripts/meta/song_list.js" type="text/javascript"></script>
<script type="text/javascript">
    var searchForm=$("#searchForm");

    <#if (c.stageModel)??>$("#stageModel", searchForm).val("${c.stageModel?string}")</#if>
    <#if (c.practiceModel)??>$("#practiceModel", searchForm).val("${c.practiceModel?string}")</#if>
    <#if (c.levelId)??>$("#levelId", searchForm).val("${c.levelId}")</#if>
    <#if (c.styleId)??>$("#styleId", searchForm).val("${c.styleId}")</#if>
    SongManager.Initializer.init();
</script>
