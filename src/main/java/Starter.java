import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is the main entry point of the JavaFX application.
 * JavaFX starts executing from this class.
 */
public class Starter extends Application {

    /**
     * Main method – Launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);// Calls JavaFX lifecycle and starts the app
    }

    /**
     * Called automatically by JavaFX once the application starts.
     * This method initializes the primary window (Stage) and loads the UI.
     */
    @Override
    public void start(Stage primaryStage) {

        try {
            // Load the Login UI from FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/LoginUI.fxml"));
            // Load the root layout from the FXML file
            Parent root = fxmlLoader.load();
            primaryStage.setTitle("Aloka Pharmacy");
            // Create Scene and assign UI to it
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(true);
            // Display the application window
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
