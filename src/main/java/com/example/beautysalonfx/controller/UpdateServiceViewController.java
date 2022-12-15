package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.animations.Shake;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateServiceViewController {

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
    private TextField cost_field;

    @FXML
    private Button masters_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField requestTime_field;

    @FXML
    private Button services_button;

    @FXML
    private Button updateService_button;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        try {
            initializeFields();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateService_button.setOnAction(event -> {
            if (validate(requestTime_field.getText().trim())) {

            } else {
                Shake shake = new Shake(requestTime_field);
                shake.playAnim();
            }

            if (validate(cost_field.getText().trim())) {
            } else {
                Shake shake = new Shake(cost_field);
                shake.playAnim();
            }

            if (validate(cost_field.getText().trim()) && validate(requestTime_field.getText().trim())) {
                DatabaseHandler databaseHandler = new DatabaseHandler();

                try {
                    databaseHandler.updateService(name_field.getText(), Double.parseDouble(requestTime_field.getText()), Integer.parseInt(cost_field.getText()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        addMaster_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addMasterView.fxml", addMaster_button);
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
        Service service = databaseHandler.getService();

        name_field.setText(service.getName());
        requestTime_field.setText(String.valueOf(service.getRequest_time()));
        cost_field.setText(String.valueOf(service.getCost()));
    }

    private boolean validate(String text) {
        return text.matches("[0-9]*");
    }
}
