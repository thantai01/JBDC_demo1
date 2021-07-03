package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String userID;
    private String userPassword;
    private String fullName;
    private String dob;
    private String email;
    private String address;
    private String avatar;
    private String createdTime;

    public Account(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Account(String userID, String userPassword, String fullName, String dob, String email, String address, String avatar) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Account(String userID, String userPassword, String fullName, String dob, String email, String address, String avatar, String createdTime) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.createdTime = createdTime;
    }

    public Account() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
