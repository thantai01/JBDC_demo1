package model;

public class Account {
    private String userID;
    private String userPassword;

    public Account(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
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
}
