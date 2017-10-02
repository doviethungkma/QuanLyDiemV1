<%-- 
    Document   : success
    Created on : Sep 10, 2017, 3:42:14 AM
    Author     : shadyside
--%>

<%@page import="com.act.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("userAccount");
        %>
        <h1>Hello <%= user.getUsername()%></h1>
    </body>
</html>
