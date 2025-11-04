module com.example.mvcapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;


    opens com.example.mvcapplication.models to javafx.fxml, javafx.base;
    exports com.example.mvcapplication;
}