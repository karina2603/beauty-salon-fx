package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class AddRecordViewController {

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
    private DatePicker date_picker;

    @FXML
    private Button masters_button;

    @FXML
    private ComboBox<String> masters_list;

    @FXML
    private Button seeListUsers_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<String> services_list;

    @FXML
    private ComboBox<String> time_list;

    @FXML
    private Button logOut_button;

    @FXML
    private Button records_button;

    @FXML
    void initialize() {

        records_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listRecordsView.fxml", records_button);
        });

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeServiceComboBox(services_list, "");
        infoWorker.initializeMasterComboBox(masters_list);
        infoWorker.initializeTimeComboBox(time_list);

        addRecord_button.setOnAction(event -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            try {
                databaseHandler.addRecord(services_list.getValue(), masters_list.getValue(), date_picker.getValue().toString(), time_list.getValue());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        logOut_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();
            sceneHandler.openNewScene("/hello-view.fxml", logOut_button);
        });

        addMaster_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addMasterView.fxml", addMaster_button);
        });

        addService_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addServiceView.fxml", addService_button);
        });

        seeListUsers_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listUsersView.fxml", seeListUsers_button);
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
