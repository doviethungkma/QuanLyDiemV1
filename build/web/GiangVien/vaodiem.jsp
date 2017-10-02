<%-- 
    Document   : themsinhvien
    Created on : Sep 10, 2017, 1:41:16 PM
    Author     : shadyside
--%>

<%@page import="com.act.dao.ManageSubjectDA"%>
<%@page import="com.act.dao.ManageTeachDA"%>
<%@page import="com.act.model.Mark"%>
<%@page import="com.act.dao.MarkDA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.act.dao.ClassSVDA"%>
<%@page import="com.act.model.ClassSV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Title -->
        <title>Thêm sinh viên</title>

        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />

        <!-- Styles -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <link href="../assets/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet"/>
        <link href="../assets/plugins/uniform/css/uniform.default.min.css" rel="stylesheet"/>
        <link href="../assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/waves/waves.min.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/weather-icons-master/css/weather-icons.min.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/metrojs/MetroJs.min.css" rel="stylesheet" type="text/css"/>	
        <link href="../assets/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css"/>	

        <!-- Theme Styles -->
        <link href="../assets/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/themes/green.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/custom.css" rel="stylesheet" type="text/css"/>

        <script src="../assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="../assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="page-header-fixed">
        <div class="overlay"></div>
        <form class="search-form" action="#" method="GET">
            <div class="input-group">
                <input type="text" name="search" class="form-control search-input" placeholder="Search...">
                <span class="input-group-btn">
                    <button class="btn btn-default close-search waves-effect waves-button waves-classic" type="button"><i class="fa fa-times"></i></button>
                </span>
            </div><!-- Input Group -->
        </form><!-- Search Form -->
        <main class="page-content content-wrap">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="logo-box">
                        <a href="index.html" class="logo-text"><span>Quản lý điểm</span></a>
                    </div><!-- Logo Box -->
                    <div class="search-button">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                    </div>
                    <div class="topmenu-outer">
                        <div class="top-menu">
                            <ul class="nav navbar-nav navbar-left">
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic sidebar-toggle"><i class="fa fa-bars"></i></a>
                                </li>
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic toggle-fullscreen"><i class="fa fa-expand"></i></a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li>	
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <span class="user-name">Nguyễn Văn Bình<i class="fa fa-angle-down"></i></span>
                                        <img class="img-circle avatar" src="assets/images/avatar1.png" width="40" height="40" alt="">
                                    </a>
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="profile.html"><i class="fa fa-user"></i>Profile</a></li>
                                        <li role="presentation"><a href="calendar.html"><i class="fa fa-calendar"></i>Calendar</a></li>
                                        <li role="presentation"><a href="inbox.html"><i class="fa fa-envelope"></i>Inbox<span class="badge badge-success pull-right">4</span></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href="lock-screen.html"><i class="fa fa-lock"></i>Lock screen</a></li>
                                        <li role="presentation"><a href="login.html"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="login.html" class="log-out waves-effect waves-button waves-classic">
                                        <span><i class="fa fa-sign-out m-r-xs"></i>Log out</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic" id="showRight">
                                        <i class="fa fa-comments"></i>
                                    </a>
                                </li>
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
            <div class="page-sidebar sidebar">
                <div class="page-sidebar-inner slimscroll">
                    <div class="sidebar-header">
                        <div class="sidebar-profile">
                            <div class="sidebar-profile-image">
                                <img src="assets/images/profile-menu-image.png" class="img-circle img-responsive" alt="">
                            </div>
                            <div class="sidebar-profile-details">
                                <span>Nguyễn Văn Bình<br><small>Quản lý</small></span>
                            </div>
                        </div>
                    </div>
                    <ul class="menu accordion-menu">
                        <li class="active"><a href="index.html" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>Trang chủ</p></a></li>
                        <li><a href="ViewResultByLecturer" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>Quản lý điểm sinh viên</p></a></li>
                    </ul>
                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            <div class="page-inner">
                <div class="page-title">
                    <h3>Thêm sinh viên</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li class="active">Themsinhvien</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Sửa, vào điểm</h4>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" action="AddStudent" method="POST">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Tên môn học</label>
                                            <div class="col-sm-10">
                                                <select class="form-control m-b-sm" name="sltSex" id="sltSex">
                                                    <%
                                                        MarkDA markDA = new MarkDA();
                                                        ArrayList<Mark> lstMarks = new ArrayList<Mark>();
                                                        ManageTeachDA manageTeachDA = new ManageTeachDA();
                                                        ManageSubjectDA manageSubjectDA = new ManageSubjectDA();
                                                        for (Mark mark : lstMarks) {
                                                            int teachID = mark.getTeachID();
                                                            int subjectID = manageTeachDA.getTeachInfoByID(teachID).getSubjectID();
                                                    %>

                                                    <option value="Nam" ><%= manageSubjectDA.getSubjectByID(subjectID).getSubjectName()%></option>
                                                    <%                                                    }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Lớp</label>
                                            <div class="col-sm-10">
                                                <select class="form-control m-b-sm" name="sltSex" id="sltSex">
                                                    <option value="Nam" >Nam</option>
                                                    <option value="Nữ">Nữ</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Sinh viên</label>
                                            <div class="col-sm-10">
                                                <select class="form-control m-b-sm" name="sltSex" id="sltSex">
                                                    <option value="Nam" >Nam</option>
                                                    <option value="Nữ">Nữ</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input-Default" class="col-sm-2 control-label">Điểm thành phần 1</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="txtScore1" class="form-control" id="input-Default">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input-Default" class="col-sm-2 control-label">Điểm thành phần 2</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="txtScore2" class="form-control" id="input-Default">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input-Default" class="col-sm-2 control-label">Điểm thành phần 3</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="txtScore3" class="form-control" id="input-Default">
                                            </div>
                                        </div>
                                        <div class="col-lg-5 col-lg-offset-6">
                                            <div class="col-lg-2 col-lg-offset-8">
                                                <button type="submit" class="btn btn-success">&nbsp;&nbsp;&nbsp;Sửa&nbsp;&nbsp;&nbsp;</button>
                                            </div>
                                            <div class="col-lg-2">
                                                <button type="button" class="btn btn-default">&nbsp;&nbsp;&nbsp;Hủy&nbsp;&nbsp;&nbsp;</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- Row -->
            </div>
            <div class="page-footer">
                <p class="no-s">2015 &copy; Modern by Steelcoders.</p>
            </div>
        </div> 
    </main><!-- Page Content -->
    <div class="cd-overlay"></div>


    <!-- Javascripts -->
    <script src="../assets/plugins/jquery/jquery-2.1.4.min.js"></script>
    <script src="../assets/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="../assets/plugins/pace-master/pace.min.js"></script>
    <script src="../assets/plugins/jquery-blockui/jquery.blockui.js"></script>
    <script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="../assets/plugins/switchery/switchery.min.js"></script>
    <script src="../assets/plugins/uniform/jquery.uniform.min.js"></script>
    <script src="../assets/plugins/offcanvasmenueffects/js/classie.js"></script>
    <script src="../assets/plugins/offcanvasmenueffects/js/main.js"></script>
    <script src="../assets/plugins/waves/waves.min.js"></script>
    <script src="../assets/plugins/3d-bold-navigation/js/main.js"></script>
    <script src="../assets/plugins/waypoints/jquery.waypoints.min.js"></script>
    <script src="../assets/plugins/jquery-counterup/jquery.counterup.min.js"></script>
    <script src="../assets/plugins/toastr/toastr.min.js"></script>
    <script src="../assets/plugins/flot/jquery.flot.min.js"></script>
    <script src="../assets/plugins/flot/jquery.flot.time.min.js"></script>
    <script src="../assets/plugins/flot/jquery.flot.symbol.min.js"></script>
    <script src="../assets/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="../assets/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="../assets/plugins/curvedlines/curvedLines.js"></script>
    <script src="../assets/plugins/metrojs/MetroJs.min.js"></script>
    <script src="../assets/js/modern.js"></script>
    <script src="../assets/js/pages/dashboard.js"></script>

</body>
</html>
