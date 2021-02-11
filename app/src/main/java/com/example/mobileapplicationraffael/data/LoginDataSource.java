package com.example.mobileapplicationraffael.data;

import com.example.mobileapplicationraffael.data.model.LoggedInUser;
import com.example.mobileapplicationraffael.persistence.Benutzer;
import com.example.mobileapplicationraffael.persistence.Credentials;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        //Versucht den User einzuloggen
        try {
            Credentials c = Benutzer.readCredentials();
           if (c.getUsername().equals(username) && c.getPassword().equals(password))
            return new Result.Success<>(new LoggedInUser(username));
           else{
               return new Result.Error(new Exception("Wrong username or password."));
           }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }

    }

    public void logout() {

    }
}