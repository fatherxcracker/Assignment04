package com.example.mvcapplication.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        ObservableList<Department> departmentData = FXCollections.observableArrayList(
                new Department(1, "BrandCrowd"),
                new Department(2, "Sales Superstars"),
                new Department(3, "Tech Titans")
        );
        return departmentData;
    }
}
