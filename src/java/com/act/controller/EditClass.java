/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.controller;

import com.act.dao.ManageLecturerDA;
import com.act.dao.ManageSubjectDA;
import com.act.dao.ManageTeachDA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shadyside
 */
public class EditClass extends HttpServlet {

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
            out.println("<title>Servlet EditClass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditClass at " + request.getContextPath() + "</h1>");
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
            request.getRequestDispatcher("CanBoQuanLy/sualophoc.jsp").forward(request, response);
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
            String name = request.getParameter("txtName");
            String subjectName = request.getParameter("sltSubjectName");
            ManageSubjectDA manageSubjectDA = new ManageSubjectDA();
            int subjectID = manageSubjectDA.getSubjectInfo(subjectName).getID();
            String lecturerName = request.getParameter("sltLecturer");
            ManageLecturerDA manageLecturerDA = new ManageLecturerDA();
            int lecturerID = manageLecturerDA.getLecturerByLecturerName(lecturerName).getID();
            int ID = Integer.parseInt(request.getParameter("ID"));

            ManageTeachDA manageTeachDA = new ManageTeachDA();

            boolean test = manageTeachDA.updateTeach(subjectID, lecturerID, name, ID);
            if (test) {
                response.sendRedirect("ManageTeach");
            } else {
                response.sendRedirect("AddSubjectClass");
            }
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
