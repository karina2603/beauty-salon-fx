package com.example.beautysalonfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signIn_button;

    @FXML
    private Button signUp_button;

    @FXML
    void initialize() {

        signIn_button.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();

            if(!loginText.equals("") && !passwordText.equals("")) {
                loginUser(loginText, passwordText);
            }
        });
        signUp_button.setOnAction(event -> {
            openNewScene("/signUp.fxml");
        });
    }

    private void openNewScene(String window) {
        signUp_button.getScene().getWindow().hide();


        URL fxmlLocation = getClass().getResource(window);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
//            loader.setLocation(getClass().getResource("resources/com.example.myfirstapp.signUp.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void loginUser(String loginText, String passwordText) {
    }

}
