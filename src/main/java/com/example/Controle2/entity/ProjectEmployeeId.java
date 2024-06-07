package com.example.Controle2.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class ProjectEmployeeId implements Serializable {
    private Long projectId;
    private Long employeeId;

    // Constructors, Getters, Setters, equals, and hashCode

    public ProjectEmployeeId() {}

    public ProjectEmployeeId(Long projectId, Long employeeId) {
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEmployeeId that = (ProjectEmployeeId) o;
        return projectId.equals(that.projectId) && employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, employeeId);
    }
}
