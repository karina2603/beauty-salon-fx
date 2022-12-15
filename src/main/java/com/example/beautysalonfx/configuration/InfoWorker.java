package com.example.beautysalonfx.configuration;

import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Record;
import com.example.beautysalonfx.entity.Service;
import com.example.beautysalonfx.entity.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InfoWorker {
    public void initializeServiceComboBox(ComboBox<String> services_list, String choice) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            ObservableList<Service> services = databaseHandler.getServices();
            ObservableList<String> services_name = FXCollections.observableArrayList();
            for (Service service : services) {
                services_name.add(service.getName());
            }
            if (choice.equals("all")) {
                services_name.add("all");
                services_list.setValue("all");
            }

            services_list.setItems(services_name);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return services_list;
    }

    public void initializeMasterComboBox(ComboBox<String> masters_list) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            ObservableList<Master> masters = databaseHandler.getMasters();
            ObservableList<String> masters_name = FXCollections.observableArrayList();
            for (Master master : masters) {
                masters_name.add(master.getName());
            }

            masters_list.setItems(masters_name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void initializeTimeComboBox(ComboBox<String> time_list) {
        ObservableList<String> times = FXCollections.observableArrayList("10:00:00", "10:30:00", "11:00:00", "11:30:00",
                "12:00:00", "12:30:00", "13:00:00", "13:30:00",
                "14:00:00", "14:30:00", "15:00:00", "15:30:00",
                "16:00:00", "16:30:00", "17:00:00", "17:30:00",
                "18:00:00", "18:30:00", "19:00:00", "19:30:00");
        time_list.setItems(times);
        time_list.setValue("10:00:00");
    }

    public void initializeRecordsTableByService(TableView<Record> tableRecords, TableColumn<Record, String> idColumn,
                                       TableColumn<Record, String> nameColumn, TableColumn<Record, String> timeColumn,
                                       TableColumn<Record, String> dateColumn, TableColumn<Record, String> name_masterColumn) {
        ObservableList<Record> recordsData = FXCollections.observableArrayList();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            recordsData = databaseHandler.getRecordsByName(Const.CHOOSEN_SERVICE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_record"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("service_name"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        name_masterColumn.setCellValueFactory(new PropertyValueFactory<>("master_name"));

        tableRecords.setItems(recordsData);
    }

    public void initializeRecordTableByUser(TableView<Record> tableUserRecords, TableColumn<Record, Integer> idColumn,
                                            TableColumn<Record, String> nameColumn, TableColumn<Record, String> timeColumn,
                                            TableColumn<Record, String> dateColumn, TableColumn<Record, String> name_masterColumn) {
        ObservableList<Record> recordsData = FXCollections.observableArrayList();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            recordsData = databaseHandler.getUserRecords(Const.USER_ID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_record"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("service_name"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        name_masterColumn.setCellValueFactory(new PropertyValueFactory<>("master_name"));

        tableUserRecords.setItems(recordsData);
    }

    public void initializeMasterTable(TableView<Master> tableMasters, TableColumn<Master, Integer> idColumn,
                                      TableColumn<Master, String> nameColumn) {
        ObservableList<Master> mastersData = FXCollections.observableArrayList();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            mastersData = databaseHandler.getMasters();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<Master, Integer>("id_master"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Master, String>("name"));

        tableMasters.setItems(mastersData);
    }

    public void initializeServiceTable(TableView<Service> tableServices, TableColumn<Service, Integer> idColumn,
                                       TableColumn<Service, String> nameColumn, TableColumn<Service, Double> request_timeColumn,
                                       TableColumn<Service, Integer> costColumn) {
        ObservableList<Service> servicesData = FXCollections.observableArrayList();
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
    }

    public void initializeUserTable(TableView<User> tableUsers, TableColumn<User, Integer> idColumn,
                                    TableColumn<User, String> nameColumn, TableColumn<User, String> roleColumn,
                                    TableColumn<User, Integer> enabledColumn) {
        ObservableList<User> usersData = FXCollections.observableArrayList();
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
    }

    public void getRecordRow(TableView<Record> tableRecords) {
        TableView.TableViewSelectionModel<Record> selectionModel = tableRecords.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Record>() {
            @Override
            public void changed(ObservableValue<? extends Record> observableValue, Record record, Record t1) {
                if (t1 != null) {
                    Record newRecord = (Record) t1;
                    Const idRecord = new Const(newRecord.getId_record(), "record");
                    System.out.println(Const.RECORD_ID);
                }
            }
        });
    }

    public void getMasterRow(TableView<Master> tableMasters) {
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
    }

    public void getServiceRow(TableView<Service> tableServices) {
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
    }

    public void getUserRow(TableView<User> tableUsers) {
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
    }
}
