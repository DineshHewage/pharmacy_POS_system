package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance; //1. Holds the single object(Sin)
    private Connection conn; //2. The actual DB connection.

//    Private constructor - prevents creating objects outside from this class.
    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aloka_pharmacy",
                "root",
                    "Dinesh@12345");
    }

//    Method to return the same instance every time.
    public static DBConnection getInstance() throws SQLException {
        return (instance == null) ? instance=new DBConnection() : instance;
    }

//    Allow other classes to use the single connection object.
    public Connection getConnection() {
        return conn;
    }
}
