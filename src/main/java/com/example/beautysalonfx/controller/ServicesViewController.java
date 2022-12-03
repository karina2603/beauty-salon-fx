package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ServicesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button createRecord_button;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private Button schedule_button;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'servicesView.fxml'.";
        assert createRecord_button != null : "fx:id=\"createRecord_button\" was not injected: check your FXML file 'servicesView.fxml'.";
        assert listRecords_button != null : "fx:id=\"listRecords_button\" was not injected: check your FXML file 'servicesView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'servicesView.fxml'.";
        assert schedule_button != null : "fx:id=\"schedule_button\" was not injected: check your FXML file 'servicesView.fxml'.";

    }

}
