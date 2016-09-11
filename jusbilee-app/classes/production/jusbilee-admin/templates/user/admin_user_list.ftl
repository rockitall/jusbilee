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
                <a href="#">系统管理</a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="#">后台用户管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>后台用户管理
                    </div>
                    <div class="actions">
                        <a href="javascript:AdminUserManager.Action.Add.show()" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 添加用户</a>
                    </div>
                </div>
                <div class="portlet-body" id="listRow">
                    <div class="table-toolbar">
                        <form id="pageForm">
                            <input type="hidden" id="pageNo" name="pageNo" value="${p.pageNo}"/>
                            <input type="hidden" name="pageSize" value="${p.pageSize}"/>
                            <input type="hidden" name="username" value="${(c.username)!''}"/>
                            <input type="hidden" name="nickname" value="${(c.nickname)!""}"/>
                            <input type="hidden" name="isLocked" value="${(c.isLocked)!""}"/>
                        </form>
                        <form class="form-horizontal" id="searchForm">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">登录名</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="登录名" id="username" name="username" value="${(c.username)!''}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">用户昵称</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="用户昵称" id="nickname" name="nickname" value="${(c.nickname)!''}">
                                        </div>
                                    </div>
                                </div>
								<div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">状态</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="isLocked" name="isLocked">
                                                <option value="">--全部--</option>
                                                <option value="0">正常</option>
                                                <option value="1">已锁定</option>
                                            </select>
                                        </div>
									</div>
                                </div>
								<div class="col-md-2">
                                    <div class="form-group">
                                        <button class="btn blue" type="button" onclick="AdminUserManager.Search.search()">搜索<i class="fa fa-search"></i></button>
									</div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="table-scrollable" style="min-height: 500px">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>用户ID</th>
                                    <th>登录名</th>
                                    <th>用户昵称</th>
                                    <th>手机号码</th>
                                    <th>邮箱</th>
                                    <th>用户类型</th>
                                    <th>状态</th>
                                    <th>创建时间</th>
                                    <th>最后更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#if users?size gt 0>
                                    <#list users as l>
                                        <tr>
                                            <td>${l.id}</td>
                                            <td>${l.username}</td>
                                            <td>${l.nickname}</td>
                                            <td>${l.mobile}</td>
                                            <td>${l.email}</td>
                                            <td>${(l.isAdmin==1)?string("管理员","普通用户")}</td>
                                            <td>${(l.isLocked==0)?string("正常","已锁定")}</td>
                                            <td>${l.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                            <td>${l.updateTime?string("yyyy-MM-dd HH:mm")}</td>
                                            <td>
                                                <#if me?? && (me.id!=l.id)>
                                                <div class="dropdown">
                                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="false"> 操作<span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li>
                                                            <a href="javascript:AdminUserManager.Action.Update.show('${l.id}')"><i class="fa fa-edit"></i>编辑</a>
                                                        </li>
                                                        <li>
                                                            <#if (l.isLocked==1)>
                                                                <a href="javascript:AdminUserManager.Action.Unlock.submit('${l.id}')"><i class="fa fa-unlock"></i>解锁</a>
                                                            <#else>
                                                                <a href="javascript:AdminUserManager.Action.Lock.submit('${l.id}')"><i class="fa fa-lock"></i>锁定</a>
                                                            </#if>
                                                        </li>
                                                        <li>
                                                            <a href="javascript:AdminUserManager.Action.Remove.submit('${l.id}')"><i class="fa fa-trash"></i>删除</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <#else>
                                                    <span style="color:red">当前登录用户</span>
                                                </#if>
                                            </td>
                                        </tr>
                                    </#list>
                                <#else>
                                    <tr><td colspan="9" style="color:red;text-align: center">未找到相关数据</td></tr>
                                </#if>
                            </tbody>
                        </table>
                    </div>
                <#import "../inc/functions.ftl" as my>
                <@my.page p "AdminUserManager.Pagination.goto" />
                </div>
                <div class="portlet-body form" id="adminUserEditor" style="display: none">
                    <form class="form-horizontal" action="" id="adminUserForm" method="post">
                        <div class="form-body">
                            <h3 class="form-section">用户编辑</h3>
                            <div class="form-group">
                                <label class="col-md-3 control-label">登录名</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="username" name="username" maxlength="32">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">用户昵称</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="nickname" name="nickname" maxlength="16">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">登录密码</label>
                                <div class="col-md-4">
                                    <input type="password" class="form-control pwd" id="password" name="password" maxlength="16">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">确认密码</label>
                                <div class="col-md-4">
                                    <input type="password" class="form-control" id="c_password" name="c_password" maxlength="16">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">手机号码</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="mobile" name="mobile" maxlength="64">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">邮箱地址</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="email" name="email" maxlength="64">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">是否管理员</label>
                                <div class="col-md-4">
                                    <input type="checkbox" id="isAdmin" name="isAdmin" value="1">
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-9">
                                    <input type="hidden" name="userId" id="userId" />
                                    <button type="submit" class="btn blue">提交</button>
                                    <button type="button" class="btn default" onclick="AdminUserManager.Editor.hide()">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/global/plugins/icheck/icheck.min.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/user/admin_user_list.js" type="text/javascript"></script>
<script type="text/javascript">
	AdminUserManager.Initializer.init();
    var searchForm = $("#searchForm")
    <#if (c.isLocked)??>$("#isLocked", searchForm).val("${c.isLocked}")</#if>
</script>
