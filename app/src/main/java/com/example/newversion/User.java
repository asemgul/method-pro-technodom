package com.example.newversion;

import com.google.gson.annotations.SerializedName;

public class User {

    private int userId;

    private long phone;

    private String password;

    private String newPassword;

    public User(int userId, long phone, String password, String newPassword) {
        this.userId = userId;
        this.phone = phone;
        this.password = password;
        this.newPassword=newPassword;
    }


}
