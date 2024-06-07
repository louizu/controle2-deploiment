package com.example.Controle2.controller;


import com.example.Controle2.entity.Employee;
import com.example.Controle2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JSONController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeesByPost();
    }
}
