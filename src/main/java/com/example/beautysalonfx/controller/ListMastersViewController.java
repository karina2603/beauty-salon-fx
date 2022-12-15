package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListMastersViewController {

    private ObservableList<Master> mastersData = FXCollections.observableArrayList();

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
    private TableColumn<Master, Integer> idColumn;

    @FXML
    private TableColumn<Master, String> nameColumn;

    @FXML
    private Button services_button;

    @FXML
    private TableView<Master> tableMasters;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            mastersData = databaseHandler.getMasters();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TableView.TableViewSelectionModel<Master> selectionModel = tableMasters.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Master>(){

            @Override
            public void changed(ObservableValue<? extends Master> observableValue, Master master, Master t1) {
                if(t1 != null) {
                    Master newMaster = (Master) t1;
                    Const idMaster =  new Const(newMaster.getId_master(), "master");
                }
            }
        });

        deleteMaster_button.setOnAction(event -> {


            System.out.println(Const.MASTER_ID);
            try {
                databaseHandler.deleteMaster(Const.MASTER_ID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<Master, Integer>("id_master"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Master, String>("name"));

        tableMasters.setItems(mastersData);

        addMaster_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addMasterView.fxml", addMaster_button);
        });

        addRecord_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addRecordView.fxml", addRecord_button);
        });

        addService_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/addServiceView.fxml", addService_button);
        });

        users_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listUsersView.fxml", users_button);
        });


        services_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listServicesView.fxml", services_button);
        });
    }

}
