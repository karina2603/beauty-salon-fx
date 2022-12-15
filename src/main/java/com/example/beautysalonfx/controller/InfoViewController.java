package com.example.beautysalonfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class InfoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createRecord_button;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private TextArea textarea;

    @FXML
    void initialize() {
        schedule_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/scheduleView.fxml", schedule_button);
        });

        services_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/servicesView.fxml", services_button);
        });

        masters_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/mastersView.fxml", masters_button);
        });

        createRecord_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/createRecordView.fxml", createRecord_button);
        });

        listRecords_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listUserRecordsView.fxml", listRecords_button);
        });
    }
}
