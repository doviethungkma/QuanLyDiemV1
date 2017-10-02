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
public class Mark {

    private int ID;
    private int teachID;
    private int lecturerID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public Mark() {
    }

    public Mark(int ID, int teachID, int lecturerID) {
        this.ID = ID;
        this.teachID = teachID;
        this.lecturerID = lecturerID;
    }

    public int getTeachID() {
        return teachID;
    }

    public void setTeachID(int teachID) {
        this.teachID = teachID;
    }

}
