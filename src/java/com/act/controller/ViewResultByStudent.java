/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.controller;

import com.act.dao.ResultDA;
import com.act.dao.StudentDA;
import com.act.model.Result;
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
public class ViewResultByStudent extends HttpServlet {

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
            out.println("<title>Servlet ViewResultByStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewResultByStudent at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("userAccount") == null) {
            response.sendRedirect("index.jsp");
        } else {
            int loginID = (int) request.getSession().getAttribute("loginID");
            StudentDA studentDA = new StudentDA();
            int studentID = studentDA.getStudentByLoginID(loginID).getID();
            ResultDA resultDA = new ResultDA();
            ArrayList<Result> lsResults = resultDA.getResultByStudent(studentID);
            request.setAttribute("lstResults", lsResults);
            request.setAttribute("year", "");
            request.getRequestDispatcher("SinhVien/xemdiem_1.jsp").forward(request, response);
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

            String year = request.getParameter("sltYear");
            int loginID = (int) request.getSession().getAttribute("loginID");
            StudentDA studentDA = new StudentDA();
            int studentID = studentDA.getStudentByLoginID(loginID).getID();
            ResultDA resultDA = new ResultDA();
            ArrayList<Result> lsResults = resultDA.getResultByStudent(studentID, year);
            request.setAttribute("lstResults", lsResults);
            request.setAttribute("year", year);
            request.getRequestDispatcher("SinhVien/xemdiem_1.jsp").forward(request, response);

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
