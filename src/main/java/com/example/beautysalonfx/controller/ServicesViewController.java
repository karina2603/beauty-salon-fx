package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ServicesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private TableColumn<Service, Integer> costColumn;

    @FXML
    private Button createRecord_button;

    @FXML
    private TableColumn<Service, Integer> idColumn;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private TableColumn<Service, String> nameColumn;

    @FXML
    private TableColumn<Service, Double> request_timeColumn;

    @FXML
    private Button schedule_button;

    @FXML
    private TableView<Service> tableServices;

    @FXML
    private Button logOut_button;

    @FXML
    void initialize() {

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeServiceTable(tableServices, idColumn, nameColumn, request_timeColumn, costColumn);

        aboutUs_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/infoView.fxml", aboutUs_button);
        });

        logOut_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();
            sceneHandler.openNewScene("/hello-view.fxml", logOut_button);
        });

        schedule_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/scheduleView.fxml", schedule_button);
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
