package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeController {

    public EmployeeController() {

    }

    public ObservableList<Employee> getEmployees() {
        return Employee.getAllEmployees();
    }

}
