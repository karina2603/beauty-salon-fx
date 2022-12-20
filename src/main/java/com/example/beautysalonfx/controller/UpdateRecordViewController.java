package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.beautysalonfx.animations.Shake;
import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.InfoWorker;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Record;
import com.example.beautysalonfx.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateRecordViewController {

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
    private Button logOut_button;

    @FXML
    private Button masters_button;

    @FXML
    private ComboBox<String> masters_list;

    @FXML
    private Button records_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<String> services_list;

    @FXML
    private ComboBox<String> time_list;

    @FXML
    private Button updateRecord_button;

    @FXML
    private ComboBox<Long> userId_list;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        InfoWorker infoWorker = new InfoWorker();
        infoWorker.initializeServiceComboBox(services_list, "");
        infoWorker.initializeMasterComboBox(masters_list);
        infoWorker.initializeTimeComboBox(time_list);
        infoWorker.initializeUserIdComboBox(userId_list);

        try {
            initializeFields();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateRecord_button.setOnAction(event -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();

            try {
                if (String.valueOf(date_picker.getValue()).equals("")) {
                    Shake shake = new Shake(date_picker);
                    shake.playAnim();
                } else {
                    databaseHandler.updateRecord(services_list.getValue(), masters_list.getValue(), userId_list.getValue(),
                            time_list.getValue(), String.valueOf(date_picker.getValue()));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listRecordsView.fxml", updateRecord_button);
        });

        records_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listRecordsView.fxml", records_button);
        });

        addMaster_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addMasterView.fxml", addMaster_button);
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

    private void initializeFields() throws Exception {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Record record = databaseHandler.getRecord(Const.RECORD_ID);

        masters_list.setValue(record.getMaster_name());
        services_list.setValue(record.getService_name());
        time_list.setValue(record.getTime());
        userId_list.setValue((long) record.getUser_id());
    }

}
