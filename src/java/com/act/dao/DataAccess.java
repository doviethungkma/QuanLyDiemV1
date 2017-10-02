/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shadyside
 */
public class DataAccess {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/quanlydiemv5?useUnicode=true&characterEncoding=utf-8";

    public Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_URL, "root", "");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
