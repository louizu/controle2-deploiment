package com.example.Controle2.controller;

import com.example.Controle2.entity.Employee;
import com.example.Controle2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees.html";
    }

    @PostMapping("/removeEmployee")
    public String removeEmployeeFromProject(@RequestParam Long employeeId, @RequestParam Long projectId) {
        employeeService.removeEmployeeFromProject(employeeId, projectId);
        return "redirect:/employees";
    }
}
