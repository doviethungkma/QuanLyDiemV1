/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import com.act.model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author shadyside
 */
public class UserDAO {

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public String hash(String password, String SALT) {
        try {
            String textHash = password + SALT;
            MessageDigest msDigest = MessageDigest.getInstance("SHA-256");
            msDigest.update(textHash.getBytes());
            byte[] result = msDigest.digest();
            return new UserDAO().bytesToHex(result);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int checkLogin(String username, String password) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM tbl_account where Username = ?";
        int pwdID = 0;
        int loginID = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                pwdID = rs.getInt("PwdID");
                loginID = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2 = "SELECT * FROM tbl_password WHERE ID = ?";
        try {
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, pwdID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String passHash = rs.getString("Password");
                String SALT = rs.getString("SALT");
                if (passHash.equals(new UserDAO().hash(password, SALT))) {
                    return loginID;
                } else {
                    return 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    

    public User getUserByID(int id) {
        DataAccess da = new DataAccess();
        User user = new User();
        try {
            Connection conn = da.getConnection();
            String sql = "SELECT ID, Username, PwdID\n"
                    + "FROM tbl_account \n"
                    + "WHERE ID = " + id + ";";

            ResultSet rs;
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                user.setLoginID(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setPwdID(rs.getInt("PwdID"));

            }
            da.close(conn, st, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return user;

    }

    //Chưa check----------------------------------------------------------------
    public boolean addUser(String username, String password) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO tbl_password (Password, DateCreated, SALT)"
                    + "VALUE (?, CURRENT_DATE, ?)";

            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            UserDAO userDAO = new UserDAO();
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(32);
            String SALT = userDAO.bytesToHex(salt);
            ps.setString(1, userDAO.hash(password, SALT));
            ps.setString(2, SALT);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int pwdID = rs.getInt(1);

            String sql2 = "INSERT INTO tbl_account (Username, PwdID, DateCreated)"
                    + "VALUE (?, ?, CURRENT_DATE)";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, username);
            ps.setInt(2, pwdID);
            ps.executeUpdate();
            conn.commit();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addRole(int loginID, int roleID) {
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int getUserIDFromUsername(String username) {
        DataAccess da = new DataAccess();
        Connection conn = da.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int userID;

        String sql = "SELECT ID FROM tbl_account WHERE Username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                userID = rs.getInt("ID");
                return userID;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
//
//    public static void main(String[] args) {
//        UserDAO manageUserDA = new UserDAO();
////        System.out.println(manageUserDA.checkLogin("NguyenTuanAnh", "Doviethung1995"));
////        System.out.println(manageUserDA.checkRole(2));
////        System.out.println(manageUserDA.addUser("DaoHuong", "Doviethung1995"));
//        System.out.println(manageUserDA.getUserIDFromUsername("DaoHuong"));
//    }
}
