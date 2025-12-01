package repository.impl;

import db.DBConnection;
import model.dto.UserCredentils;
import repository.LoadingUIRepository;
import java.sql.*;

public class LoadingUIRepositoryImpl implements LoadingUIRepository {
    @Override
    public String userCredentialCheck(UserCredentils userCredentils) {

        try {
            // Get a connection from the DBConnection singleton
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT firstName FROM users WHERE username = ? AND password = ?";
            // Prepare the SQL statement to prevent SQL Injection
            PreparedStatement pstm  = connection.prepareStatement(query);
            // Set values for the placeholders
            // Index 1 → first '?' in the query (username)
            // Index 2 → second '?' in the query (password)
            pstm.setString(1, userCredentils.getUserName());
            pstm.setString(2, userCredentils.getPassword());
            // Execute the query; rs will contain matching rows (if any)
            ResultSet rs = pstm.executeQuery();
            // rs.next() returns true if at least one matching user exists
             if (rs.next()) {
                 return rs.getString("firstName");
             }
             return null;

        } catch (SQLException e) {
            System.out.println("Error in userCredentialCheck: " + e.getMessage());
            return null;
        }
    }
}
