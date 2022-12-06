package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListUsersViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button addMaster_button;

    @FXML
    private Button addRecord_button;

    @FXML
    private Button addService_button;

    @FXML
    private Button deleteUser_button;

    @FXML
    private Button masters_button;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private Button updateUser_button;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert addMaster_button != null : "fx:id=\"addMaster_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert addRecord_button != null : "fx:id=\"addRecord_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert addService_button != null : "fx:id=\"addService_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert deleteUser_button != null : "fx:id=\"deleteUser_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert schedule_button != null : "fx:id=\"schedule_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'listUsersView.fxml'.";
        assert updateUser_button != null : "fx:id=\"updateUser_button\" was not injected: check your FXML file 'listUsersView.fxml'.";

    }

}
