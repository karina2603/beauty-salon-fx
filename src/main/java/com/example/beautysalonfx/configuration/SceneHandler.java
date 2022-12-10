package com.example.beautysalonfx.configuration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;

public class SceneHandler {
    public void openNewScene(String window, Button button) {
        //button.getScene().getWindow().hide();


        URL fxmlLocation = getClass().getResource(window);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
//            loader.setLocation(getClass().getResource("resources/com.example.myfirstapp.signUp.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
        button.getScene().setRoot(root);
    }
}
