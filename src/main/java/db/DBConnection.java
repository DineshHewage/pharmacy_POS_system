package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection conn;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aloka_pharmacy",
                "root",
                    "Dinesh@12345");
    }
    public static DBConnection getInstance() throws SQLException {
        return null==instance?instance=new DBConnection():instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
