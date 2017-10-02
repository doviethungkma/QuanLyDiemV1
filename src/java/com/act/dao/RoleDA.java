/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadyside
 */
public class RoleDA {

    public boolean addRoleByID(int loginID, int roleID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "INSERT INTO tbl_authorization (LoginID, RoleID) VALUES (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginID);
            ps.setInt(2, roleID);
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

    public String checkRole(int loginID) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int roleID = 0;
        String roleName = null;
        try {
            String sql = "SELECT RoleID FROM tbl_authorization WHERE LoginID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, loginID);
            rs = ps.executeQuery();
            if (rs.next()) {
                roleID = rs.getInt("RoleID");
            }

            String sql2 = "SELECT RoleName FROM tbl_role WHERE ID = ?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, roleID);
            rs = ps.executeQuery();
            if (rs.next()) {
                roleName = rs.getString("RoleName");
            }
            return roleName;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
