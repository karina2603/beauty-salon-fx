package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
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
    private Button aboutUs_button;

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
    private ComboBox<?> masters_list;

    @FXML
    private TextField requestRime_field;

    @FXML
    private Button schedule_button;

    @FXML
    private Button seeListUsers_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<?> services_list;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert addMaster_button != null : "fx:id=\"addMaster_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert addRecord_button != null : "fx:id=\"addRecord_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert addService_button != null : "fx:id=\"addService_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert cost_field != null : "fx:id=\"cost_field\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert masters_list != null : "fx:id=\"masters_list\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert requestRime_field != null : "fx:id=\"requestRime_field\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert schedule_button != null : "fx:id=\"schedule_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert seeListUsers_button != null : "fx:id=\"seeListUsers_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'addServiceView.fxml'.";
        assert services_list != null : "fx:id=\"services_list\" was not injected: check your FXML file 'addServiceView.fxml'.";

    }

}
