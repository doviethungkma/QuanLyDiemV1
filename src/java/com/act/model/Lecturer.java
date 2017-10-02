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
public class Lecturer {

    private int ID;
    private String lecturerName;
    private String dateOfBirth;
    private String address;
    private String sex;
    private String avatar;
    private int loginID;

    public Lecturer() {
    }

    public Lecturer(int ID, String lecturerName, String dateOfBirth, String address, String sex, String avatar, int loginID) {
        this.ID = ID;
        this.lecturerName = lecturerName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.sex = sex;
        this.avatar = avatar;
        this.loginID = loginID;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
