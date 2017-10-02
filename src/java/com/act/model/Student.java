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
public class Student {
    private int ID;
    private String studentName;
    private String dateOfBirth;
    private String address;
    private String sex;
    private String avatar;
    private int classID;
    private int loginID;

    public Student() {
    }

    public Student(int ID, String studentName, String dateOfBirth, String address, String sex, String avatar, int classID, int loginID) {
        this.ID = ID;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.sex = sex;
        this.avatar = avatar;
        this.classID = classID;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
    
    
}
