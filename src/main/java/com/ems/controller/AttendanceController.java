package com.ems.controller;

import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Attendance;
import com.ems.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    // Add Attendance
    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return service.addAttendance(attendance);
    }

    // Get All Attendance
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return service.getAllAttendance();
    }
    
    @GetMapping("/employee/{employeeName}")
    public List<Attendance> getAttendanceByEmployeeName(
            @PathVariable String employeeName) {

        return service.getAttendanceByEmployeeName(employeeName);
    }

    // Get Attendance By ID
    @GetMapping("/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable int id) {
        return service.getAttendanceById(id);
    }

    // Update Attendance
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable int id,
                                       @RequestBody Attendance attendance) {
        return service.updateAttendance(id, attendance);
    }

    // Delete Attendance
    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable int id) {
        service.deleteAttendance(id);
        return "Attendance Deleted Successfully";
    }
    
 // Dashboard - Today's Attendance
    @GetMapping("/today")
    public long getTodayAttendanceCount() {

        return service.getTodayAttendanceCount();

    }

    // Dashboard - Attendance Rate
    @GetMapping("/rate")
    public double getAttendanceRate() {

        return service.getAttendanceRate();

    }

    // Dashboard - Present Employees
    @GetMapping("/present-count")
    public long getPresentCount() {

        return service.getPresentCount();

    }

    // Dashboard - Attendance Trend
    @GetMapping("/trend")
    public List<Map<String, Object>> getAttendanceTrend() {

        return service.getAttendanceTrend();

    }
}