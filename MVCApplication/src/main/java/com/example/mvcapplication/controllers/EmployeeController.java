package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.Department;
import com.example.mvcapplication.models.Employee;
import com.example.mvcapplication.views.DepartmentView;
import com.example.mvcapplication.views.ProjectView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeController {

    public EmployeeController() {

    }

    public ObservableList<Employee> getEmployees() {
        return Employee.getAllEmployees();
    }

    public void openDepartmentWindow() {
        new DepartmentView(new DepartmentController()).show();
    }

    public void openProjectWindow() {
        new ProjectView(new ProjectController()).show();
    }

}
