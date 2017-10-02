/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.Result;
import com.act.model.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadyside
 */
public class ResultDA {

    public ArrayList<Result> getResultByStudent(int studentID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_result WHERE StudentID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            ArrayList<Result> lstResults = new ArrayList<>();
            while (rs.next()) {
                Result result = new Result();
                result.setStudentID(studentID);
                result.setTeachID(rs.getInt("TeachID"));
                result.setScore1(rs.getInt("Score1"));
                result.setScore2(rs.getInt("Score2"));
                result.setScore3(rs.getInt("Score3"));
                lstResults.add(result);
            }
            return lstResults;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Result> getResultByStudent(int studentID, String year) {
        ResultDA resultDA = new ResultDA();
        ArrayList<Result> lstResults = new ArrayList<>();
        if (year.equals("")) {
            lstResults = resultDA.getResultByStudent(studentID);
            return lstResults;
        } else {
            DataAccess da = new DataAccess();
            Connection conn = da.getConnection();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM tbl_result, tbl_teach, tbl_student, tbl_subject "
                    + "WHERE tbl_result.TeachID = tbl_teach.ID "
                    + "AND tbl_result.StudentID = tbl_student.ID "
                    + "AND tbl_teach.SubjectID = tbl_subject.ID "
                    + "AND StudentID = ? AND tbl_subject.Year = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, studentID);
                ps.setString(2, year);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Result result = new Result();
                    result.setStudentID(studentID);
                    result.setTeachID(rs.getInt("TeachID"));
                    result.setScore1(rs.getInt("Score1"));
                    result.setScore2(rs.getInt("Score2"));
                    result.setScore3(rs.getInt("Score3"));
                    lstResults.add(result);
                }
                return lstResults;
            } catch (SQLException ex) {
                Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public ArrayList<Result> getResultByTeacher(int IDGVCN, String year, int subjectID, String className, int semester) {
        ArrayList<Result> lstResults = new ArrayList<>();

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student, tbl_teach, tbl_class, tbl_result, tbl_subject "
                + "WHERE tbl_student.ClassID = tbl_class.ID "
                + "AND tbl_subject.ID = tbl_teach.SubjectID "
                + "AND tbl_result.StudentID = tbl_student.ID "
                + "AND tbl_result.TeachID = tbl_teach.ID "
                + "AND tbl_subject.Year = ? AND tbl_subject.Semester = ? AND tbl_class.ClassName = ? "
                + "AND tbl_teach.SubjectID = ? AND tbl_class.IDGVCN = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ps.setInt(2, semester);
            ps.setString(3, className);
            ps.setInt(4, subjectID);
            ps.setInt(5, IDGVCN);
            rs = ps.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                result.setStudentID(rs.getInt("StudentID"));
                result.setTeachID(rs.getInt("TeachID"));
                result.setScore1(rs.getInt("Score1"));
                result.setScore2(rs.getInt("Score2"));
                result.setScore3(rs.getInt("Score3"));
                lstResults.add(result);
            }
            return lstResults;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Result> getResultByLecturer(int lecturerID, String year, int subjectID, String classSubjectName, int semester) {
        ArrayList<Result> lstResults = new ArrayList<>();

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_student, tbl_mark, tbl_result, tbl_lecturer, tbl_subject, tbl_teach "
                + "WHERE tbl_mark.LecturerID = tbl_lecturer.ID "
                + "AND tbl_mark.TeachID = tbl_Teach.ID "
                + "AND tbl_result.TeachID = tbl_teach.ID "
                + "AND tbl_result.StudentID = tbl_student.ID "
                + "AND tbl_teach.SubjectID = tbl_subject.ID "
                + "AND tbl_subject.Year = ? AND tbl_subject.Semester = ? "
                + "AND tbl_teach.Name = ? "
                + "AND tbl_teach.SubjectID = ? AND tbl_mark.LecturerID = ? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ps.setInt(2, semester);
            ps.setString(3, classSubjectName);
            ps.setInt(4, subjectID);
            ps.setInt(5, lecturerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                result.setStudentID(rs.getInt("StudentID"));
                result.setTeachID(rs.getInt("TeachID"));
                result.setScore1(rs.getInt("Score1"));
                result.setScore2(rs.getInt("Score2"));
                result.setScore3(rs.getInt("Score3"));
                lstResults.add(result);
            }
            return lstResults;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Result> getResultByManager(String year, int subjectID, String className) {
        ArrayList<Result> lstResults = new ArrayList<>();

        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_result, tbl_student, tbl_teach, tbl_class, tbl_subject "
                + "WHERE tbl_student.ClassID = tbl_class.ID "
                + "AND tbl_subject.ID = tbl_teach.SubjectID "
                + "AND tbl_result.TeachID = tbl_teach.ID "
                + "AND tbl_result.StudentID = tbl_student.ID "
                + "AND tbl_subject.Year = ? AND SubjectID = ? AND tbl_class.ClassName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ps.setInt(2, subjectID);
            ps.setString(3, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                Result result = new Result();
                result.setStudentID(rs.getInt("StudentID"));
                result.setTeachID(rs.getInt("TeachID"));
                result.setScore1(rs.getInt("Score1"));
                result.setScore2(rs.getInt("Score2"));
                result.setScore3(rs.getInt("Score3"));
                lstResults.add(result);
            }
            return lstResults;
        } catch (SQLException ex) {
            Logger.getLogger(ManageTeachDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public double tinhDiem(int score1, int score2, int score3) {

        double diemTB = ((0.3 * score1 + 0.7 * score2) * 0.3) + (score3 * 0.7);
        DecimalFormat df = new DecimalFormat("#.#");
        diemTB = Double.valueOf(df.format(diemTB));
        return diemTB;
    }

    public String diemHeChu(double diem) {
        String diemChu = "";
        if (diem < 4 && diem > 0) {
            return "F";
        } else if (diem < 5.5 && diem > 4) {
            return "D";
        } else if (diem < 7 && diem > 5.5) {
            return "C";
        } else if (diem < 8.5 && diem > 7) {
            return "B";
        } else {
            return "A";
        }
    }
//    public static void main(String[] args) {
//        ResultDA resultDA = new ResultDA();
////        ArrayList<Result> lst = resultDA.getResultByTeacher(1,"2017-2018", 1, "AT10C", 1);
//        ArrayList<Result> lst = resultDA.getResultByLecturer(4, "2017-2018", 1, "L01", 1);
//
//        for (Result result : lst) {
//            System.out.println(result.getScore1());
//        }
//    }

}
