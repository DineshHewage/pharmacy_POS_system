package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MainMenuController{

    @FXML
    private JFXButton btnBilling;

    @FXML
    private JFXButton btnGRN;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnReturn;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblWelcome;

    @FXML
    void btnBillingOnAction(ActionEvent event) {

    }

    @FXML
    void btnGRNOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

    public void setFirstName(String firstName) {
        lblWelcome.setText("Welcome " + firstName + "!");
    }
}
