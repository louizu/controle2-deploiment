package com.example.Controle2.repository;
import com.example.Controle2.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String projectName);
}
