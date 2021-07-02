package model;

public class AccountInformation extends Account{
    private String userName;
    private String userDOB;
    private String userAddress;
    private String userImg;

    public AccountInformation(String userID, String userPassword, String userName, String userDOB, String userAddress, String userImg) {
        super(userID, userPassword);
        this.userName = userName;
        this.userDOB = userDOB;
        this.userAddress = userAddress;
        this.userImg = userImg;
    }

    public AccountInformation(String userName, String userDOB, String userAddress, String userImg) {
        this.userName = userName;
        this.userDOB = userDOB;
        this.userAddress = userAddress;
        this.userImg = userImg;
    }
    public AccountInformation() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
