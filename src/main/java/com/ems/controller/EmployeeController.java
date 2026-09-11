package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.AppUser;
import com.ems.entity.Employee;
import com.ems.repository.UserRepository;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private UserRepository userRepository;

    // Add Employee & Auto-Create Login Account
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("===============");
        System.out.println("POST HIT: Creating Employee");
        System.out.println(employee.getEmployeeCode());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getEmail());
        System.out.println("===============");

        if (employee.getStatus() == null || employee.getStatus().isEmpty()) {
            employee.setStatus("ACTIVE");
        }

        Employee saved = service.addEmployee(employee);

        // Auto-create login credentials in users table
        try {
            if (saved != null && saved.getEmail() != null) {
                if (userRepository.findByEmail(saved.getEmail()).isEmpty()) {
                    String passwordToSet = (saved.getPassword() != null && !saved.getPassword().trim().isEmpty())
                            ? saved.getPassword()
                            : (saved.getEmployeeCode() != null ? saved.getEmployeeCode() : "welcome123");

                    AppUser userAccount = new AppUser(
                            saved.getEmail(),
                            passwordToSet,
                            "EMPLOYEE",
                            (long) saved.getId()
                    );
                    userRepository.save(userAccount);
                    System.out.println(">>> User account created for: " + saved.getEmail() + " | Password: " + passwordToSet);
                }
            }
        } catch (Exception e) {
            System.err.println("Could not auto-create AppUser: " + e.getMessage());
        }

        return saved;
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }

    // Employee Statistics
    @GetMapping("/stats")
    public java.util.Map<String, Integer> getStats() {
        return service.getEmployeeStats();
    }

    // Employment Distribution
    @GetMapping("/employment-distribution")
    public java.util.List<java.util.Map<String, Object>> getEmploymentDistribution() {
        return service.getEmploymentDistribution();
    }
}