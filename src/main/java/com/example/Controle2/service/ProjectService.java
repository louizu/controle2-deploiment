package com.example.Controle2.service;

import com.example.Controle2.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project findById(Long id);
}