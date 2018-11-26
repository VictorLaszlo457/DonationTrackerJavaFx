package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

import javafx.scene.control.Button;

public class WelcomeActivity extends Application {
    @FXML private Text actiontarget;
    @FXML private Button registration, login, cancel;

    //Temporary code to show button was pressed
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        //root allows access to the login page when the method is access by clicking the login button
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginPage.fxml"));
        Scene scene = new Scene(root, 300, 275);
        Stage stage = (Stage) login.getScene().getWindow();

        //set the scene upon clicking the login button
        stage.setScene(scene);
        stage.show();
    }

    //Code to handle the registration button being pressed
    @FXML protected void handleRegistrationButtonAction(ActionEvent event) throws IOException {
        //root allows access to the registration page when the method is access by clicking the reg. button
        Parent root = FXMLLoader.load(getClass().getResource("../View/RegistrationPage.fxml"));
        Scene scene = new Scene(root, 300, 275);

        //set the scene upon clicking the registration button
        Stage stage = (Stage) registration.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Cancel button
    @FXML protected void handleCancelButtonAction(ActionEvent event) throws IOException {
        //If you hit the cancel button, return to the welcome page
        Parent root = FXMLLoader.load(getClass().getResource("../View/Welcome.fxml"));
        Scene scene = new Scene(root, 300, 275);
        Stage stage = (Stage) cancel.getScene().getWindow();
        //set the scene upon clicking the cancel button
        stage.setScene(scene);
        stage.show();
    }

    //Start the GUI and display the first screen
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Set the screen to the start window (the welcome screen)
        Parent root = FXMLLoader.load(getClass().getResource("../View/Welcome.fxml"));
        Scene scene = new Scene(root, 300, 275);
        ScreenController screenController = new ScreenController(scene);

        screenController.addScreen("Welcome",
                FXMLLoader.load(getClass().getResource("../View/Welcome.fxml")));

        //Screen currently being accessed
        screenController.activate("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Launches the window
    public static void main(String[] args) {
        launch(args);
    }
}


