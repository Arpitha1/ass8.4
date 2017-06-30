package com.example.abhi.intermediatealertdialog.model;


public class Details {

    private String name;
    private String phoneNumber;
    private String DOB;

    public Details() {
        // TODO Auto-generated constructor stub
    }

    public Details(String name, String phoneNumber, String dOB) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        DOB = dOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }



}




