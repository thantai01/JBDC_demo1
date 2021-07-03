package dao;

import model.Account;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DatabaseAccessObject<Account>{
    private static final String URL = "jdbc:mysql://localhost:3306/db_project1";
    private static final String userName = "root";
    private static final String userPassword = "12345a@A";

    private static final String SELECT_QUERY =  "SELECT account.user_name, account.user_password FROM db_project1.account";
    private static final String INSERT_QUERY_1 =  "INSERT INTO account" + "(user_name,user_password) VALUES" + "(?, ?)";
    private static final String INSERT_QUERY_2 =
            "INSERT INTO account" + "(user_name,user_password,fullname,dob,email,address,avatar,createdTime) VALUES" + "(?,?,?,?,?,?,?,?)";
    private static final String UPDATE_QUERY = "";
    private static final String DELETE_QUERY = "";
    private static final String SELECT_BY_USERNAME = "SELECT * FROM account WHERE user_name=? ";


    public AccountDAO(){}

    protected Connection getConnection () throws ClassNotFoundException, SQLException {
        Connection connection =null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL,userName,userPassword);
        return connection;
    }

    @Override
    public List<Account> showAll() throws SQLException, ClassNotFoundException {
        List<Account> accountList = new ArrayList<>();
        Connection connection = getConnection();
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
    public void insert(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_1);
        ps.setString(1, account.getUserID());
        ps.setString(2, account.getUserPassword());
        ps.executeUpdate();
    }
    public void insertFullInfo(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
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
    public Account select(String userName) throws SQLException, ClassNotFoundException {
        Account account = null;
        Connection connection = getConnection();
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
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Account account) throws SQLException {

        return false;
    }
}
