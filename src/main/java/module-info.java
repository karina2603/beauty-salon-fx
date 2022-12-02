module com.example.beautysalonfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.beautysalonfx to javafx.fxml;
    exports com.example.beautysalonfx;
    exports com.example.beautysalonfx.controller;
    opens com.example.beautysalonfx.controller to javafx.fxml;
}