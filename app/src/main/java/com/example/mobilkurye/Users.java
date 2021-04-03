package com.example.mobilkurye;

public class Users {
    String name, mail, phoneNo, password,username;


    public Users(){}

    public Users(String name, String mail, String phoneNo, String password,String username) {
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.password = password;
        this.username = username;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
