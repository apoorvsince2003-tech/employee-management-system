package com.ems.service;

import java.util.List;

import java.util.Optional;
import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Promotion;
import com.ems.repository.PromotionRepository;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;

    
 // Add Promotion
    public Promotion addPromotion(Promotion promotion) {
        return repository.save(promotion);
    }
    // Get All Promotions
    public List<Promotion> getAllPromotions() {
        return repository.findAll();
    }

    // Get Promotion By ID
    public Optional<Promotion> getPromotionById(int id) {
        return repository.findById(id);
    }

    // Update Promotion
    public Promotion updatePromotion(int id, Promotion promotion) {

        Promotion existingPromotion = repository.findById(id).orElse(null);

        if (existingPromotion != null) {
            existingPromotion.setEmployeeName(promotion.getEmployeeName());
            existingPromotion.setOldDesignation(promotion.getOldDesignation());
            existingPromotion.setNewDesignation(promotion.getNewDesignation());
            existingPromotion.setPromotionDate(promotion.getPromotionDate());

            return repository.save(existingPromotion);
        }

        return null;
    }

    // Delete Promotion
    public void deletePromotion(int id) {
        repository.deleteById(id);
    }
    
    public Promotion promoteEmployee(Promotion promotion) {
    	
    	System.out.println("Employee ID = " + promotion.getEmployeeId());

        Employee employee = employeeRepository.findById(promotion.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        System.out.println("Employee Found = " + employee.getFirstName());

        // Promotion record fill automatically
        promotion.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
        promotion.setDepartmentName(employee.getDepartmentName());
        promotion.setOldDesignation(employee.getDesignation());
        promotion.setOldSalary(employee.getSalary());

        // Salary Increase calculate
        promotion.setSalaryIncrease(
                promotion.getNewSalary() - employee.getSalary());

        // Update employee
        employee.setDesignation(promotion.getNewDesignation());
        employee.setSalary(promotion.getNewSalary());

        employeeRepository.save(employee);

        return repository.save(promotion);
    }
}