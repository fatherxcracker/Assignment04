package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Employee;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        setupSearchButton(searchButton, searchTF);
    }

    private void setupSearchButton(Button searchButton, TextField searchTF) {
        searchButton.setOnAction(event -> handleSearch(searchTF.getText()));
    }

    private void handleSearch(String firstNameInput) {
        if (firstNameInput == null || firstNameInput.isEmpty()) {
            bindTableData();
            return;
        }

        List<Employee> employeeList = controller.getEmployees();
        List<Employee> filteredList = employeeList.stream()
                .filter(e -> e.firstNameProperty().getValue().contains(firstNameInput))
                .toList();

        tableView.setItems(FXCollections.observableArrayList(filteredList));
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