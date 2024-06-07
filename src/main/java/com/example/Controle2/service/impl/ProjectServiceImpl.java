package com.example.Controle2.service.impl;

import com.example.Controle2.entity.Project;
import com.example.Controle2.repository.ProjectRepository;
import com.example.Controle2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
