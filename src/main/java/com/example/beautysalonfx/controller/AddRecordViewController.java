package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.DatabaseHandler;
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
    void initialize() {

        initializeServiceComboBox();
        initializeMasterComboBox();
        initializeTimeComboBox();

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

    private void initializeServiceComboBox() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            ObservableList<Service> services = databaseHandler.getServices();
            ObservableList<String> services_name = FXCollections.observableArrayList();
            for (Service service : services) {
                services_name.add(service.getName());
            }

            services_list.setItems(services_name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeMasterComboBox() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            ObservableList<Master> masters = databaseHandler.getMasters();
            ObservableList<String> masters_name = FXCollections.observableArrayList();
            for (Master master : masters) {
                masters_name.add(master.getName());
            }

            masters_list.setItems(masters_name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeTimeComboBox() {
        ObservableList<String> times = FXCollections.observableArrayList("10:00:00", "10:30:00", "11:00:00", "11:30:00",
                                                                              "12:00:00", "12:30:00", "13:00:00", "13:30:00",
                                                                              "14:00:00", "14:30:00", "15:00:00", "15:30:00",
                                                                              "16:00:00", "16:30:00", "17:00:00", "17:30:00",
                                                                              "18:00:00", "18:30:00", "19:00:00", "19:30:00");
        time_list.setItems(times);
        time_list.setValue("10:00:00");
    }

}
