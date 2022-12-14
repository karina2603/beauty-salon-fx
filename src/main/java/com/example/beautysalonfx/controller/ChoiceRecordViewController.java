package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Record;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChoiceRecordViewController {

    private ObservableList<Record> recordsData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button addRecord_button;

    @FXML
    private Button createRecord_button;

    @FXML
    private TableColumn<Record, String> dateColumn;

    @FXML
    private TableColumn<Record, String> idColumn;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private TableColumn<Record, String> nameColumn;

    @FXML
    private TableColumn<Record, String> name_masterColumn;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private TableView<Record> tableRecords;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            recordsData = databaseHandler.getRecordsByName(Const.CHOOSEN_SERVICE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_record"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("service_name"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        name_masterColumn.setCellValueFactory(new PropertyValueFactory<>("master_name"));

        tableRecords.setItems(recordsData);

        TableView.TableViewSelectionModel<Record> selectionModel = tableRecords.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Record>() {
            @Override
            public void changed(ObservableValue<? extends Record> observableValue, Record record, Record t1) {
                if (t1 != null) {
                    Record newRecord = (Record) t1;
                    Const idRecord = new Const(newRecord.getId_record(), "record");

                }
            }
        });


        addRecord_button.setOnAction(event -> {
            try {
                databaseHandler.updateRecord(Const.RECORD_ID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

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