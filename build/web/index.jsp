<%-- 
    Document   : index
    Created on : Sep 10, 2017, 2:55:05 AM
    Author     : shadyside
--%>

<%@page import="com.act.dao.RoleDA"%>
<%@page import="com.act.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Title -->
        <title>Modern | Login - Sign in</title>

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

        <!-- Theme Styles -->
        <link href="assets/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/themes/green.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>

        <script src="assets/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="assets/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>

        <script type="text/javascript">
            function checkForm(form)
            {
                if (form.username.value == "") {
                    alert("Username không được rỗng");
                    form.username.focus();
                    return false;
                }
                re = /^[A-Za-z0-9_\.]{6,32}$/;
                if (!re.test(form.username.value)) {
                    alert("Username > 6 kí tự");
                    form.username.focus();
                    return false;
                }
                re = /^([A-Z]){1}([\w_\.!@#$%^&*()]+){5,31}$/;
                if (!re.test(form.pwd1.value)) {
                    alert("Err: Password phải > 6 kí tự và gồm ký tự thường, ký tự hoa ,ký số và ký tự đặc biệt");
                    form.pwd1.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body class="page-login">
        <%
            User user = (User) session.getAttribute("userAccount");
            if (user != null) {
                int loginID = user.getLoginID();
                RoleDA roleDA = new RoleDA();
                if (roleDA.checkRole(loginID).equals("QuanLy")) {
                    request.getRequestDispatcher("CanBoQuanLy/canboquanly.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("GVCN")) {
                    request.getRequestDispatcher("GiaoVienChuNhiem/giaovienchunhiem.jsp").forward(request, response);
                    request.getRequestDispatcher("GiaoVienChuNhiem/giaovienchunhiem.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("GiangVien")) {
                    request.getRequestDispatcher("GiangVien/giangvien.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("SinhVien")) {
                    request.getRequestDispatcher("SinhVien/sinhvien.jsp").forward(request, response);
                } else {
                    response.sendRedirect("404.jsp");
                }
            }
        %>
        <main class="page-content">
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-md-3 center">
                            <div class="login-box">
                                <a href="index.html" class="logo-name text-lg text-center">Đăng nhập</a>
                                <p class="text-center m-t-md">Xin nhập tài khoản và mật khẩu</p>
                                <form class="m-t-md" action="Login" method="POST" onsubmit="return checkForm(this) >
                                                < div class ="form-group">
                                      <input type="text" name="txtUsername" class="form-control" placeholder="Account" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="txtPassword" class="form-control" placeholder="Password" required>
                                    </div>
                                    <button type="submit" class="btn btn-success btn-block">Login</button>
                                    <a href="forgot.html" class="display-block text-center m-t-md text-sm">Quên mật khẩu?</a>
                                </form>
                                <p class="text-center m-t-xs text-sm">2015 &copy; Modern by Steelcoders.</p>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
            </div><!-- Page Inner -->
        </main><!-- Page Content -->



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
        <script src="assets/plugins/waves/waves.min.js"></script>
        <script src="assets/js/modern.min.js"></script>


    </body>
</html>