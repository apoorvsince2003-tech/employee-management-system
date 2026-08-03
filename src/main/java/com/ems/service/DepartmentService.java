package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    // Add Department
    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    // Get All Departments
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    // Get Department By ID
    public Optional<Department> getDepartmentById(int id) {
        return repository.findById(id);
    }

    // Update Department
 // Update Department
    public Department updateDepartment(int id, Department department) {

        Department existingDepartment = repository.findById(id).orElse(null);

        if (existingDepartment != null) {

            existingDepartment.setName(department.getName());
            existingDepartment.setCode(department.getCode());
            existingDepartment.setDescription(department.getDescription());
            existingDepartment.setHeadId(department.getHeadId());
            existingDepartment.setHeadName(department.getHeadName());
            existingDepartment.setEmployeeCount(department.getEmployeeCount());
            existingDepartment.setBudget(department.getBudget());
            existingDepartment.setEstablishedDate(department.getEstablishedDate());
            existingDepartment.setColor(department.getColor());

            return repository.save(existingDepartment);
        }

        return null;
    }

    // Delete Department
    public void deleteDepartment(int id) {
        repository.deleteById(id);
    }
    
    public List<Map<String, Object>> getDepartmentDistribution() {

        List<Department> departments = repository.findAll();

        List<Map<String, Object>> result = new ArrayList<>();

        for (Department d : departments) {

            Map<String, Object> item = new HashMap<>();

            item.put("name", d.getName());
            item.put("value", d.getEmployeeCount());

            result.add(item);
        }

        return result;
    }
}