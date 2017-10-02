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
public class Subject {

    private int ID;
    private String subjectName;
    private int numOfCredit;
    private int semester;
    private String year;

    public Subject() {
    }

    public Subject(int ID, String subjectName, int numOfCredit, int semester, String year) {
        this.ID = ID;
        this.subjectName = subjectName;
        this.numOfCredit = numOfCredit;
        this.semester = semester;
        this.year = year;
    }

    public int getNumOfCredit() {
        return numOfCredit;
    }

    public void setNumOfCredit(int numOfCredit) {
        this.numOfCredit = numOfCredit;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
