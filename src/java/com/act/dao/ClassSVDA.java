
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.ClassSV;
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
public class ClassSVDA {

    public ClassSV getClassByClassName(String className) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_class WHERE ClassName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, className);
            rs = ps.executeQuery();
            ClassSV classSV = new ClassSV();
            if (rs.next()) {
                classSV.setID(rs.getInt("ID"));
                classSV.setIDGVCN(rs.getInt("IDGVCN"));
                classSV.setGrade(rs.getInt("Grade"));
                classSV.setKhoa(rs.getString("Khoa"));
            }
            return classSV;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<ClassSV> getAllClass() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_class";
        ArrayList<ClassSV> lstAllClass = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassSV classSV = new ClassSV();
                classSV.setID(rs.getInt("ID"));
                classSV.setIDGVCN(rs.getInt("IDGVCN"));
                classSV.setClassName(rs.getString("ClassName"));
                classSV.setGrade(rs.getInt("Grade"));
                classSV.setKhoa(rs.getString("Khoa"));
                lstAllClass.add(classSV);
            }
            return lstAllClass;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean updateClassByStudentID(int studentID, int classID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tbl_student SET ClassID = ? WHERE StudentID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(studentID, classID);
            ps.setInt(2, studentID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    //Chưa test
    public boolean updateClassByClassID(int classID, String className, int grade, String khoa, int IDGVCN) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tbl_class "
                + "SET ClassName = ?, Grade = ?, Khoa = ?, IDGVCN = ? "
                + "WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, className);
            ps.setInt(2, grade);
            ps.setString(3, khoa);
            ps.setInt(4, IDGVCN);
            ps.setInt(5, classID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
//    public static void main(String[] args) {
//        ClassSVDA classSVDA = new ClassSVDA();
//        System.out.println(classSVDA.updateClassByClassID(1, "AT10C", 9, "CNTT", 1));
//    }
}
