<%-- 
    Document   : themsinhvien
    Created on : Sep 10, 2017, 1:41:16 PM
    Author     : shadyside
--%>

<%@page import="com.act.dao.RoleDA"%>
<%@page import="com.act.model.User"%>
<%@page import="com.act.model.Lecturer"%>
<%@page import="com.act.dao.ManageLecturerDA"%>
<%@page import="com.act.model.Subject"%>
<%@page import="com.act.dao.ManageSubjectDA"%>
<%@page import="com.act.controller.ManageStudent"%>
<%@page import="com.act.model.Teach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.act.dao.ClassSVDA"%>
<%@page import="com.act.model.ClassSV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Title -->
        <title>Thêm lớp học</title>

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
    <body class="page-header-fixed">
        <%
            User user = (User) session.getAttribute("userAccount");
            if (user == null) {
                response.sendRedirect("http://localhost:8080/QuanLyDiemV1/");
            } else {
                int loginID = user.getLoginID();
                RoleDA roleDA = new RoleDA();
                if (roleDA.checkRole(loginID).equals("QuanLy")) {
        %>
        <jsp:include page="../Menu.jsp"></jsp:include>
        <jsp:include page="../sidebar.jsp"></jsp:include>   
            <div class="page-inner">
                <div class="page-title">
                    <h3>Thêm lớp học</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li class="active">Themlophoc</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Thêm lớp học</h4>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" action="AddClassSV" method="POST">
                                        <div class="form-group">
                                            <label for="input-Default" class="col-sm-2 control-label">Tên lớp học</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="txtClassName" class="form-control" id="input-Default txtFullName" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Khóa</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="txtGrade" class="form-control" id="input-Default txtFullName" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Khoa</label>
                                            <div class="col-sm-10">
                                                <select class="form-control m-b-sm" name="sltKhoa" id="sltLecturer">

                                                    <option value="Công nghệ thông tin">Công nghệ thông tin</option>
                                                    <option value="An toàn thông tin">An toàn thông tin</option>
                                                    <option value="Điện tử viễn thông">Điện tử viễn thông</option>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Giáo viên chủ nhiệm</label>
                                            <div class="col-sm-10">
                                                <select class="form-control m-b-sm" name="sltIDGVCN" id="sltLecturer">
                                                <%
                                                    ManageLecturerDA manageLecturerDA = new ManageLecturerDA();
                                                    ArrayList<Lecturer> lstLecturer = manageLecturerDA.getAllLecture();
                                                    for (Lecturer lecturer : lstLecturer) {
                                                %>
                                                <option value="<%= lecturer.getLecturerName()%>"><%= lecturer.getLecturerName()%></option>
                                                <%
                                                    }
                                                %>


                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-lg-offset-8">
                                        <button type="submit" class="btn btn-success">Sửa lớp học</button>
                                    </div>
                                    <div class="col-lg-2">
                                        <button type="button" class="btn btn-default">&nbsp;&nbsp;&nbsp;Hủy&nbsp;&nbsp;&nbsp;</button>
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
<%
        } else {
            response.sendRedirect("http://localhost:8080/QuanLyDiemV1/404.jsp");
        }
    }
%>

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
