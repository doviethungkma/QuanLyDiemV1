<%-- 
    Document   : xemdiem
    Created on : Sep 10, 2017, 10:51:56 AM
    Author     : shadyside
--%>

<%@page import="com.act.dao.RoleDA"%>
<%@page import="com.act.model.User"%>
<%@page import="com.act.dao.ResultDA"%>
<%@page import="com.act.dao.ManageTeachDA"%>
<%@page import="com.act.model.Student"%>
<%@page import="com.act.dao.StudentDA"%>
<%@page import="com.act.model.Result"%>
<%@page import="com.act.model.Subject"%>
<%@page import="com.act.dao.ManageSubjectDA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.act.model.ClassSV"%>
<%@page import="com.act.dao.ClassSVDA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Title -->
        <title>Xem điểm sinh viên</title>

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
                    <h3>Xem điểm sinh viên</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li class="active">xemdiemsinhvien</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Xem điểm sinh viên</h4>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" action="ViewResultByManager" method="POST">
                                        <div class="form-group">
                                            <label for="input-Default" class="col-lg-1 control-label">Năm học</label>
                                            <div class="col-lg-2">
                                                <div class="col-lg-10">
                                                    <select class="form-control m-b-sm" name="sltYear" id="sltYear">
                                                        <option>Chọn năm học</option>
                                                        <option value="2013-2014">2013-2014</option>
                                                        <option value="2014-2015">2014-2015</option>
                                                        <option value="2015-2016">2015-2016</option>
                                                        <option value="2016-2017">2016-2017</option>
                                                        <option value="2017-2018">2017-2018</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <label for="input-Default" class="col-lg-1 control-label">Môn học</label>
                                            <div class="col-lg-2">
                                                <div class="col-lg-10">
                                                    <select class="form-control m-b-sm" name="sltSubject" id="sltSubject">
                                                    <%
                                                        ManageSubjectDA manageSubjectDA = new ManageSubjectDA();
                                                        ArrayList<Subject> lstAllSubject = manageSubjectDA.getAllSubject();
                                                        for (Subject subject : lstAllSubject) {
                                                    %>
                                                    <option value="<%= subject.getSubjectName()%>"><%= subject.getSubjectName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <label for="input-Default" class="col-lg-1 control-label">Lớp</label>
                                        <div class="col-lg-2">
                                            <div class="col-lg-10">
                                                <select class="form-control m-b-sm" name="sltClassName" id="sltClassName">
                                                    <option>Chọn lớp</option>
                                                    <%
                                                        ClassSVDA classSVDA = new ClassSVDA();
                                                        ArrayList<ClassSV> lstAllClass = classSVDA.getAllClass();
                                                        for (ClassSV classSV : lstAllClass) {
                                                    %>

                                                    <option value="<%= classSV.getClassName()%>"><%= classSV.getClassName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-1">
                                            <button type="submit" class="btn btn-success">Xem điểm thi</button>
                                        </div>
                                </form>
                            </div>

                            <div class="panel-body">
                                <div class="table-responsive project-stats">  
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Tên sinh viên</th>
                                                <th>Môn học</th>
                                                <th>Điểm thành phần 1</th>
                                                <th>Điểm thành phần 2</th>
                                                <th>Điểm thi</th>
                                                <th>Điểm tổng kết</th>
                                                <th>Điểm chữ</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                int i = 1;
                                                ArrayList<Result> lstResult = (ArrayList<Result>) request.getAttribute("lstResults");
                                                ResultDA resultDA = new ResultDA();
                                                if (lstResult != null) {
                                                    for (Result result : lstResult) {
                                                        int studentID = result.getStudentID();
                                                        //Lấy đối tượng student 
                                                        StudentDA ststudentDA = new StudentDA();
                                                        Student student = ststudentDA.getStudentByID(studentID);
                                                        //Lấy đối tượng môn học
                                                        ManageTeachDA manageTeachDA = new ManageTeachDA();
                                                        int subjectID = manageTeachDA.getTeachInfoByID(result.getTeachID()).getSubjectID();
                                                        Subject subject = manageSubjectDA.getSubjectByID(subjectID);
                                                        int score1 = result.getScore1();
                                                        int score2 = result.getScore2();
                                                        int score3 = result.getScore3();
                                                        double diemTB = resultDA.tinhDiem(result.getScore1(), result.getScore2(), result.getScore3());
                                            %>
                                            <tr>
                                                <th scope="row"><%= i++%></th>
                                                <td><%= student.getStudentName()%></td>
                                                <td><%= subject.getSubjectName()%></td>
                                                <td><%= score1%></td>
                                                <td><%= score2%></td>
                                                <td><%= score3%></td>
                                                <td><%= diemTB%></td>
                                                <td><%= resultDA.diemHeChu(diemTB)%></td>
                                            </tr>
                                            <%
                                                    }
                                                }
                                            %>
                                        </tbody>
                                    </table>
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