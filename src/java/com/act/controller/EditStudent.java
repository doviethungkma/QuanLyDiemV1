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
public class EditStudent extends HttpServlet {

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
            out.println("<title>Servlet EditStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditStudent at " + request.getContextPath() + "</h1>");
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
            response.sendRedirect("Login.jsp");
        } else {
            StudentDA studentDA = new StudentDA();
            ArrayList<Student> lstAllStudent = studentDA.getAllStudent();
            request.setAttribute("lstAllStudent", lstAllStudent);
            request.getRequestDispatcher("CanBoQuanLy/suasinhvien.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("ID"));
            String fullname = request.getParameter("txtFullName");
            String dateOfBirth = request.getParameter("txtDateOfBirth");
            String addrress = request.getParameter("txtAddress");
            String sex = request.getParameter("sltSex");
            String classSV = request.getParameter("sltClass");

            StudentDA studentDA = new StudentDA();
            ClassSVDA classSVDA = new ClassSVDA();
            int classID = classSVDA.getClassByClassName(classSV).getID();

            boolean check = studentDA.updateStudentByID(id, fullname, dateOfBirth, addrress, sex, "sjhd", classID);
            if (check) {
                request.getRequestDispatcher("ManageStudent").forward(request, response);
            } else {
                response.sendRedirect("404.jsp");
            }

//            response.sendRedirect("quanlysinhvien.jsp");
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
    }
}
