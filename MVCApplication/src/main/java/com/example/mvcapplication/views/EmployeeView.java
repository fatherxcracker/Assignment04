package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Employee;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EmployeeView extends VBox {
    private final TableView<Employee> tableView;
    private final EmployeeController controller;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();

        Label searchLabel = new Label("First Name:");
        TextField searchTF = new TextField();
        Button searchButton = new Button("Search");

        HBox searchBox = new HBox();
        searchBox.getChildren().addAll(searchLabel, searchTF, searchButton);

        this.createTable();
        this.getChildren().addAll(searchBox, tableView);
        this.bindTableData();

        searchButton.setOnAction(buttonEvent -> {
            createTable();
            String firstNameInput = searchTF.getText();
            ArrayList<Employee> employeeArrayList = new ArrayList<>();

            for (int i = 0; i < tableView.getItems().size(); i++) {
                if (tableView.getItems().get(i).firstNameProperty().equals(firstNameInput));
            }
        });
    }

    private void createTable() {
        TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, salaryCol);
    }

    private void bindTableData() {
        tableView.setItems(controller.getEmployees());
    }
}