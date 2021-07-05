package dao;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DatabaseAccessObject<Account>{
    private static final String SELECT_QUERY =  "SELECT account.user_name, account.user_password FROM db_project1.account";
    private static final String INSERT_QUERY_1 =  "INSERT INTO account" + "(user_name,user_password) VALUES" + "(?, ?)";
    private static final String INSERT_QUERY_2 =
            "INSERT INTO account" + "(user_name,user_password,fullname,dob,email,address,avatar,createdTime) VALUES" + "(?,?,?,?,?,?,?,?)";
    private static final String UPDATE_QUERY =
            "UPDATE  account SET user_password=?,fullname=?,dob=?,email=?,address=?,avatar=? WHERE user_name=?";
    private static final String DELETE_QUERY = "DELETE FROM account WHERE user_name = ?";
    private static final String SELECT_BY_USERNAME = "SELECT * FROM account WHERE user_name=? ";

    private Connection connection;

    {
        try {
            connection = MySQLConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public AccountDAO(){}

    @Override
    public List<Account> showAll() throws SQLException {
        List<Account> accountList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String userName = rs.getString("user_name");
            String userPassword = rs.getString("user_password");
            accountList.add(new Account(userName,userPassword));
        }
        return accountList;
    }

    @Override
    public void insert(Account account) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_1);
        ps.setString(1, account.getUserID());
        ps.setString(2, account.getUserPassword());
        ps.executeUpdate();
    }

//    public void getFullInfo(PreparedStatement ps, Account account) throws SQLException {
//        ps.setString(1, account.getUserID());
//        ps.setString(2, account.getUserPassword());
//        ps.setString(3, account.getFullName());
//        ps.setString(4, account.getDob());
//        ps.setString(5, account.getEmail());
//        ps.setString(6, account.getAddress());
//        ps.setString(7, account.getAvatar());
//        ps.setString(8, account.getCreatedTime());
//        ps.executeUpdate();
//    }

    public void insertFullInfo(Account account) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_2);
        ps.setString(1, account.getUserID());
        ps.setString(2, account.getUserPassword());
        ps.setString(3, account.getFullName());
        ps.setString(4, account.getDob());
        ps.setString(5, account.getEmail());
        ps.setString(6, account.getAddress());
        ps.setString(7, account.getAvatar());
        ps.setString(8, account.getCreatedTime());
        ps.executeUpdate();
    }

    @Override
    public Account select(String userName) throws SQLException {
        Account account = null;
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_USERNAME);
        ps.setString(1,userName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String user_name = rs.getString("user_name");
            String user_password = rs.getString("user_password");
            String user_fullName = rs.getString("fullname");
            String user_dob = rs.getString("dob");
            String user_email = rs.getString("email");
            String user_address = rs.getString("address");
            String user_avatar = rs.getString("avatar");
            String user_createdTime = rs.getString("createdTime");
            account = new Account(user_name,user_password,user_fullName,user_dob,user_email,user_address,user_avatar,user_createdTime);
        }
        return account;
    }

    @Override
    public boolean delete(String name) throws SQLException {
        boolean recordDelete;
        PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
        ps.setString(1,name);
        recordDelete = ps.executeUpdate()>0;
        return recordDelete;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        boolean updateRecord;
        PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
        ps.setString(1, account.getUserPassword());
        ps.setString(2, account.getFullName());
        ps.setString(3, account.getDob());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getAddress());
        ps.setString(6, account.getAvatar());
        ps.setString(7,account.getUserID());
        ps.executeUpdate();
        updateRecord = ps.executeUpdate()>0;
        return updateRecord;
    }

    public List<Account> accountSearch(String name) throws SQLException {
        List<Account> searchList  = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT user_name,user_password FROM account WHERE user_name=?");
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String user_name = rs.getString("user_name");
            String user_password = rs.getString("user_password");
            searchList.add(new Account(user_name,user_password));
        }
        return searchList;
    }
    public void printQLException(SQLException exception) {
        for(Throwable e:exception) {
            if(e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQL State:" + ((SQLException) e).getSQLState());
                System.err.println("Error Code:" +((SQLException) e).getErrorCode());
                System.err.println("Message:" + e.getMessage());
                Throwable t = exception.getCause();
                while (t!=null) {
                    System.out.println("Cause" + t);
                    t=t.getCause();
                }
            }
        }
    }
}
