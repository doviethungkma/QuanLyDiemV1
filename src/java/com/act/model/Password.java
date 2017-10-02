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
public class Password {
    private int pwdID;
    private String password;
    private String dateCreated;
    private String SALT;

    public Password() {
    }

    public Password(int pwdID, String password, String dateCreated, String SALT) {
        this.pwdID = pwdID;
        this.password = password;
        this.dateCreated = dateCreated;
        this.SALT = SALT;
    }

    public String getSALT() {
        return SALT;
    }

    public void setSALT(String SALT) {
        this.SALT = SALT;
    }

    public int getPwdID() {
        return pwdID;
    }

    public void setPwdID(int pwdID) {
        this.pwdID = pwdID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    
}
