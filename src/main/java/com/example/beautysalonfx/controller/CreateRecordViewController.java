package com.example.beautysalonfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class CreateRecordViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button findRecords_button;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<String> services_list;

    @FXML
    void initialize() {

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeServiceComboBox(services_list, "all");

        findRecords_button.setOnAction(event -> {
            Const service = new Const(services_list.getValue());
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/choiceRecordView.fxml", findRecords_button);
        });

        aboutUs_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/infoView.fxml", aboutUs_button);
        });

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

        listRecords_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listRecordsView.fxml", listRecords_button);
        });


    }

}
