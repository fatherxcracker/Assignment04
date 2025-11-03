module com.example.mvcapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mvcapplication.models to javafx.fxml, javafx.base;
    exports com.example.mvcapplication;
}