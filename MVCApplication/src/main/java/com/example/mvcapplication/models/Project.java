package com.example.mvcapplication.models;

import com.example.mvcapplication.database.ConnectionManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

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
        ObservableList<Project> projectData = FXCollections.observableArrayList();
        String query = "SELECT * FROM project";

        try (Connection con = ConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                projectData.add(new Project(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectData;
    }
}
