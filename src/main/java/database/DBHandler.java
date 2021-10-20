package database;

import java.sql.*;

public class DBHandler {

    String connectionUrl = "jdbc:mysql://localhost:3306/shop";
    String user = "root";
    String pass = "password";

    private static Connection connection;

    public DBHandler() {
        try {
            connection = DriverManager.getConnection(connectionUrl, user, pass);

            System.out.println("Connection to database successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
