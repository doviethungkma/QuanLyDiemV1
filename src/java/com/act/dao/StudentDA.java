/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.ClassSV;
import com.act.model.Student;
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
public class StudentDA {

    public ArrayList<Student> getAllStudent() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Student> lstAllStudent = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setID(rs.getInt("ID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setAddress(rs.getString("Address"));
                student.setSex(rs.getString("Sex"));
                student.setAvatar(rs.getString("Avatar"));
                student.setClassID(rs.getInt("ClassID"));
                student.setLoginID(rs.getInt("LoginID"));
                lstAllStudent.add(student);
            }
            return lstAllStudent;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ClassSV getClassByID(int classID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_class WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, classID);
            rs = ps.executeQuery();
            ClassSV classSV = new ClassSV();
            if (rs.next()) {
                classSV.setID(classID);
                classSV.setClassName(rs.getString("ClassName"));
                classSV.setGrade(rs.getInt("Grade"));
                classSV.setKhoa(rs.getString("Khoa"));
                classSV.setIDGVCN(rs.getInt("IDGVCN"));
            }
            return classSV;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean addStudent(String studentName, String dateOfBirth, String address, String sex, String avatar, int classID, int loginID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "INSERT INTO tbl_student (StudentName, DateOfBirth, Address, Sex, Avatar, ClassID, LoginID) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setString(2, dateOfBirth);
            ps.setString(3, address);
            ps.setString(4, sex);
            ps.setString(5, avatar);
            ps.setInt(6, classID);
            ps.setInt(7, loginID);

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateStudentByID(int ID, String studentName, String dateOfBirth, String address, String sex, String avatar, int classID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "UPDATE tbl_student "
                + "SET StudentName = ?, DateOfBirth = ?, Address = ?, Sex = ?, Avatar = ?, ClassID = ? "
                + "WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setString(2, dateOfBirth);
            ps.setString(3, address);
            ps.setString(4, sex);
            ps.setString(5, avatar);
            ps.setInt(6, classID);
            ps.setInt(7, ID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteStudentByID(int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "DELETE FROM tbl_student WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Student getStudentByID(int ID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            Student student = new Student();
            if (rs.next()) {
                student.setID(rs.getInt("ID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setAddress(rs.getString("Address"));
                student.setSex(rs.getString("Sex"));
                student.setAvatar(rs.getString("Avatar"));
                student.setClassID(rs.getInt("ClassID"));
                student.setLoginID(rs.getInt("LoginID"));
            }
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Student getStudentByLoginID(int loginID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student WHERE LoginID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginID);
            rs = ps.executeQuery();
            Student student = new Student();
            if (rs.next()) {
                student.setID(rs.getInt("ID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setAddress(rs.getString("Address"));
                student.setSex(rs.getString("Sex"));
                student.setAvatar(rs.getString("Avatar"));
                student.setClassID(rs.getInt("ClassID"));
                student.setLoginID(rs.getInt("LoginID"));
            }
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Student> getStudentBySubjectClass(int teachID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student, tbl_result "
                + "WHERE tbl_student.ID = tbl_result.StudentID "
                + "AND TeachID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, teachID);
            rs = ps.executeQuery();
            ArrayList<Student> lstStudent = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setID(rs.getInt("ID"));
                student.setStudentName(rs.getString("StudentName"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setAddress(rs.getString("Address"));
                student.setSex(rs.getString("Sex"));
                student.setAvatar(rs.getString("Avatar"));
                student.setClassID(rs.getInt("ClassID"));
                student.setLoginID(rs.getInt("LoginID"));
                lstStudent.add(student);
            }
            return lstStudent;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static void main(String[] args) {
        StudentDA studentDA = new StudentDA();
//        ClassSV classSV = studentDA.getClassByID(1);
        ArrayList<Student> lstStudents = studentDA.getStudentBySubjectClass(26);
        for (Student lstStudent : lstStudents) {
            System.out.println(lstStudent.getStudentName());
        }
    }
}
