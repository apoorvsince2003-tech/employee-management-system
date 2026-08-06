package com.ems.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Payroll;
import com.ems.repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Payroll
    public Payroll addPayroll(Payroll payroll) {
        return repository.save(payroll);
    }

    // Get All Payrolls
    public List<Payroll> getAllPayrolls() {

        List<Employee> employees = employeeRepository.findAll();

        List<Payroll> payrolls = new ArrayList<>();

        for (Employee e : employees) {

            Payroll p = new Payroll();

            p.setId(e.getId());

            p.setEmployeeName(e.getFirstName() + " " + e.getLastName());

            p.setBasicSalary(e.getSalary());

            p.setBonus(0);

            p.setDeduction(0);

            p.setNetSalary(e.getSalary());

            payrolls.add(p);
        }

        return payrolls;
    }

    // Get Payroll By ID
    public Optional<Payroll> getPayrollById(int id) {
        return repository.findById(id);
    }

    // Update Payroll
    public Payroll updatePayroll(int id, Payroll payroll) {

        Payroll existingPayroll = repository.findById(id).orElse(null);

        if (existingPayroll != null) {
            existingPayroll.setEmployeeName(payroll.getEmployeeName());
            existingPayroll.setBasicSalary(payroll.getBasicSalary());
            existingPayroll.setBonus(payroll.getBonus());
            existingPayroll.setDeduction(payroll.getDeduction());
            existingPayroll.setNetSalary(payroll.getNetSalary());

            return repository.save(existingPayroll);
        }

        return null;
    }

    // Delete Payroll
    public void deletePayroll(int id) {
        repository.deleteById(id);
    }

    // Payroll Trend
    public List<Map<String, Object>> getPayrollTrend() {

        List<Map<String, Object>> trend = new ArrayList<>();

        trend.add(Map.of(
        	    "month", "Jan",
        	    "total", 120000,
        	    "headcount", 10
        	));

        trend.add(Map.of(
        	    "month", "Feb",
        	    "total", 135000,
        	    "headcount", 10
        	));

        trend.add(Map.of(
        	    "month", "Mar",
        	    "total", 150000,
        	    "headcount", 10
        	));

        return trend;
    }

    // Payroll Totals
    public Map<String, Object> getPayrollTotals() {

        List<Employee> employees = employeeRepository.findAll();

        double payroll = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double avg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        Map<String, Object> result = new HashMap<>();

        result.put("monthlyPayroll", payroll);
        result.put("averageSalary", avg);
        result.put("bonusPool", 0);
        result.put("headcount", employees.size());

        return result;
    }
    
 // Salary Bands
    public List<Map<String, Object>> getSalaryBands() {

        List<Map<String, Object>> bands = new ArrayList<>();

        bands.add(Map.of(
                "band", "0-25K",
                "count", 5
        ));

        bands.add(Map.of(
                "band", "25K-50K",
                "count", 8
        ));

        bands.add(Map.of(
                "band", "50K-75K",
                "count", 4
        ));

        bands.add(Map.of(
                "band", "75K+",
                "count", 2
        ));

        return bands;
    }

    // Salary Revisions
    public List<Map<String, Object>> getSalaryRevisions() {

        List<Map<String, Object>> revisions = new ArrayList<>();

        Map<String, Object> r1 = new HashMap<>();
        r1.put("id", 1);
        r1.put("employeeName", "Rahul Sharma");
        r1.put("designation", "Java Developer");
        r1.put("departmentName", "IT");
        r1.put("type", "Increment");
        r1.put("previousSalary", 45000);
        r1.put("newSalary", 50000);
        r1.put("changeAmount", 5000);
        r1.put("changePercent", 11.11);
        r1.put("effectiveDate", "2026-08-01");
        r1.put("reason", "Annual Performance Review");

        revisions.add(r1);

        Map<String, Object> r2 = new HashMap<>();
        r2.put("id", 2);
        r2.put("employeeName", "Priya Singh");
        r2.put("designation", "HR Manager");
        r2.put("departmentName", "HR");
        r2.put("type", "Increment");
        r2.put("previousSalary", 60000);
        r2.put("newSalary", 65000);
        r2.put("changeAmount", 5000);
        r2.put("changePercent", 8.33);
        r2.put("effectiveDate", "2026-08-05");
        r2.put("reason", "Promotion");

        revisions.add(r2);

        return revisions;
    }
    
}