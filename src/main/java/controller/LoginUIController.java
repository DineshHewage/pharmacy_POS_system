package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.UserCredentils;
import service.LoadingUIService;
import service.impl.LoadingUIServiceImpl;

import java.io.IOException;

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
    void loginButtonOnAction(ActionEvent event) throws IOException {

/*      * Calls the parameterized constructor
        * Creates a DTO object
        * Sets username & password inside i*/
        UserCredentils userCredentils = new UserCredentils(
                txtUsername.getText(),
                txtPassword.getText()
        );
/*        Passes the DTO to the service layer*/
        String firstName = loadingUIService.userRequest(userCredentils);
        if (firstName!=null) {
            // Find main menu UI file(FXML file) and prepare it to load.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/MainMenue.fxml"));
            /* Read the FXML file and create the whole UI in memory.
            * Now I have the main menu object stored inside load.
            * */
            Parent load = fxmlLoader.load();

            // Get the MainController instance
            MainMenuController controller = fxmlLoader.getController();

            // Send the first name into the main menu
            controller.setFirstName(firstName);
            
            // Retrieves the existing Stage to reuse it instead of opening a new window using txtUsername
            Stage stage = (Stage) txtUsername.getScene().getWindow();
            // Replacing the current Screen with existing window.
            stage.setScene(new Scene(load));
            stage.show();
        }else {
            lblError.setText("Invalid username or password!");
            lblError.setVisible(true);
        }
    }
}

