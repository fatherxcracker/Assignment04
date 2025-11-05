package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.models.Department;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepartmentView extends Stage {

    private final DepartmentController controller;
    private final TableView<Department> tableView;

    public DepartmentView(DepartmentController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();

        setTitle("Department Table (MVC)");
        createTable();
        bindTableData();

        VBox vBox = new VBox(tableView);
        Scene scene = new Scene(vBox, 400, 300);

        setScene(scene);
    }

    private void createTable() {
        TableColumn<Department, Integer> idCol = new TableColumn<>("Department ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("departmentId"));

        TableColumn<Department, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("departmentName"));

        tableView.getColumns().addAll(idCol, nameCol);
    }

    private void bindTableData() {
        tableView.setItems(controller.getDepartments());
    }
}
