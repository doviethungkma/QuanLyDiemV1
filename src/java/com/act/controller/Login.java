/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.controller;

import com.act.dao.RoleDA;
import com.act.dao.UserDAO;
import com.act.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author shadyside
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
//        response.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        if (session.getAttribute("loginID") != null) {
//            RoleDA roleDA = new RoleDA();
//            int loginID = (int) session.getAttribute("loginID");
//
//            if (loginID > 0) {
//                if (roleDA.checkRole(loginID).equals("QuanLy")) {
////                    response.sendRedirect("CanBoQuanLy/canboquanly.jsp");
//                    request.getRequestDispatcher("CanBoQuanLy/canboquanly.jsp").forward(request, response);
//                } else if (roleDA.checkRole(loginID).equals("GVCN")) {
//                    request.getRequestDispatcher("GiaoVienChuNhiem/giaovienchunhiem.jsp").forward(request, response);
//                } else if (roleDA.checkRole(loginID).equals("GiangVien")) {
//                    request.getRequestDispatcher("GiangVien/giangvien.jsp").forward(request, response);
//                } else if (roleDA.checkRole(loginID).equals("SinhVien")) {
//                    request.getRequestDispatcher("SinhVien/sinhvien.jsp").forward(request, response);
//                } else {
//                    response.sendRedirect("404.jsp");
//                }
//            }
//        }

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

        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            UserDAO user = new UserDAO();
            int loginID = user.checkLogin(username, password);
            User userAccount = user.getUserByID(loginID);
            HttpSession session = request.getSession();
            RoleDA roleDA = new RoleDA();

            if (loginID > 0) {
                if (roleDA.checkRole(loginID).equals("QuanLy")) {
                    session.setAttribute("userAccount", userAccount);
                    session.setAttribute("loginID", loginID);
                    request.getRequestDispatcher("CanBoQuanLy/canboquanly.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("GVCN")) {
                    session.setAttribute("userAccount", userAccount);
                    session.setAttribute("loginID", loginID);
                    request.getRequestDispatcher("GiaoVienChuNhiem/giaovienchunhiem.jsp").forward(request, response);
                    request.getRequestDispatcher("GiaoVienChuNhiem/giaovienchunhiem.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("GiangVien")) {
                    session.setAttribute("userAccount", userAccount);
                    session.setAttribute("loginID", loginID);
                    request.getRequestDispatcher("GiangVien/giangvien.jsp").forward(request, response);
                } else if (roleDA.checkRole(loginID).equals("SinhVien")) {
                    session.setAttribute("userAccount", userAccount);
                    session.setAttribute("loginID", loginID);
                    request.getRequestDispatcher("SinhVien/sinhvien.jsp").forward(request, response);
                } else {
                    response.sendRedirect("404.jsp");
                }

            }
        } catch (Exception ex) {
            response.sendRedirect("404.jsp");
        }
        response.sendRedirect("404.jsp");
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
