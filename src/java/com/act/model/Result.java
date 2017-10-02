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
public class Result {

    private int teachID;
    private int studentID;
    private int score1;
    private int score2;
    private int score3;

    public Result() {
    }

    public Result(int teachID, int studentID, int score1, int score2, int score3) {
        this.teachID = teachID;
        this.studentID = studentID;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

  
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getTeachID() {
        return teachID;
    }

    public void setTeachID(int teachID) {
        this.teachID = teachID;
    }

}
