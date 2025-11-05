package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.Project;
import javafx.collections.ObservableList;

public class ProjectController {

    public ProjectController() {
    }

    public ObservableList<Project> getProjects() { return Project.getAllProjects(); }
}