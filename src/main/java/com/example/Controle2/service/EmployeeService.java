package com.example.Controle2.service;

import com.example.Controle2.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void assignEmployeeToProject(String employeeName, String projectName, double implication);
    List<Employee> getAllEmployees();
    void removeEmployeeFromProject(Long employeeId, Long projectId);
    List<Employee> getEmployeesByPost();
    Employee findById(Long id);
}