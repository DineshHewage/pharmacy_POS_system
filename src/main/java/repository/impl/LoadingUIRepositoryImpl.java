package repository.impl;

import db.DBConnection;
import model.dto.UserCredentils;
import repository.LoadingUIRepository;

import java.sql.*;

public class LoadingUIRepositoryImpl implements LoadingUIRepository {
    @Override
    public boolean userCredentialCheck(UserCredentils userCredentils) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstm  = connection.prepareStatement(query);
            pstm.setString(1, userCredentils.getUserName());
            pstm.setString(2, userCredentils.getPassword());
            ResultSet rs = pstm.executeQuery();
            return rs.next(); //  True if a matching user exists.

        } catch (SQLException e) {
            System.out.println("Error in userCredentialCheck: " + e.getMessage());
            return false;
        }
    }
}
