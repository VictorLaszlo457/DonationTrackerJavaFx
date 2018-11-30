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

    @FXML protected void handleLoginButtonAction(ActionEvent event) throws IOException {
        //root allows access to the registration page when the method is access by clicking the reg. button
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginPage.fxml"));
        Scene scene = new Scene(root, 300, 275);

        //set the scene upon clicking the registration button
        Stage stage = (Stage) login.getScene().getWindow();
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


