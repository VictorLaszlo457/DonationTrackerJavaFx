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
import sample.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


public class RegistrationActivity {
    public static String name = "";
    public static String password = "";
    public static String type = "";
    @FXML private TextField usernameField, passwordField;
    @FXML private Button cancel, register;
    @FXML private Text actiontarget;
    ObservableList<String> types = FXCollections.observableArrayList(
            "User", "Admin", "Location Employee", "Manager");



    private UserSet userSet = UserSet.getInstance();
    //setUserSet(UserSet.getInstance());

    /**
     * Sets the UserSet to be used by this activity
     * @param userSet an instance of UserModel
     */
    public void setUserSet(UserSet userSet) {
        this.userSet = userSet;
    }

    private Spinner<String> createStringSpinner() {
        //Spinner for user Type
//        ObservableList<String> types = FXCollections.observableArrayList(
//                "User", "Admin", "Location Employee", "Manager");

        final Spinner<String> spinner = new Spinner<>();

        //Value Factory
        SpinnerValueFactory<String> valueFactory =
                new SpinnerValueFactory.ListSpinnerValueFactory<>(types);

        //Default Value
        valueFactory.setValue("User");

        spinner.setValueFactory(valueFactory);

        type = spinner.getEditor().getText();

        System.out.println("type: " + type);
        return spinner;
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

    public void onRegistrationPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/Welcome.fxml"));
        name = usernameField.getText();
        password = passwordField.getText();
        type = createStringSpinner().getEditor().getText();
        System.out.println("username: " + name);
        System.out.println("password: " + password);

        /*--------------------------------------------*/
        FlowPane rootSpinner = new FlowPane();
        rootSpinner.setHgap(10);
        rootSpinner.setVgap(10);
        rootSpinner.setPadding(new Insets(10));

        //Scene scene = new Scene(root, 400, 200);

        //stage.setTitle("JavaFX Spinner (o7planning.org)");
        //stage.setScene(scene);
        //stage.show();

        //Spinner for user Type
//        ObservableList<String> types = FXCollections.observableArrayList(
//                "User", "Admin", "Location Employee", "Manager");
//
//        final Spinner<String> spinner = new Spinner<>();
//
//        //Value Factory
//        SpinnerValueFactory<String> valueFactory =
//                new SpinnerValueFactory.ListSpinnerValueFactory<>(types);
//        spinner.setValueFactory(valueFactory);
//
//        //Default Value
//        valueFactory.setValue("User");
//
//        spinner.setValueFactory(valueFactory);
//
//        type = spinner.getEditor().getText();
//
//        System.out.println("type: " + type);

        /*--------------------------------------------*/


        if (name.equals("") || password.equals("")) {
            name = "";
            password = "";
            actiontarget.setText("Please enter a username and password");
        }

        User newUser;

        if (type.equals("User")) {
            newUser = new User(password, name);
        } else if (type.equals("Location Employee")) {
            newUser = new LocationEmployee(password, name);
        } else if (type.equals("Admin")) {
            newUser = new Admin(password, name);
        } else {
            newUser = new Manager(password, name);
        }

        boolean found = false;

        for (User u : userSet.getUsers()) {
            if (userSet.getUsers().size() != 0) {
                if (u.getEmail().equals(newUser.getEmail())) {
                    found = true;
                    usernameField.setText("");
                    passwordField.setText("");
                    actiontarget.setText("User already exist in set");
                }
            }

        }

        if (!found) {
            userSet.addUser(newUser);
            Scene scene = new Scene(root, 300, 275);
            //root.getChildrenUnmodifiable().add(rootSpinner);
            Stage stage = (Stage) register.getScene().getWindow();
            //set the scene upon clicking the cancel button
            stage.setScene(scene);
            stage.show();
        }

        // Test loop that prints out all names in set to test if name was added.
        System.out.print("User Set Members: ");
        for (User u: userSet.getUsers()) {
            System.out.print(u.getEmail() + " ");
        }
    }

}
