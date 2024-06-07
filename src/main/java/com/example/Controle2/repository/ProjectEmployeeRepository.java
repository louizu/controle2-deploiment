package com.example.Controle2.repository;



import com.example.Controle2.entity.ProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Long> {
    ProjectEmployee findByEmployeeIdAndProjectId(Long employeeId, Long projectId);
}
