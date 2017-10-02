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
public class ClassSV {

    private int ID;
    private String className;
    private int grade;
    private String khoa;
    private int IDGVCN;

    public ClassSV() {
    }

    public ClassSV(int ID, String className, int grade, String khoa, int IDGVCN) {
        this.ID = ID;
        this.className = className;
        this.grade = grade;
        this.khoa = khoa;
        this.IDGVCN = IDGVCN;
    }

    public int getIDGVCN() {
        return IDGVCN;
    }

    public void setIDGVCN(int IDGVCN) {
        this.IDGVCN = IDGVCN;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

}
