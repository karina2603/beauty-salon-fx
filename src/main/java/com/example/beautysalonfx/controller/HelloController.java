package com.example.beautysalonfx.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.animations.Shake;
import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.User;
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
                try {
                    loginUser(loginText, passwordText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        signUp_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/signUp.fxml", signUp_button);
        });
    }

//    private void openNewScene(String window) {
//        //signUp_button.getScene().getWindow().hide();
//
//
//        URL fxmlLocation = getClass().getResource(window);
//        FXMLLoader loader = new FXMLLoader(fxmlLocation);
////            loader.setLocation(getClass().getResource("resources/com.example.myfirstapp.signUp.fxml"));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Parent root = loader.getRoot();
////        Stage stage = new Stage();
////        stage.setScene(new Scene(root));
////        stage.showAndWait();
//        signUp_button.getScene().setRoot(root);
//    }

    private void loginUser(String loginText, String passwordText) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);

        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (result.next()) {
            counter++;
            user.setRole(result.getString("role"));
            user.setEnabled(result.getInt("enabled"));
            Const user_id = new Const(result.getInt("id"), "user");
            break;
        }

        if (counter > 0 && user.getEnabled() == 1) {
            if (user.getRole().equals("user")) {
                SceneHandler sceneHandler = new SceneHandler();

                sceneHandler.openNewScene("/infoView.fxml", signIn_button);
            } else if (user.getRole().equals("admin")) {
                SceneHandler sceneHandler = new SceneHandler();

                sceneHandler.openNewScene("/adminView.fxml", signIn_button);
            }
        } else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

}
