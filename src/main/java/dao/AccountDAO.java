package dao;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DatabaseAccessObject<Account>{
    private static final String URL = "jdbc:mysql://localhost:3306/db_project1";
    private static final String userName = "root";
    private static final String userPassword = "12345a@A";


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
        PreparedStatement ps = connection.prepareStatement("SELECT account.user_name, account.user_password FROM db_project1.account");
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
        PreparedStatement ps = connection.prepareStatement("INSERT INTO account" + "(user_name,user_password) VALUES" + "(?, ?)");
        ps.setString(1, account.getUserID());
        ps.setString(2, account.getUserPassword());
        ps.executeUpdate();
    }

    @Override
    public Account select(int id) {
        return null;
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
