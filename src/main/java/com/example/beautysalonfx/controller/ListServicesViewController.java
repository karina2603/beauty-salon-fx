package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListServicesViewController {

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
    private TableColumn<?, ?> costColumn;

    @FXML
    private Button deleteService_button;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private Button masters_button;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> request_timeColumn;

    @FXML
    private TableView<?> tableServices;

    @FXML
    private Button updateService_button;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {
        assert addMaster_button != null : "fx:id=\"addMaster_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert addRecord_button != null : "fx:id=\"addRecord_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert addService_button != null : "fx:id=\"addService_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert costColumn != null : "fx:id=\"costColumn\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert deleteService_button != null : "fx:id=\"deleteService_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert idColumn != null : "fx:id=\"idColumn\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert masters_button != null : "fx:id=\"masters_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert request_timeColumn != null : "fx:id=\"request_timeColumn\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert tableServices != null : "fx:id=\"tableServices\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert updateService_button != null : "fx:id=\"updateService_button\" was not injected: check your FXML file 'listServicesView.fxml'.";
        assert users_button != null : "fx:id=\"users_button\" was not injected: check your FXML file 'listServicesView.fxml'.";

    }

}
