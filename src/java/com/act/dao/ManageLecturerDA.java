/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.Lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadyside
 */
public class ManageLecturerDA {

    public Lecturer getLecturerByLecturerID(int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_lecturer WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            Lecturer lecturer = new Lecturer();

            if (rs.next()) {
                lecturer.setID(rs.getInt("ID"));
                lecturer.setLecturerName(rs.getString("LecturerName"));
                lecturer.setDateOfBirth(rs.getString("DateOfBirth"));
                lecturer.setAddress(rs.getString("Address"));
                lecturer.setSex(rs.getString("Sex"));
                lecturer.setAvatar(rs.getString("Avatar"));
                lecturer.setLoginID(rs.getInt("LoginID"));
            }
            return lecturer;
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturerDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public Lecturer getLecturerByLoginID(int loginID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_lecturer WHERE LoginID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginID);
            rs = ps.executeQuery();
            Lecturer lecturer = new Lecturer();

            if (rs.next()) {
                lecturer.setID(rs.getInt("ID"));
                lecturer.setLecturerName(rs.getString("LecturerName"));
                lecturer.setDateOfBirth(rs.getString("DateOfBirth"));
                lecturer.setAddress(rs.getString("Address"));
                lecturer.setSex(rs.getString("Sex"));
                lecturer.setAvatar(rs.getString("Avatar"));
                lecturer.setLoginID(rs.getInt("LoginID"));
            }
            return lecturer;
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturerDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Lecturer getLecturerByLecturerName(String lecturerName) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_lecturer WHERE LecturerName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, lecturerName);
            rs = ps.executeQuery();
            Lecturer lecturer = new Lecturer();
            if (rs.next()) {
                lecturer.setID(rs.getInt("ID"));
                lecturer.setLecturerName(rs.getString("LecturerName"));
                lecturer.setDateOfBirth(rs.getString("DateOfBirth"));
                lecturer.setAddress(rs.getString("Address"));
                lecturer.setSex(rs.getString("Sex"));
                lecturer.setAvatar(rs.getString("Avatar"));
                lecturer.setLoginID(rs.getInt("LoginID"));
            }
            return lecturer;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

  
    public ArrayList<Lecturer> getAllLecture() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_lecturer";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Lecturer> lstAllLecturer = new ArrayList<>();
            while (rs.next()) {
                Lecturer lecturer = new Lecturer();
                lecturer.setID(rs.getInt("ID"));
                lecturer.setLecturerName(rs.getString("LecturerName"));
                lecturer.setDateOfBirth(rs.getString("DateOfBirth"));
                lecturer.setAddress(rs.getString("Address"));
                lecturer.setSex(rs.getString("Sex"));
                lecturer.setAvatar(rs.getString("Avatar"));
                lecturer.setLoginID(rs.getInt("LoginID"));
                lstAllLecturer.add(lecturer);
            }
            return lstAllLecturer;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        ManageLecturerDA manageLecturerDA = new ManageLecturerDA();
        Lecturer lecturer = manageLecturerDA.getLecturerByLecturerName("Hoàng Đức Thọ");
        
        System.out.println(lecturer.getID());
    }
}
