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

public class LoginActivity {

    private String name;
    private String password;
    @FXML private TextField usernameField, passwordField;
    @FXML private Button cancel, login;
    @FXML private Text actiontarget;

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

    public void onLoginPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainActivity.fxml"));
        name = usernameField.getText();
        password = passwordField.getText();

        System.out.println("login username: " + name);
        System.out.println("login password: " + password);

        if (name.equals(RegistrationActivity.name) && password.equals(RegistrationActivity.password)) {
            Scene scene = new Scene(root, 300, 275);
            Stage stage = (Stage) login.getScene().getWindow();
            //set the scene upon clicking the cancel button
            stage.setScene(scene);
            stage.show();
        } else {
            actiontarget.setText("Username or Password is incorrect");
        }

    }
}
