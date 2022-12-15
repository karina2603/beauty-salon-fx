package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Service;
import com.example.beautysalonfx.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UpdateUserViewController {

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
    private ComboBox<String> enabled_box;

    @FXML
    private Button masters_button;

    @FXML
    private TextField name_field;

    @FXML
    private ComboBox<String> role_box;

    @FXML
    private Button services_button;

    @FXML
    private Button updateUser_button;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        initializeBox();
        try {
            initializeFields();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateUser_button.setOnAction(event -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();

            try {
                int enabled = 1;
                if (enabled_box.getValue().equals("block")) {
                    enabled = 0;
                }
                databaseHandler.updateUser(Const.WORK_USER_ID, name_field.getText(), role_box.getValue(), enabled);
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
        User user = databaseHandler.getUser(Const.WORK_USER_ID);

        name_field.setText(user.getLogin());
        if (user.getRole().equals("admin")) {
            role_box.setValue("admin");
        } else {
            role_box.setValue("user");
        }
        if (user.getEnabled() == 0) {
            enabled_box.setValue("block");
        } else {
            enabled_box.setValue("have access");
        }
    }

    private void initializeBox() {
        ObservableList<String> roles = FXCollections.observableArrayList("admin", "user");
        role_box.setItems(roles);
        ObservableList<String> access = FXCollections.observableArrayList("have access", "block");
        enabled_box.setItems(access);
    }


}
