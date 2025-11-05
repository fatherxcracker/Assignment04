package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Project;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjectView extends Stage {

    private final ProjectController controller;
    private final TableView<Project> tableView;

    public ProjectView(ProjectController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();

        setTitle("Project Table (MVC)");
        createTable();
        bindTableData();

        VBox vBox = new VBox(tableView);
        Scene scene = new Scene(vBox, 400, 300);

        setScene(scene);
    }

    private void createTable() {
        TableColumn<Project, Integer> idCol = new TableColumn<>("Project ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("projectId"));

        TableColumn<Project, String> nameCol = new TableColumn<>("Project Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("projectName"));

        tableView.getColumns().addAll(idCol, nameCol);
    }

    private void bindTableData() {
        tableView.setItems(controller.getProjects());
    }
}
