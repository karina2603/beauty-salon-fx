package com.example.beautysalonfx.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.NumberTextField;
import com.example.beautysalonfx.animations.Shake;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddServiceViewController {

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
    private ComboBox<String> masters_list;

    @FXML
    private TextField nameService_field;

    @FXML
    private TextField requestRime_field;

    @FXML
    private Button seeListUsers_button;

    @FXML
    private Button services_button;

    @FXML
    void initialize() {

        initializeMasterComboBox();

        addService_button.setOnAction(event -> {

            if (validate(requestRime_field.getText().trim())) {

            } else {
                Shake shake = new Shake(requestRime_field);
                shake.playAnim();
            }

            if (validate(cost_field.getText().trim())) {
            } else {
                Shake shake = new Shake(cost_field);
                shake.playAnim();
            }

            if (validate(cost_field.getText().trim()) && validate(requestRime_field.getText().trim())) {
                DatabaseHandler databaseHandler = new DatabaseHandler();
                try {
                    databaseHandler.addService(nameService_field.getText().trim(), Double.parseDouble(requestRime_field.getText().trim()), Integer.parseInt(cost_field.getText()));
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

    private boolean validate(String text) {
        return text.matches("[0-9]*");
    }

}
