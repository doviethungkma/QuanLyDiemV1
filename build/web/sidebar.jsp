<%-- 
    Document   : sidebar
    Created on : Sep 23, 2017, 4:02:54 PM
    Author     : shadyside
--%>

<%@page import="com.act.dao.UserDAO"%>
<%@page import="com.act.model.User"%>
<%@page import="com.act.dao.RoleDA"%>
<%@page import="com.act.model.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />

        <!-- Styles -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <link href="assets/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet"/>
        <link href="assets/plugins/uniform/css/uniform.default.min.css" rel="stylesheet"/>
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/waves/waves.min.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/weather-icons-master/css/weather-icons.min.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/metrojs/MetroJs.min.css" rel="stylesheet" type="text/css"/>	
        <link href="assets/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css"/>	

        <!-- Theme Styles -->
        <link href="assets/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themes/green.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>

        <script src="assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div class="page-sidebar sidebar">
            <div class="page-sidebar-inner slimscroll">
                <div class="sidebar-header">
                    <div class="sidebar-profile">
                        <div class="sidebar-profile-image">
                            <img src="assets/images/profile-menu-image.png" class="img-circle img-responsive" alt="">
                        </div>
                        <div class="sidebar-profile-details">
                            <span>
                                Nguyễn Văn Bình<br><small>Quản lý</small>
                            </span>
                        </div>
                    </div>
                </div>
                <ul class="menu accordion-menu">
                    <li class="active"><a href="Redirect" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>Trang chủ</p></a></li>
                    <li><a href="ManagerAssignToMark" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-pushpin"></span><p>Phân công chấm thi</p></a></li>
                    <li><a href="ViewResultByManager" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-list"></span><p>Xem điểm sinh viên</p></a></li>
<!--                    <li><a href="profile.html" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>In danh sách điểm</p></a></li>-->             <li><a href="ManageStudent" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>Quản lý sinh viên</p></a></li>
                    <li><a href="ManageTeach" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-briefcase"></span><p>Quản lý lớp môn học</p></a></li>
                    <li><a href="ManageClass" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-folder-open"></span><p>Quản lý lớp chủ nhiệm</p></a></li>
                </ul>

            </div><!-- Page Sidebar Inner -->
        </div><!-- Page Sidebar -->


        <!-- Javascripts -->
        <script src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="assets/plugins/pace-master/pace.min.js"></script>
        <script src="assets/plugins/jquery-blockui/jquery.blockui.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/plugins/switchery/switchery.min.js"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/classie.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/main.js"></script>
        <script src="assets/plugins/waves/waves.min.js"></script>
        <script src="assets/plugins/3d-bold-navigation/js/main.js"></script>
        <script src="assets/plugins/waypoints/jquery.waypoints.min.js"></script>
        <script src="assets/plugins/jquery-counterup/jquery.counterup.min.js"></script>
        <script src="assets/plugins/toastr/toastr.min.js"></script>
        <script src="assets/plugins/flot/jquery.flot.min.js"></script>
        <script src="assets/plugins/flot/jquery.flot.time.min.js"></script>
        <script src="assets/plugins/flot/jquery.flot.symbol.min.js"></script>
        <script src="assets/plugins/flot/jquery.flot.resize.min.js"></script>
        <script src="assets/plugins/flot/jquery.flot.tooltip.min.js"></script>
        <script src="assets/plugins/curvedlines/curvedLines.js"></script>
        <script src="assets/plugins/metrojs/MetroJs.min.js"></script>
        <script src="assets/js/modern.js"></script>
        <script src="assets/js/pages/dashboard.js"></script>

    </body>
</html>
