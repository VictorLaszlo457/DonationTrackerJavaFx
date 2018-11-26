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
import sample.Model.User;

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
import sample.Model.UserSet;


public class RegistrationActivity {
    public static String name = "";
    public static String password = "";
    public static String type = "";
    @FXML private TextField usernameField, passwordField, typeField;
    @FXML private Button cancel, register;
    @FXML private Text actiontarget;

    private UserSet userSet;
    //setUserSet(UserSet.getInstance());

    /**
     * Sets the UserSet to be used by this activity
     * @param userSet an instance of UserModel
     */
//    public void setUserSet(UserSet userSet) {
//        this.userSet = userSet;
//    }

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

    public void onRegistrationPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/Welcome.fxml"));
        name = usernameField.getText();
        password = passwordField.getText();
        type = typeField.getText();
        System.out.println("username: " + name);
        System.out.println("password: " + password);
        System.out.println("User type: " + type);

        if (name.equals("") || password.equals("")) {
            name = "";
            password = "";
            actiontarget.setText("Please enter a username and password");
        }
//        else if (!type.equalsIgnoreCase("Admin")
//                || !type.equalsIgnoreCase("User")
//                || !type.equalsIgnoreCase("Employee") ) {
//            type = "";
//            actiontarget.setText("User type must be Admin, User, or Employee");
//        }
        else {
            //userSet.addUser(name, password, type);
            Scene scene = new Scene(root, 300, 275);
            Stage stage = (Stage) register.getScene().getWindow();
            //set the scene upon clicking the cancel button
            stage.setScene(scene);
            stage.show();

        }
    }

}
