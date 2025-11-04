package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Department;
import com.example.mvcapplication.models.Employee;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
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
        Button projectButton = new Button("See Project");
        Button departmentButton = new Button("See Departments");

        searchBox.getChildren().addAll(searchLabel, searchTF, searchButton, projectButton, departmentButton);

        this.createTable();
        this.getChildren().addAll(searchBox, tableView);
        this.bindTableData();

        setupSearchButton(searchButton, searchTF);
        departmentButton.setOnAction(event -> openDepartmentWindow());
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

    private void openDepartmentWindow() {
        Stage departmentWindow = new Stage();
        departmentWindow.setTitle("Department Data");

        //Department Table
        TableView<Department> departmentTableView = new TableView<>();

        TableColumn<Department, Integer> idCol = new TableColumn<>("Department ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("departmentId"));

        TableColumn<Department, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("departmentName"));

        departmentTableView.getColumns().addAll(idCol, nameCol);

        //bind Department Table
        departmentTableView.setItems(controller.getDepartments());

        VBox vBox = new VBox(departmentTableView);
        Scene scene = new Scene(vBox, 400, 300);

        departmentWindow.setScene(scene);
        departmentWindow.showAndWait();
    }
}