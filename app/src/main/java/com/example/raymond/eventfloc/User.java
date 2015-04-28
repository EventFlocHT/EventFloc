package com.example.raymond.eventfloc;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class User {

    private int userID;
    private String userEmail;
    private String password;

    public User() {
    }

    public User(String userEmail, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.userEmail = userEmail;
        //this.password = password; //encryption
        this.password = PasswordHash.createHash(password);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
