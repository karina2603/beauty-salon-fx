package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class CreateRecordViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button createRecord_button;

    @FXML
    private DatePicker date_picker;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private ComboBox<?> masters_list;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private ComboBox<?> services_list;

    @FXML
    private ComboBox<?> time_list;

    @FXML
    void initialize() {
        assert aboutUs_button != null : "fx:id=\"aboutUs_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert createRecord_button != null : "fx:id=\"createRecord_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert date_picker != null : "fx:id=\"date_picker\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert listRecords_button != null : "fx:id=\"listRecords_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert masters_list != null : "fx:id=\"masters_list\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert schedule_button != null : "fx:id=\"schedule_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert services_list != null : "fx:id=\"services_list\" was not injected: check your FXML file 'createRecordView.fxml'.";
        assert time_list != null : "fx:id=\"time_list\" was not injected: check your FXML file 'createRecordView.fxml'.";

    }

}
