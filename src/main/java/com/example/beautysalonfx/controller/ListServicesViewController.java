package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListServicesViewController {

    private ObservableList<Service> servicesData = FXCollections.observableArrayList();

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
    private TableColumn<Service, Integer> costColumn;

    @FXML
    private Button deleteService_button;

    @FXML
    private TableColumn<Service, Integer> idColumn;

    @FXML
    private Button masters_button;

    @FXML
    private TableColumn<Service, String> nameColumn;

    @FXML
    private TableColumn<Service, Double> request_timeColumn;

    @FXML
    private TableView<Service> tableServices;

    @FXML
    private Button updateService_button;

    @FXML
    private Button users_button;

    @FXML
    void initialize() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            servicesData = databaseHandler.getServices();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("id_service"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        request_timeColumn.setCellValueFactory(new PropertyValueFactory<Service, Double>("request_time"));
        costColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("cost"));

        tableServices.setItems(servicesData);

        TableView.TableViewSelectionModel<Service> selectionModel = tableServices.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Service>(){

            @Override
            public void changed(ObservableValue<? extends Service> observableValue, Service service, Service t1) {
                if(t1 != null) {
                    Service newService = (Service) t1;
                    Const idService =  new Const(newService.getId_service(), "service");
                }
            }
        });

        updateService_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/updateServiceView.fxml", updateService_button);
        });

        deleteService_button.setOnAction(event -> {


            System.out.println(Const.SERVICE_ID);
            try {
                databaseHandler.deleteService(Const.SERVICE_ID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

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

        masters_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listMastersView.fxml", masters_button);
        });


    }

}
