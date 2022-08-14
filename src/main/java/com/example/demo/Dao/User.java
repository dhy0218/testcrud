package com.example.demo.Dao;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
@ApiModel("用户类")
public class User implements Serializable {

    private String username;
    private int password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
