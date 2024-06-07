package com.example.Controle2.service.impl;

import com.example.Controle2.entity.*;
import com.example.Controle2.repository.EmployeeRepository;
import com.example.Controle2.repository.ProjectEmployeeRepository;
import com.example.Controle2.repository.ProjectRepository;
import com.example.Controle2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectEmployeeRepository projectEmployeeRepository;

    @Override
    @Transactional
    public void assignEmployeeToProject(String employeeName, String projectName, double implication) {
        Employee employee = employeeRepository.findByName(employeeName);
        Project project = projectRepository.findByName(projectName);

        if (employee != null && project != null) {
            ProjectEmployee projectEmployee = new ProjectEmployee();
            projectEmployee.setEmployee(employee);
            projectEmployee.setProject(project);
            projectEmployee.setImplication(implication);
            projectEmployee.setId(new ProjectEmployeeId(project.getId(), employee.getId()));

            projectEmployeeRepository.save(projectEmployee);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void removeEmployeeFromProject(Long employeeId, Long projectId) {
        ProjectEmployeeId id = new ProjectEmployeeId(projectId, employeeId);
        projectEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByPost() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .filter(e -> e.getPost() == Post.DEV || e.getPost() == Post.TEST || e.getPost() == Post.DEVOPS)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
