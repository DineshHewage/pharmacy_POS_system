package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dto.UserCredentils;
import service.LoadingUIService;
import service.impl.LoadingUIServiceImpl;

public class LoginUIController {

    LoadingUIService loadingUIService = new LoadingUIServiceImpl();

    @FXML
    private Label lblError;

    @FXML
    private Button loginButton;

    @FXML   
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        UserCredentils userCredentils = new UserCredentils(
                txtUsername.getText(),
                txtPassword.getText()
        );

        boolean isValidUser = loadingUIService.userRequest(userCredentils);
        if (isValidUser) {
            lblError.setVisible(false);
            // TODO: navigate to dashboard view
        }else {
            lblError.setText("Invalid username or password!");
            lblError.setVisible(true);
        }
    }
}

