package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employee By ID
    public Optional<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }

    // Update Employee
 // Update Employee
    public Employee updateEmployee(int id, Employee employee) {

        Employee existingEmployee = repository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setEmployeeCode(employee.getEmployeeCode());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            existingEmployee.setDepartmentName(employee.getDepartmentName());
            existingEmployee.setDesignation(employee.getDesignation());
            existingEmployee.setEmploymentType(employee.getEmploymentType());
            existingEmployee.setStatus(employee.getStatus());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setJoinDate(employee.getJoinDate());
            existingEmployee.setLocation(employee.getLocation());
            existingEmployee.setManagerId(employee.getManagerId());
            existingEmployee.setManagerName(employee.getManagerName());

            return repository.save(existingEmployee);
        }

        return null;
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
 // Employee Statistics
    public java.util.Map<String, Integer> getEmployeeStats() {

        List<Employee> employees = repository.findAll();

        int total = employees.size();

        int active = (int) employees.stream()
                .filter(e -> "Active".equalsIgnoreCase(e.getStatus()))
                .count();

        int onLeave = (int) employees.stream()
                .filter(e -> "On Leave".equalsIgnoreCase(e.getStatus()))
                .count();

        int newJoiners = (int) employees.stream()
                .filter(e -> e.getJoinDate() != null && !e.getJoinDate().isEmpty())
                .count();

        java.util.Map<String, Integer> stats = new java.util.HashMap<>();
        stats.put("total", total);
        stats.put("active", active);
        stats.put("onLeave", onLeave);
        stats.put("newJoiners", newJoiners);

        return stats;
    }

    // Employment Distribution
    public java.util.List<java.util.Map<String, Object>> getEmploymentDistribution() {

        List<Employee> employees = repository.findAll();

        java.util.Map<String, Long> grouped = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        Employee::getEmploymentType,
                        java.util.stream.Collectors.counting()));

        java.util.List<java.util.Map<String, Object>> result = new java.util.ArrayList<>();

        grouped.forEach((type, count) -> {
            java.util.Map<String, Object> row = new java.util.HashMap<>();
            row.put("name", type);
            row.put("value", count);
            result.add(row);
        });

        return result;
    }
}