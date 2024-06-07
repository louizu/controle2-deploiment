package com.example.Controle2.controller;

import com.example.Controle2.entity.*;
import com.example.Controle2.service.EmployeeService;
import com.example.Controle2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class JSPController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/assignEmployee")
    public String showAssignEmployeeForm(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        return "assignEmployee.jsp";
    }

    @PostMapping("/assignEmployee")
    public String assignEmployeeToProject(@RequestParam Long employeeId, @RequestParam Long projectId, @RequestParam double implication) {
        Employee employee = employeeService.findById(employeeId);
        Project project = projectService.findById(projectId);
        if (employee != null && project != null) {
            employeeService.assignEmployeeToProject(employee.getName(), project.getName(), implication);
        }
        return "redirect:/employees";
    }
}

