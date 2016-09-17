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
                <a href="#">赛季歌曲管理</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box red">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>赛季歌曲管理
                    </div>
                </div>
                <div class="portlet-body form" id="subLevelRow">
                    <form class="form-horizontal" id="subLevelForm">
                        <div class="form-body">
                            <h3 class="form-section">Step 1:选择段位</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">段位</label>
                                        <div class="col-md-8">
                                            <select class="form-control" id="levelId" name="levelId">
                                                <option value="">--请选择歌曲段位--</option>
                                                <#list sublevels as l>
                                                    <option value="${l.levelId}-${l.id}">${l.levelName} - ${l.subLevelName}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-9">
                                        <input type="hidden" id="seasonId" name="seasonId" value="${(c.seasonId)!''}"/>
                                        <button type="submit" class="btn blue">去选择歌曲<i class="fa fa-long-arrow-right" style="padding-left: 8px"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="portlet-body form" id="listRow" style="display: none">

                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/icheck/icheck.min.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/meta/race_season_song_select.js" type="text/javascript"></script>
<script type="text/javascript">
    RaceSeasonSongSelectManager.Initializer.init();
</script>
