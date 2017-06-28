package com.hch.qewqs.firstclassexamforclass;

import java.io.Serializable;

/**
 * Created by qewqs on 2017-06-27.
 */

public class Personal_info implements Serializable{
    private String Name;
    private int PID;
    private String Phone;

    public Personal_info( ) {
        this.Name = "";
        this.PID = 0;
        this.Phone = "";
    }

    public Personal_info(String name, int PID, String phone) {
        this.Name = name;
        this.PID = PID;
        this.Phone = phone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public int getPID() {
        return PID;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAllData(){
        return this.Name + "\n" + this.PID + "\n" + this.Phone;
    }
}
