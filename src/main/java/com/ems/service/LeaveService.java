package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Leave;
import com.ems.repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository repository;

    // Add Leave
    public Leave addLeave(Leave leave) {
        return repository.save(leave);
    }

    // Get All Leaves
    public List<Leave> getAllLeaves() {
        return repository.findAll();
    }

    // Get Leave By ID
    public Optional<Leave> getLeaveById(int id) {
        return repository.findById(id);
    }

    // Update Leave
    public Leave updateLeave(int id, Leave leave) {

        Leave existingLeave = repository.findById(id).orElse(null);

        if (existingLeave != null) {
            existingLeave.setEmployeeName(leave.getEmployeeName());
            existingLeave.setFromDate(leave.getFromDate());
            existingLeave.setToDate(leave.getToDate());
            existingLeave.setReason(leave.getReason());
            existingLeave.setStatus(leave.getStatus());

            return repository.save(existingLeave);
        }

        return null;
    }
    
    public Leave approveLeave(int id) {

        Leave leave = repository.findById(id).orElse(null);

        if (leave != null) {
            leave.setStatus("Approved");
            return repository.save(leave);
        }

        return null;
    }
    
    public Leave rejectLeave(int id) {

        Leave leave = repository.findById(id).orElse(null);

        if (leave != null) {
            leave.setStatus("Rejected");
            return repository.save(leave);
        }

        return null;
    }

    // Delete Leave
    public void deleteLeave(int id) {
        repository.deleteById(id);
    }
    
    public List<Leave> getLeavesByEmployee(Integer employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public List<Leave> getPendingLeaves() {
        return repository.findByStatus("Pending");
    }

    public long getPendingCount() {
        return repository.countByStatus("Pending");
    }

    public long getOnLeaveCount() {
        return repository.countByStatus("Approved");
    }
    
   
    
    public List<java.util.Map<String, Object>> getLeaveTrend() {

        List<java.util.Map<String, Object>> trend = new java.util.ArrayList<>();

        java.util.Map<String, Object> jan = new java.util.HashMap<>();
        jan.put("month", "Jan");
        jan.put("annual", 2);
        jan.put("sick", 1);
        jan.put("personal", 1);

        java.util.Map<String, Object> feb = new java.util.HashMap<>();
        feb.put("month", "Feb");
        feb.put("annual", 1);
        feb.put("sick", 2);
        feb.put("personal", 1);

        java.util.Map<String, Object> mar = new java.util.HashMap<>();
        mar.put("month", "Mar");
        mar.put("annual", 3);
        mar.put("sick", 1);
        mar.put("personal", 2);

        trend.add(jan);
        trend.add(feb);
        trend.add(mar);

        return trend;
    }
}