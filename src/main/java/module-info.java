module com.example.beautysalonfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.beautysalonfx to javafx.fxml;
    opens com.example.beautysalonfx.entity to javafx.fxml;
    opens com.example.beautysalonfx.controller to javafx.fxml;

    exports com.example.beautysalonfx;
    exports com.example.beautysalonfx.controller;
    exports com.example.beautysalonfx.entity;
}