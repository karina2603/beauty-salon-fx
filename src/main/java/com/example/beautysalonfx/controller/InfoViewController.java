package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class InfoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createRecord_button;

    @FXML
    private Button listRecords_button;

    @FXML
    private Button masters_button;

    @FXML
    private Button schedule_button;

    @FXML
    private Button services_button;

    @FXML
    private TextArea textarea;

    @FXML
    void initialize() {
//        textarea.setStyle("-fx-control-inner-background: black;");
    }

}
