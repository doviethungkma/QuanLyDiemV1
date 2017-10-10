/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.controller;

import com.act.dao.ClassSVDA;
import com.act.dao.RoleDA;
import com.act.dao.StudentDA;
import com.act.dao.UserDAO;
import com.act.model.Student;
import com.act.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shadyside
 */
public class AddStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("userAccount") == null) {
            response.sendRedirect("index.jsp");
        } else {
            StudentDA studentDA = new StudentDA();
            ArrayList<Student> lstAllStudent = studentDA.getAllStudent();
            request.setAttribute("lstAllStudent", lstAllStudent);
            request.getRequestDispatcher("CanBoQuanLy/themsinhvien.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("userAccount") == null) {
            response.sendRedirect("index.jsp");
        } else {
            String fullname = request.getParameter("txtFullName");
            String dateOfBirth = request.getParameter("txtDateOfBirth");
            String addrress = request.getParameter("txtAddress");
            String sex = request.getParameter("sltSex");
            String classSV = request.getParameter("sltClass");
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            StudentDA studentDA = new StudentDA();
            ClassSVDA classSVDA = new ClassSVDA();
            UserDAO userDAO = new UserDAO();
            userDAO.addUser(username, password);
            RoleDA roleDA = new RoleDA();
            int classID = classSVDA.getClassByClassName(classSV).getID();
            int loginID = userDAO.getUserIDFromUsername(username);
            roleDA.addRoleByID(loginID, 4);

            studentDA.addStudent(fullname, dateOfBirth, addrress, sex, password, classID, loginID);
            request.getRequestDispatcher("ManageStudent").forward(request, response);

//            response.sendRedirect("quanlysinhvien.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
