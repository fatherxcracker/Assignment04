package com.example.mvcapplication.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Project {
    private final IntegerProperty projectId;
    private final StringProperty projectName;

    public Project(int projectId, String projectName) {
        this.projectId = new SimpleIntegerProperty(projectId);
        this.projectName = new SimpleStringProperty(projectName);
    }

    public String getProjectName() {
        return projectName.get();
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public int getProjectId() {
        return projectId.get();
    }

    public IntegerProperty projectIdProperty() {
        return projectId;
    }

    public static ObservableList<Project> getAllProjects() {
        ObservableList<Project> projectData = FXCollections.observableArrayList(
                new Project(1, "Rising Phoenix"),
                new Project(2, "Quantum Leap"),
                new Project(3, "Alpha Ambition")
        );
        return projectData;
    }
}
