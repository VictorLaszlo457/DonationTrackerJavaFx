package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class LoginActivity extends Application {
    @FXML private Text actiontarget;
    @FXML private Button registration, login;
    @FXML private Stage window;

    public LoginActivity() throws IOException {
    }

    //Temporary code to show button was pressed
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML protected void handleRegistrationButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginRegistrationView.fxml"));
        Scene scene = new Scene(root, 300, 275);
        Stage stage = (Stage) registration.getScene().getWindow();

        actiontarget.setText("Registration Pressed");
        stage.setScene(scene);
        stage.show();
    }

    //Code to draw the window with the chosen scene
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginRegistrationView.fxml"));
        Scene scene = new Scene(root, 300, 275);
        ScreenController screenController = new ScreenController(scene);

        screenController.addScreen("Login",
                FXMLLoader.load(getClass().getResource("../View/LoginRegistrationView.fxml")));
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


