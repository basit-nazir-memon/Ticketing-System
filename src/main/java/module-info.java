module com.example.sdaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.sdaproject to javafx.fxml;
    exports com.example.sdaproject;
}