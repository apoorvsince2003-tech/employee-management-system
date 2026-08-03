package com.ems.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Leave;
import com.ems.service.LeaveService;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveController {

    @Autowired
    private LeaveService service;

    // Add Leave
    @PostMapping
    public Leave addLeave(@RequestBody Leave leave) {
        return service.addLeave(leave);
    }

    // Get All Leaves
    @GetMapping
    public List<Leave> getAllLeaves(
            @RequestParam(required = false) Integer employeeId,
            @RequestParam(required = false) String status) {

        if (employeeId != null) {
            return service.getLeavesByEmployee(employeeId);
        }

        if (status != null) {
            return service.getPendingLeaves();
        }

        return service.getAllLeaves();
    }

    // Get Leave By ID
    @GetMapping("/{id}")
    public Optional<Leave> getLeaveById(@PathVariable int id) {
        return service.getLeaveById(id);
    }

    // Update Leave
    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable int id,
                             @RequestBody Leave leave) {
        return service.updateLeave(id, leave);
    }
    
    @GetMapping("/pending-count")
    public long getPendingCount() {
        return service.getPendingCount();
    }
    @GetMapping("/trend")
    public List<java.util.Map<String, Object>> getLeaveTrend() {
        return service.getLeaveTrend();
    }

    @GetMapping("/on-leave-count")
    public long getOnLeaveCount() {
        return service.getOnLeaveCount();
    }
    
    

    @PutMapping("/{id}/approve")
    public Leave approveLeave(@PathVariable int id) {
        return service.approveLeave(id);
    }

    @PutMapping("/{id}/reject")
    public Leave rejectLeave(@PathVariable int id) {
        return service.rejectLeave(id);
    }

    // Delete Leave
    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable int id) {
        service.deleteLeave(id);
        return "Leave Deleted Successfully";
    }
}