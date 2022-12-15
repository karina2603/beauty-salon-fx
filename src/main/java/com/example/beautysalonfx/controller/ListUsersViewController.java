package com.example.beautysalonfx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.beautysalonfx.configuration.Const;
import com.example.beautysalonfx.configuration.DatabaseHandler;
import com.example.beautysalonfx.configuration.SceneHandler;
import com.example.beautysalonfx.entity.Record;
import com.example.beautysalonfx.entity.Service;
import com.example.beautysalonfx.entity.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListUsersViewController {

    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private Button aboutUs_button;

    @FXML
    private Button addMaster_button;

    @FXML
    private Button addRecord_button;

    @FXML
    private Button addService_button;

    @FXML
    private Button deleteUser_button;

    @FXML
    private TableColumn<User, Integer> enabledColumn;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private Button masters_button;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private Button services_button;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private Button updateUser_button;

    @FXML
    void initialize() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {

            usersData = databaseHandler.getUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        enabledColumn.setCellValueFactory(new PropertyValueFactory<>("enabled"));

        tableUsers.setItems(usersData);

        TableView.TableViewSelectionModel<User> selectionModel = tableUsers.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<User>(){

            @Override
            public void changed(ObservableValue<? extends User> observableValue, User service, User t1) {
                if(t1 != null) {
                    User user = (User) t1;
                    Const id = new Const(Integer.parseInt(String.valueOf(user.getId())), "workuser");
                }
            }
        });

        deleteUser_button.setOnAction(event -> {
            try {
                databaseHandler.deleteUser(Const.WORK_USER_ID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        updateUser_button.setOnAction(event -> {

            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/updateUserView.fxml", updateUser_button);
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

        masters_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listMastersView.fxml", masters_button);
        });

        services_button.setOnAction(event -> {
            SceneHandler sceneHandler = new SceneHandler();

            sceneHandler.openNewScene("/listServicesView.fxml", services_button);
        });
    }

}
