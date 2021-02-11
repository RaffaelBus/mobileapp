package com.example.mobileapplicationraffael.persistence;

import java.io.Serializable;

public class Credentials implements Serializable {
    //Credentials für Login
    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
