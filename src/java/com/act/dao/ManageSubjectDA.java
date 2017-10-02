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
public class ManageSubjectDA {

    public Subject getSubjectByID(int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_subject WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            Subject subject = new Subject();

            if (rs.next()) {
                subject.setID(rs.getInt("ID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setNumOfCredit(rs.getInt("NumOfCredit"));
                subject.setSemester(rs.getInt("Semester"));
                subject.setYear(rs.getString("Year"));
            }
            return subject;
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturerDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean addSubject(String subjectName, int numOfCredit, int semester, String year) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "INSERT INTO tbl_subject SET SubjectName = ?, NumOfCredit = ?, Semester = ?, Year = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, subjectName);
            ps.setInt(2, numOfCredit);
            ps.setInt(3, semester);
            ps.setString(4, year);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageSubjectDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Subject getSubjectInfo(String subjectName) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_subject WHERE SubjectName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, subjectName);
            rs = ps.executeQuery();
            Subject subject = new Subject();
            if (rs.next()) {
                subject.setID(rs.getInt("ID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setNumOfCredit(rs.getInt("NumOfCredit"));
                subject.setSemester(rs.getInt("Semester"));
                subject.setYear(rs.getString("Year"));
            }
            return subject;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public Subject getSubjectInfo(String subjectName, String className) {
//        DataAccess da = new DataAccess();
//        Connection conn = da.getConnection();
//        PreparedStatement ps;
//        ResultSet rs;
//
//        String sql = "SELECT * FROM tbl_subject, tbl_teach WHERE "
//                + "tbl_subject.ID = tbl_teach.SubjectID "
//                + "AND tbl_subject.SubjectName = ? "
//                + "AND tbl_teach.Name = ?";
//        try {
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, subjectName);
//            ps.setString(2, className);
//            rs = ps.executeQuery();
//            Subject subject = new Subject();
//            if (rs.next()) {
//                subject.setID(rs.getInt("ID"));
//                subject.setSubjectName(rs.getString("SubjectName"));
//                subject.setNumOfCredit(rs.getInt("NumOfCredit"));
//                subject.setSemester(rs.getInt("Semester"));
//                subject.setYear(rs.getString("Year"));
//            }
//            return subject;
//        } catch (SQLException ex) {
//            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
    public ArrayList<Subject> getAllSubject() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_subject";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Subject> lstAllSubject = new ArrayList<>();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setID(rs.getInt("ID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setNumOfCredit(rs.getInt("NumOfCredit"));
                subject.setSemester(rs.getInt("Semester"));
                subject.setYear(rs.getString("Year"));
                lstAllSubject.add(subject);
            }
            return lstAllSubject;
        } catch (SQLException ex) {
            Logger.getLogger(ManageSubjectDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Teach> getSubjectByLecturer(int lecturerID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_teach, tbl_mark "
                + "WHERE tbl_mark.TeachID = tbl_teach.ID "
                + "AND tbl_mark.LecturerID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lecturerID);
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
            Logger.getLogger(ManageSubjectDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        ManageSubjectDA manageSubjectDA = new ManageSubjectDA();
        ArrayList<Teach> lstSubject = manageSubjectDA.getSubjectByLecturer(4);
        for (Teach teach : lstSubject) {
            System.out.println(teach.getID());
        }
    }
}
