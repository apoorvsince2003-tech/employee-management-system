package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Department;
import com.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // Add Department
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    // Get All Departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }
    
    @GetMapping("/distribution")
    public List<java.util.Map<String, Object>> getDepartmentDistribution() {
        return service.getDepartmentDistribution();
    }

    // Get Department By ID
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable int id) {
        return service.getDepartmentById(id);
    }

    // Update Department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id,
                                       @RequestBody Department department) {
        return service.updateDepartment(id, department);
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        service.deleteDepartment(id);
        return "Department Deleted Successfully";
    }
}