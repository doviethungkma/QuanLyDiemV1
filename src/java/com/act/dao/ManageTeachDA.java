/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.Subject;
import com.act.model.Teach;
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
public class ManageTeachDA {

    public ArrayList<Teach> getAllTeachInfo() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_teach ORDER BY SubjectID ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Teach> lstTeachInfo = new ArrayList();
            while (rs.next()) {
                Teach teach = new Teach();
                teach.setID(rs.getInt("ID"));
                teach.setSubjectID(rs.getInt("SubjectID"));
                teach.setLecturerID(rs.getInt("LecturerID"));
                teach.setName(rs.getString("Name"));
                lstTeachInfo.add(teach);
            }
            return lstTeachInfo;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Teach getTeachInfoByID(int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_teach WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            Teach teach = new Teach();
            while (rs.next()) {
                teach.setID(rs.getInt("ID"));
                teach.setSubjectID(rs.getInt("SubjectID"));
                teach.setLecturerID(rs.getInt("LecturerID"));
                teach.setName(rs.getString("Name"));

            }
            return teach;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Teach getTeachInfoBySubjectID(int subjectID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_teach WHERE SubjectID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, subjectID);
            rs = ps.executeQuery();
            Teach teach = new Teach();
            while (rs.next()) {
                teach.setID(rs.getInt("ID"));
                teach.setSubjectID(rs.getInt("SubjectID"));
                teach.setLecturerID(rs.getInt("LecturerID"));
                teach.setName(rs.getString("Name"));
            }
            return teach;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Teach getTeachInfo(int subjectID, String className) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_teach WHERE SubjectID = ? AND Name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, subjectID);
            ps.setString(2, className);
            rs = ps.executeQuery();
            Teach teach = new Teach();
            if (rs.next()) {
                teach.setID(rs.getInt("ID"));
                teach.setSubjectID(rs.getInt("SubjectID"));
                teach.setLecturerID(rs.getInt("LecturerID"));
                teach.setName(rs.getString("Name"));
            }
            return teach;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public Teach getTeachInfoByYear(int ID, String year) {
//        ManageTeachDA manageTeachDA = new ManageTeachDA();
//        if (year.equals("")) {
//            Teach teach = manageTeachDA.getTeachInfoByID(ID);
//            return teach;
//        } else {
//            DataAccess da = new DataAccess();
//            Connection conn = da.getConnection();
//            PreparedStatement ps;
//            ResultSet rs;
//
//            String sql = "SELECT * FROM tbl_teach, tbl_subject "
//                    + "WHERE tbl_subject.ID = tbl_teach.SubjectID "
//                    + "AND tbl_teach.ID = ? AND Year = ?";
//            try {
//                ps = conn.prepareStatement(sql);
//                ps.setInt(1, ID);
//                ps.setString(2, year);
//                rs = ps.executeQuery();
//                Teach teach = new Teach();
//                while (rs.next()) {
//                    teach.setID(rs.getInt("ID"));
//                    teach.setSubjectID(rs.getInt("SubjectID"));
//                    teach.setLecturerID(rs.getInt("LecturerID"));
//                }
//                return teach;
//            } catch (SQLException ex) {
//                Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
//                return null;
//            }
//        }
//    }
    public boolean addTeachInfo(int subjectID, int lecturerID, String name) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "INSERT INTO tbl_teach "
                + "(SubjectID, LecturerID, Name)"
                + "VALUES (?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, subjectID);
            ps.setInt(2, lecturerID);
            ps.setString(3, name);

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateTeach(int subjectID, int lecturerID, String name, int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tbl_teach SET"
                + " SubjectID = ?, LecturerID = ?, Semester = ?, Year = ?, Name = ? WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, subjectID);
            ps.setInt(2, lecturerID);
            ps.setString(3, name);
            ps.setInt(4, ID);

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        ManageTeachDA manageTeach = new ManageTeachDA();
        Teach teach = manageTeach.getTeachInfoBySubjectID(1);
        System.out.println(teach.getName());

    }
}
