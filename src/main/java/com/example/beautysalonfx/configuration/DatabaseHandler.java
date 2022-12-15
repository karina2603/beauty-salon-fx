package com.example.beautysalonfx.configuration;

import com.example.beautysalonfx.entity.Master;
import com.example.beautysalonfx.entity.Record;
import com.example.beautysalonfx.entity.Service;
import com.example.beautysalonfx.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHandler extends Configs{

    Connection dbConnection;

    public Connection getDbConnection()
            throws  ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost +
                ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }


    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_ROLE + "," + Const.USER_ENABLED +")" +
                "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, user.getLogin());
        prSt.setString(2, user.getPassword());
        prSt.setString(3, "user");
        prSt.setInt(4, 1);

        prSt.executeUpdate();
    }

    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, user.getLogin());
        prSt.setString(2, user.getPassword());



        resSet = prSt.executeQuery();

        return resSet;
    }

    public User getUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM Users " +
                        "WHERE id = " + id
        );
        ResultSet result = statement.executeQuery();
        User user = new User();
        while (result.next()) {
            user.setLogin(result.getString("username"));
            user.setRole(result.getString("role"));
            user.setEnabled(result.getInt("enabled"));
        }
        return user;
    }

    public ObservableList<Service> getServices() throws Exception {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement = conn.prepareStatement("" +
                    "SELECT * FROM Services ");
            ResultSet result = statement.executeQuery();

            ObservableList<Service> list = FXCollections.observableArrayList();
            while (result.next()) {
                Service service = new Service();
                service.setId_service(result.getInt("id_service"));
                service.setName(result.getString("name"));
                service.setRequest_time(result.getDouble("request_time"));
                service.setCost(result.getInt("cost"));

                list.add(service);
            }
            return list;

        } catch (Exception e)  {

        }
        return null;
    }

    public Service getService() throws Exception {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement = conn.prepareStatement("" +
                    "SELECT * FROM Services " +
                    "WHERE id_service = " + Const.SERVICE_ID);
            ResultSet result = statement.executeQuery();
            Service service = new Service();
            while (result.next()) {

                service.setId_service(result.getInt("id_service"));
                service.setName(result.getString("name"));
                service.setRequest_time(result.getDouble("request_time"));
                service.setCost(result.getInt("cost"));
                break;
            }
            return service;

        } catch (Exception e)  {

        }
        return null;
    }

    public ObservableList<Master> getMasters() {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement = conn.prepareStatement("" +
                    "SELECT * FROM Masters ");
            ResultSet result = statement.executeQuery();

            ObservableList<Master> list = FXCollections.observableArrayList();
            while (result.next()) {
                Master master = new Master();
                master.setId_master(result.getInt("id_master"));
                master.setName(result.getString("name"));

                list.add(master);
            }
            return list;

        } catch (Exception e)  {

        }
        return null;

    }

    public ObservableList<Record> getUserRecords(int id) {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement = conn.prepareStatement("" +
                    "SELECT id_record, service_name, master_name, date, time  FROM Records " +
                    "WHERE user_id = " + id);
            ResultSet result = statement.executeQuery();

            ObservableList<Record> list = FXCollections.observableArrayList();
            while (result.next()) {
                Record record = new Record();

                record.setService_name(result.getString("service_name"));

                record.setId_record(result.getInt("id_record"));

                record.setMaster_name(result.getString("master_name"));

                record.setDate(result.getString("date"));
                record.setTime(result.getString("time"));

                list.add(record);
            }
            return list;

        } catch (Exception e)  {

        }
        return null;
    }

    public ObservableList<User> getUsers() {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement = conn.prepareStatement("" +
                    "SELECT * FROM Users ");
            ResultSet result = statement.executeQuery();

            ObservableList<User> list = FXCollections.observableArrayList();
            while (result.next()) {
                User user = new User();

                user.setId(result.getLong("id"));
                user.setLogin(result.getString("username"));
                user.setRole(result.getString("role"));
                user.setEnabled(result.getInt("enabled"));

                list.add(user);
            }
            return list;

        } catch (Exception e)  {

        }
        return null;
    }

    public ObservableList<Record> getRecordsByName(String choice) {
        try {
            Connection conn = getDbConnection();
            PreparedStatement statement;
            ResultSet result;
            if (choice.equals("all")) {
                statement = conn.prepareStatement("" +
                        "SELECT * FROM Records " +
                        "WHERE status = 0");
                result = statement.executeQuery();
            } else {
                System.out.println(choice);
                statement = conn.prepareStatement("" +
                        "SELECT * FROM Records " +
                        "WHERE service_name = \'" + choice +
                        "\' AND status = 0");
                result = statement.executeQuery();
            }


            ObservableList<Record> list = FXCollections.observableArrayList();
            while (result.next()) {
                Record record = new Record();

                record.setId_record(result.getInt("id_record"));
                record.setMaster_name(result.getString("master_name"));
                record.setService_name(result.getString("service_name"));
                record.setDate(result.getString("date"));
                record.setTime(result.getString("time"));

                list.add(record);
            }
            return list;

        } catch (Exception e)  {

        }
        return null;
    }

    public void updateRecord(int id_record) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE Records " +
                        "SET status = 1, user_id = " + Const.USER_ID +
                        " WHERE id_record = " + id_record
        );
        int x = statement.executeUpdate();
//        System.out.println(x);
    }

    public void updateService(String name, double request_time, int cost) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE Services " +
                        "SET name = \'" + name + "\', request_time =" +
                        request_time + ", cost = " + cost +
                        " WHERE id_service = " + Const.SERVICE_ID
        );
        int x = statement.executeUpdate();
//        System.out.println(x);
    }

    public void updateUser(int id, String name, String role, int enabled) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE Users " +
                        "SET username = \'" + name + "\', role = \'" +
                        role + "\', enabled = " + enabled +
                        " WHERE id = " + id
        );
        int x = statement.executeUpdate();
//        System.out.println(x);
    }

    public void addMaster(String name) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "INSERT Masters (name) " +
                        "VALUES (\'" + name +
                        "\') "
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }

    public void addRecord (String service_name, String master_name, String date, String time) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "INSERT Records (service_name, master_name, date, time, status) " +
                        "VALUES (\'" + service_name + "\', \'" + master_name + "\', \'" +
                         date + "\', \'" + time +
                        "\', 0) "
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }

    public void addService(String name, double request_time, int cost) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "INSERT Services (name, request_time, cost) " +
                        "VALUES (\'" + name + "\', " + request_time + ", " + cost +
                        ") "
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }

    public void deleteMaster(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Masters " +
                        "WHERE id_master = " + id
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }

    public void deleteService(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Services " +
                        "WHERE id_service = " + id
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }

    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getDbConnection();
        PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Users " +
                        "WHERE id = " + id
        );
        int x = statement.executeUpdate();
        System.out.println(x);
    }
}
