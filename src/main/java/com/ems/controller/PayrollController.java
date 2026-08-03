package com.ems.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Payroll;
import com.ems.service.PayrollService;
import java.util.Map;
@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "*")
public class PayrollController {

    @Autowired
    private PayrollService service;

    // Add Payroll
    @PostMapping
    public Payroll addPayroll(@RequestBody Payroll payroll) {
        return service.addPayroll(payroll);
    }

    // Get All Payrolls
    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return service.getAllPayrolls();
    }

    // Get Payroll By ID
    @GetMapping("/{id}")
    public Optional<Payroll> getPayrollById(@PathVariable int id) {
        return service.getPayrollById(id);
    }
    @GetMapping("/trend")
    public List<Map<String, Object>> getTrend() {
        return service.getPayrollTrend();
    }

    @GetMapping("/totals")
    public Map<String, Object> getTotals() {
        return service.getPayrollTotals();
    }

    // Update Payroll
    @PutMapping("/{id}")
    public Payroll updatePayroll(@PathVariable int id,
                                 @RequestBody Payroll payroll) {
        return service.updatePayroll(id, payroll);
    }

    // Delete Payroll
    @DeleteMapping("/{id}")
    public String deletePayroll(@PathVariable int id) {
        service.deletePayroll(id);
        return "Payroll Deleted Successfully";
    }
}