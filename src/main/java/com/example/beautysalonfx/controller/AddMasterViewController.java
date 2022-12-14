package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddMasterViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addMaster_button;

    @FXML
    private Button addRecord_button;

    @FXML
    private Button addService_button;

    @FXML
    private TextField name_field;

    @FXML
    private Button seeListUsers_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<?> services_list;

    @FXML
    void initialize() {

        addRecord_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addRecordView.fxml", addRecord_button);
        });

        addService_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addServiceView.fxml", addService_button);
        });

        seeListUsers_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("listUsersView.fxml", seeListUsers_button);
        });
    }

}
