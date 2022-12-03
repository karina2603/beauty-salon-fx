package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ScheduleViewController {

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
    private Button services_button;

    @FXML
    private TextArea textarea;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'scheduleView.fxml'.";
        assert createRecord_button != null : "fx:id=\"createRecord_button\" was not injected: check your FXML file 'scheduleView.fxml'.";
        assert listRecords_button != null : "fx:id=\"listRecords_button\" was not injected: check your FXML file 'scheduleView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'scheduleView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'scheduleView.fxml'.";
        assert textarea != null : "fx:id=\"textarea\" was not injected: check your FXML file 'scheduleView.fxml'.";

    }

}
