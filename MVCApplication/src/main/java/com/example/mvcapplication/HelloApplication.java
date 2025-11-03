package com.example.mvcapplication;

import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.views.EmployeeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        EmployeeController controller = new EmployeeController();
        EmployeeView view = new EmployeeView(controller);

        Scene scene = new Scene(view, 400, 300);

        stage.setTitle("Employee Table (MVC)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}