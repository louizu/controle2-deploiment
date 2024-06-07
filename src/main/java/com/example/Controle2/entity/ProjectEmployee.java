package com.example.Controle2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ProjectEmployee {

    @EmbeddedId
    private ProjectEmployeeId id;

    @ManyToOne
    @JsonBackReference
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JsonBackReference
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private double implication; // Pourcentage d'implication

    // Getters et setters

    public ProjectEmployeeId getId() {
        return id;
    }

    public void setId(ProjectEmployeeId id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getImplication() {
        return implication;
    }

    public void setImplication(double implication) {
        this.implication = implication;
    }
}
