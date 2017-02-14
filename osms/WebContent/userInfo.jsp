<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>ES | 个人资料</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/nisalButton.css">
    <style>

#clipArea {
	margin: 20px;
	height: 300px;
	margin: auto;
  background-color: #3E3E3E;
}
#file,
#clipBtn {
	margin: 20px;
}
#view {
	width: 200px;
	height: 200px;
}
#clipWarp{
	z-index: 999;
	position:absolute;
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
<div id="clipWarp">
<div id="clipArea"></div>
<input type="file" id="file" style="color:#FFF">
<button id="clipBtn" class="buttoner">截取</button>
</div>

  </div>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">EasyShare</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><strong><i class="icon fa fa-smile-o"></i> Easy Share</strong></a>

		<div id="sideNav" href="">
		<i class="fa fa-bars icon"></i>
		</div>
            </div>

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"  style="color:#000;"></i> <i class="fa fa-caret-down"  style="color:#000;"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>Nisal</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i>个人信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                        </li>
                    </ul>

                </li>

            </ul>
        </nav>

        <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="index.html"><i class="fa fa-dashboard"></i> 仪表盘</a>
                </li>
                <li>
                    <a href="equitment.html"><i class="fa fa-desktop"></i>设备</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap"></i>书籍<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="books.html">书本信息</a>
                        </li>
                        <li>
                            <a href="borrowedBooks.html">书本借出信息</a>
                        </li>
                    </ul>
                </li>
                <li>
                <a href="#"><i class="fa fa-sitemap"></i>项目<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="myProjects.html">我的项目</a>
                        </li>
                        <li>
                            <a href="projects.html">现役项目</a>
                        </li>
                        <li>
                            <a href="historyProjects.html">历史项目&操作</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="money.html"><i class="fa fa-money"></i>资金</a>
                </li>
                <li>
                    <a href="repair.html"><i class="fa fa-table"></i>维修服务统计</a>
                </li>
                <li>
                    <a href="root.html"><i class="fa fa-edit"></i>权限分配</a>
                </li>
                <li>
                    <a href="labMember.html"><i class="fa fa-users"></i>实验室人员管理</a>
                </li>
            </ul>

        </div>

        </nav>

        <div id="page-wrapper">
		  <div class="header">
                        <h1 class="page-header">
                            你的资料 <small>你好 Nisal</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">根</a></li>
					  <li><a href="#">仪表盘</a></li>
					  <li class="active">资料</li>
					</ol>

		</div>
            <div id="page-inner">
              <div class="row">
                  <div class="col-xs-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <div class="card-title">
                                  <div class="title">详细资料</div>
                              </div>
                          </div>
                          <div class="panel-body">
                              <form class="form-horizontal">

                              <div class="form-group">
                                  <label for="inputEmail3" class="col-sm-2 control-label">头像</label>
                                  <div class="col-sm-10">
                                  <div id="view"></div>
                              </div>
                            </div>
                                  <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                                      <div class="col-sm-10">
                                          <input type="email" class="form-control" id="" placeholder="邮箱">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">QQ</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="QQ">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">微信</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="微信">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">电话号码</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="电话号码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">通讯地址</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="通讯地址">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-sm-offset-2 col-sm-10">
                                          <button type="submit" class="buttoner">保存</button>
                                      </div>
                                  </div>
                                  </form>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-xs-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <div class="card-title">
                                  <div class="title">修改密码</div>
                              </div>
                          </div>
                          <div class="panel-body">
                              <form class="form-horizontal">
                                  <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
                                      <div class="col-sm-10">
                                          <input type="email" class="form-control" id="" placeholder="旧密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="新密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                                      <div class="col-sm-10">
                                          <input type="password" class="form-control" id="" placeholder="新密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-sm-offset-2 col-sm-10">
                                          <button type="submit" class="buttoner">保存</button>
                                      </div>
                                  </div>
                                  </form>
                          </div>
                      </div>
                  </div>
              </div>
				 <footer><p>Copyright &copy; 2016.EasyShare All rights reserved.</p></footer>
				</div>

            </div>

        </div>

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

    <!-- DATA TABLE SCRIPTS -->
   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
   <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
   <script src="js/iscroll-zoom.js"></script>
   <script src="js/hammer.js"></script>
   <script src="js/lrz.all.bundle.js"></script>
   <script src="js/jquery.photoClip.js"></script>
   <script>
   $(document).ready(function(){
   	$("#clipWarp").hide();
     $("#view").click(function(){
   		$("#wrapper").fadeOut();
   		$("#clipWarp").fadeIn();

     });
   	$("#clipBtn").click(function(){
   		$("#clipWarp").fadeOut();
   		$("#wrapper").fadeIn();
   	});
   });
   //document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
   var clipArea = new bjj.PhotoClip("#clipArea", {
   	size: [260, 260],
   	outputSize: [640, 640],
   	file: "#file",
   	view: "#view",
   	ok: "#clipBtn",
   	loadStart: function() {
   		console.log("照片读取中");
   	},
   	loadComplete: function() {
   		console.log("照片读取完成");
   	},
   	clipFinish: function(dataURL) {
   		console.log(dataURL);
   	}
   });
   //clipArea.destroy();
   </script>
</body>
</html>
