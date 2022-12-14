package com.example.beautysalonfx.controller;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListUserRecordsViewController {

    private ObservableList<Record> recordsData = FXCollections.observableArrayList();

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button createRecord_button;

    @FXML
    private TableColumn<Record, String> dateColumn;

    @FXML
    private TableColumn<Record, Integer> idColumn;

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
    private TableView<Record> tableUserRecords;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    void initialize() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {

            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            recordsData = databaseHandler.getUserRecords(Const.USER_ID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_record"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("service_name"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        name_masterColumn.setCellValueFactory(new PropertyValueFactory<>("master_name"));

        tableUserRecords.setItems(recordsData);

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
    }

//    private void openNewScene(String window, Button button) {
//        //button.getScene().getWindow().hide();
//
//
//        URL fxmlLocation = getClass().getResource(window);
//        FXMLLoader loader = new FXMLLoader(fxmlLocation);
////            loader.setLocation(getClass().getResource("resources/com.example.myfirstapp.signUp.fxml"));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Parent root = loader.getRoot();
////        Stage stage = new Stage();
////        stage.setScene(new Scene(root));
////        stage.showAndWait();
//        button.getScene().setRoot(root);
//    }
}
