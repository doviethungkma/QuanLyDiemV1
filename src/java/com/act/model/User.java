/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.model;

/**
 *
 * @author shadyside
 */
public class User {

    private int loginID;
    private String username;
    private int pwdID;
    private int roleID;
    private String dateCreated;

    public User() {
    }

    public User(int loginID, String username, int pwdID, int roleID, String dateCreated) {
        this.loginID = loginID;
        this.username = username;
        this.pwdID = pwdID;
        this.roleID = roleID;
        this.dateCreated = dateCreated;
    }

    public int getPwdID() {
        return pwdID;
    }

    public void setPwdID(int pwdID) {
        this.pwdID = pwdID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

}
