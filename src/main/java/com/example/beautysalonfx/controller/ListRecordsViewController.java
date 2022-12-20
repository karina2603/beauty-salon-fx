package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListRecordsViewController {

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
    private TableColumn<Record, String> dateColumn;

    @FXML
    private Button deleteRecord_button;

    @FXML
    private TableColumn<Record, Integer> idColumn;

    @FXML
    private Button logOut_button;

    @FXML
    private TableColumn<Record, String> masterNameColumn;

    @FXML
    private Button masters_button;

    @FXML
    private Button services_button;

    @FXML
    private TableColumn<Record, String> serviceNameColumn;

    @FXML
    private TableColumn<Record, Integer> statusColumn;

    @FXML
    private TableView<Record> tableRecords;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    private Button updateRecord_button;

    @FXML
    private TableColumn<Record, Integer> userIdColumn;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeRecordTable(tableRecords, idColumn, serviceNameColumn, timeColumn,
                dateColumn, masterNameColumn, statusColumn, userIdColumn);

        infoWorker.getRecordRow(tableRecords);
        addMaster_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addMasterView.fxml", addMaster_button);
        });

        updateRecord_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/updateRecordView.fxml", updateRecord_button);
        });

        deleteRecord_button.setOnAction(event -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();

            System.out.println(Const.RECORD_ID);
            try {
                databaseHandler.deleteRecord(Const.RECORD_ID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listRecordsView.fxml", deleteRecord_button);
        });

        logOut_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();
            sceneHandler.openNewScene("/hello-view.fxml", logOut_button);
        });

        addRecord_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addRecordView.fxml", addRecord_button);
        });

        addService_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addServiceView.fxml", addService_button);
        });

        users_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listUsersView.fxml", users_button);
        });

        masters_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listMastersView.fxml", masters_button);
        });

        services_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listServicesView.fxml", services_button);
        });

    }

}
