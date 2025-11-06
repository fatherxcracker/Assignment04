package com.example.mvcapplication.models;

import com.example.mvcapplication.database.ConnectionManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class Department {
    private final IntegerProperty departmentId;
    private final StringProperty departmentName;

    public Department(int id, String name) {
        this.departmentId = new SimpleIntegerProperty(id);
        this.departmentName = new SimpleStringProperty(name);
    }

    public int getDepartmentId() {
        return departmentId.get();
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName.get();
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }

    public static ObservableList<Department> getAllDepartments() {
        ObservableList<Department> departmentData = FXCollections.observableArrayList();
        String query = "SELECT * FROM department";

        try (Connection con = ConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                departmentData.add(new Department(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentData;
    }
}
