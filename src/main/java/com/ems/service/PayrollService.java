package com.ems.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Payroll;
import com.ems.repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository repository;

    // Add Payroll
    public Payroll addPayroll(Payroll payroll) {
        return repository.save(payroll);
    }

    // Get All Payrolls
    public List<Payroll> getAllPayrolls() {
        return repository.findAll();
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
                "payroll", 120000
        ));

        trend.add(Map.of(
                "month", "Feb",
                "payroll", 135000
        ));

        trend.add(Map.of(
                "month", "Mar",
                "payroll", 150000
        ));

        return trend;
    }

    // Payroll Totals
    public Map<String, Object> getPayrollTotals() {

        List<Payroll> payrolls = repository.findAll();

        double payroll = payrolls.stream()
                .mapToDouble(Payroll::getNetSalary)
                .sum();

        double avg = payrolls.stream()
                .mapToDouble(Payroll::getNetSalary)
                .average()
                .orElse(0);

        double bonus = payrolls.stream()
                .mapToDouble(Payroll::getBonus)
                .sum();

        Map<String, Object> result = new HashMap<>();

        result.put("monthlyPayroll", payroll);
        result.put("averageSalary", avg);
        result.put("bonusPool", bonus);
        result.put("headcount", repository.count());

        return result;
    }
}