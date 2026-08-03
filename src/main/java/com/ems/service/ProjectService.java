package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Project;
import com.ems.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    // Get All Projects
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    // Get Project By ID
    public Optional<Project> getProjectById(Long id) {
        return repository.findById(id);
    }

    // Add Project
    public Project addProject(Project project) {
        return repository.save(project);
    }

    // Update Project
    public Project updateProject(Long id, Project project) {
        project.setId(id);
        return repository.save(project);
    }

    // Delete Project
    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
    public long getActiveProjectCount() {
        return repository.countByStatus("IN_PROGRESS");
    }
}