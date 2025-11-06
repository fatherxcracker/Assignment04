package com.example.mvcapplication.models;

import com.example.mvcapplication.database.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.*;
import java.sql.*;

public class Employee {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final DoubleProperty salary;
    private final IntegerProperty departmentId;

    public Employee(int id, String firstName, String lastName, double salary, int departmentId) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.salary = new SimpleDoubleProperty(salary);
        this.departmentId = new SimpleIntegerProperty(departmentId);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public static ObservableList<Employee> getAllEmployees() {
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();
        String query = "SELECT * FROM employee";

        try (Connection con = ConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double salary = rs.getDouble("salary");
                int departmentId = rs.getInt("departmentId");

                employeeData.add(new Employee(id, firstName, lastName, salary, departmentId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeData;
    }


}