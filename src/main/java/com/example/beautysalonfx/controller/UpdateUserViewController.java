package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateUserViewController {

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
    private TextField enabled_field;

    @FXML
    private Button masters_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField role_field;

    @FXML
    private Button schedule_button;

    @FXML
    private Button seeListUsers_button;

    @FXML
    private Button services_button;

    @FXML
    private Button updateUser_button;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert addMaster_button != null : "fx:id=\"addMaster_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert addRecord_button != null : "fx:id=\"addRecord_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert addService_button != null : "fx:id=\"addService_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert enabled_field != null : "fx:id=\"enabled_field\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert name_field != null : "fx:id=\"name_field\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert role_field != null : "fx:id=\"role_field\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert schedule_button != null : "fx:id=\"schedule_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert seeListUsers_button != null : "fx:id=\"seeListUsers_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'updateUserView.fxml'.";
        assert updateUser_button != null : "fx:id=\"updateUser_button\" was not injected: check your FXML file 'updateUserView.fxml'.";

    }

}
