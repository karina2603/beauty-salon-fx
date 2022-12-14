package com.example.beautysalonfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListMastersViewController {

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
    private Button deleteMaster_button;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button services_button;

    @FXML
    private TableView<?> tableMasters;

    @FXML
    private Button updateMaster_button;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {
        assert addMaster_button != null : "fx:id=\"addMaster_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert addRecord_button != null : "fx:id=\"addRecord_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert addService_button != null : "fx:id=\"addService_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert deleteMaster_button != null : "fx:id=\"deleteMaster_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert idColumn != null : "fx:id=\"idColumn\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert services_button != null : "fx:id=\"services_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert tableMasters != null : "fx:id=\"tableMasters\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert updateMaster_button != null : "fx:id=\"updateMaster_button\" was not injected: check your FXML file 'listMastersView.fxml'.";
        assert users_button != null : "fx:id=\"users_button\" was not injected: check your FXML file 'listMastersView.fxml'.";

    }

}
