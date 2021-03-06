<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>Jusbilee Admin System</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
          type="text/css"/>
    <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/jquery-notific8/jquery.notific8.min.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- END PAGE LEVEL PLUGIN STYLES -->
    <!-- END PAGE STYLES -->
    <!-- BEGIN THEME STYLES -->
    <link href="assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
    <link href="assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner">
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
           data-target=".navbar-collapse">
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <!-- BEGIN USER LOGIN DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <img alt="" class="img-circle" src="assets/admin/layout/img/avatar3_small.jpg"/>
                        <span class="username username-hide-on-mobile">
					Nick </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="extra_profile.html">
                                <i class="icon-user"></i> My Profile </a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="javascript:UserProfile.Password.show()">
                                <i class="icon-lock"></i>修改密码 </a>
                        </li>
                        <li>
                            <a href="/admin/logout">
                                <i class="icon-key"></i>注销</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown dropdown-quick-sidebar-toggler">
                    <a href="javascript:;" class="dropdown-toggle">
                        <i class="icon-logout"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <div class="page-sidebar navbar-collapse collapse">
            <ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                <li class="sidebar-toggler-wrapper">
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler">
                    </div>
                    <!-- END SIDEBAR TOGGLER BUTTON -->
                </li>
                <li class="start active open">
                    <a href="javascript:;">
                    <i class="fa fa-database"></i>
                    <span class="title">歌曲管理</span>
                    <span class="arrow "></span>
                </a>
                    <ul class="sub-menu">
                    <li>
                        <a href="javascript:;" onclick="Index.menuLink('/admin/meta/song/list')"><i class="fa fa-music"></i> 歌曲管理</a>
                        <a href="javascript:;" onclick="Index.menuLink('/admin/meta/song/style/list')"><i class="fa fa-tree"></i> 歌曲风格管理</a>
                        <a href="javascript:;" onclick="Index.menuLink('/admin/meta/song/level/list')"><i class="fa fa-space-shuttle"></i> 歌曲难易级别管理</a>
                    </li>
                </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="fa fa-database"></i>
                        <span class="title">闯关歌曲管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="javascript:;" onclick="Index.menuLink('/admin/meta/stage/song/list')"><i class="fa fa-music"></i> 闯关歌曲管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="fa fa-database"></i>
                        <span class="title">练习歌曲管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="javascript:;" onclick="Index.menuLink('/admin/meta/practice/song/list')"><i class="fa fa-music"></i> 练习歌曲管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="fa fa-database"></i>
                        <span class="title">排位赛管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="javascript:;" onclick="Index.menuLink('/admin/meta/race/season/list')"><i class="fa fa-space-shuttle"></i> 排位赛赛季管理</a>
                            <a href="javascript:;" onclick="Index.menuLink('/admin/meta/song/sublevel/list')"><i class="fa fa-space-shuttle"></i> 歌曲段位管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="fa fa-users"></i>
                        <span class="title">后台用户管理</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="javascript:;" onclick="Index.menuLink('/admin/user/list')"><i
                                    class="fa fa-user"></i> 用户管理</a>
                        </li>
                    </ul>
                </li>
                <li class="last">
                    <a href="javascript:;">
                        <i class="fa fa-gears"></i>
                        <span class="title">系统设置</span>
                        <span class="arrow "></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="#">公共配置</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN PAGE HEADER-->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="index.html">Home</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                </ul>
            </div>
            <h3 class="page-title">
                Dashboard
                <small>reports & statistics</small>
            </h3>
            <div class="row">
                <div class="col-md-6 col-sm-6">
                </div>
                <div class="col-md-6 col-sm-6">
                </div>
            </div>
        </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <div class="page-footer-inner">
        2014 &copy; Jusbilee by allen.
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<form class="form-horizontal" id="passwordModifyForm">
    <div class="modal fade" id="passwordModifyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">原密码</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control" id="oldUserPassword"  placeholder="原密码" name="oldUserPassword" maxlength="16">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">新密码</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control" id="userPassword"  placeholder="新密码" name="userPassword" maxlength="16">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">确认密码</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control" id="c_userPassword"  placeholder="确认密码" name="c_userPassword" maxlength="16">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交更改</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="assets/global/plugins/respond.min.js"></script>
<script src="assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-validation/js/jquery.validate.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-notific8/jquery.notific8.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/validator.defaults.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core componets
        Layout.init(); // init layout
        QuickSidebar.init(); // init quick sidebar
        AdminValidator.initDefaults();
        Index.init();
    });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>