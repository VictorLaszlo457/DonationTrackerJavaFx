package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MainActivity {
    @FXML private Button login, logout;

    // Sign Out button
   @FXML protected void handleSignOutButtonAction(ActionEvent actionEvent) throws IOException {
        //If you hit the cancel button, return to the welcome page
        Parent root = FXMLLoader.load(getClass().getResource("../View/Welcome.fxml"));
        Scene scene = new Scene(root, 300, 275);
        Stage stage = (Stage) logout.getScene().getWindow();
        //set the scene upon clicking the cancel button
        stage.setScene(scene);
        stage.show();
    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException {
        //root allows access to the login page when the method is access by clicking the login button
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainActivity.fxml"));
        Scene scene = new Scene(root, 300, 275);
        Stage stage = (Stage) login.getScene().getWindow();

        //set the scene upon clicking the login button
        stage.setScene(scene);
        stage.show();
    }
}
