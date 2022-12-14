package com.example.beautysalonfx.configuration;

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
}
