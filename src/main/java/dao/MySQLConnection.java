package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_project1";
    private static final String userName = "root";
    private static final String userPassword = "12345a@A";

    protected static Connection getConnection () throws ClassNotFoundException, SQLException {
        Connection connection =null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL,userName,userPassword);
        return connection;
    }
}
