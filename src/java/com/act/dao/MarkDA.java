package com.act.dao;

import com.act.controller.ManagerAssignToMark;
import com.act.model.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shadyside
 */
public class MarkDA {

    public boolean assignMark(String subject, String className, int lecturerID) {
        try {
            DataAccess da = new DataAccess();
            Connection conn = da.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            int teachID = 0;
            String sql1 = "SELECT * FROM tbl_subject, tbl_teach "
                    + "WHERE tbl_teach.SubjectID = tbl_subject.ID "
                    + "AND tbl_subject.SubjectName = ? AND tbl_teach.Name = ?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, subject);
            ps.setString(2, className);
            rs = ps.executeQuery();
            if (rs.next()) {
                teachID = rs.getInt("tbl_teach.ID");
            }

            String sql = "INSERT INTO tbl_mark (TeachID, LecturerID) VALUES (?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, teachID);
                ps.setInt(2, lecturerID);
                if (ps.executeUpdate() > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarkDA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<Mark> getAllMark() {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_mark ORDER BY TeachID";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Mark> lstAllMark = new ArrayList<>();
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setID(rs.getInt("ID"));
                mark.setLecturerID(rs.getInt("LecturerID"));
                mark.setTeachID(rs.getInt("TeachID"));
                lstAllMark.add(mark);
            }
            return lstAllMark;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Mark> getMarkByLecturerID(int lecturerID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tbl_mark WHERE LecturerID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lecturerID);
            rs = ps.executeQuery();
            ArrayList<Mark> lstAllMark = new ArrayList<>();
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setID(rs.getInt("ID"));
                mark.setLecturerID(rs.getInt("LecturerID"));
                mark.setTeachID(rs.getInt("TeachID"));
                lstAllMark.add(mark);
            }
            return lstAllMark;
        } catch (SQLException ex) {
            Logger.getLogger(ClassSVDA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

//    public static void main(String[] args) {
//       MarkDA markDA = new MarkDA();
//        System.out.println(markDA.assignMark("Xây dựng ứng dụng web an toàn", "L02", 1));
//    }
}
