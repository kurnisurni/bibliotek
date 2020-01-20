package com.company;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private int id;
    private String password;
    private String userType;

    public User(String userName, int id, String password, String userType) {
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "User: " + userName + ", id=" + id + ", userType='" + userType;
    }
}
