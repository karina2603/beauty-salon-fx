package com.example.beautysalonfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MastersViewController {

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button createRecord_button;

    @FXML
    private TableColumn<Master, Integer> idColumn;

    @FXML
    private Button listRecords_button;

    @FXML
    private TableColumn<Master, String> nameColumn;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private TableView<Master> tableMasters;

    @FXML
    void initialize() {

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeMasterTable(tableMasters, idColumn, nameColumn);

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
