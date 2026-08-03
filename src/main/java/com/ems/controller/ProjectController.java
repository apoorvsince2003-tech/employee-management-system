package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Project;
import com.ems.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService service;

    // Get All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    // Get Project By ID
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return service.getProjectById(id);
    }

    // Add Project
    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return service.addProject(project);
    }

    // Update Project
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id,
                                 @RequestBody Project project) {
        return service.updateProject(id, project);
    }
    
    @GetMapping("/active-count")
    public long getActiveProjectCount() {
        return service.getActiveProjectCount();
    }

    // Delete Project
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
        return "Project Deleted Successfully";
    }
}