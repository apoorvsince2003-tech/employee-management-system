package com.ems.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Attendance;
import com.ems.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    // Add Attendance
    public Attendance addAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    // Get All Attendance
    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    // Get Attendance By ID
    public Optional<Attendance> getAttendanceById(int id) {
        return repository.findById(id);
    }
    
    public List<Attendance> getAttendanceByEmployeeName(String employeeName) {
        return repository.findByEmployeeName(employeeName);
    }

    // Update Attendance
    public Attendance updateAttendance(int id, Attendance attendance) {

        Attendance existingAttendance = repository.findById(id).orElse(null);

        if (existingAttendance != null) {
            existingAttendance.setEmployeeName(attendance.getEmployeeName());
            existingAttendance.setDate(attendance.getDate());
            existingAttendance.setStatus(attendance.getStatus());

            return repository.save(existingAttendance);
        }

        return null;
    }

    // Delete Attendance
    public void deleteAttendance(int id) {
        repository.deleteById(id);
    }
    
 // Dashboard - Today's Attendance Count
    public long getTodayAttendanceCount() {

        String today = java.time.LocalDate.now().toString();

        return repository.countByDate(today);

    }

    // Dashboard - Present Employee Count
    public long getPresentCount() {

        return repository.countByStatus("Present");

    }

    // Dashboard - Attendance Percentage
    public double getAttendanceRate() {

        long total = repository.count();

        if (total == 0)
            return 0;

        long present = repository.countByStatus("Present");

        return (present * 100.0) / total;

    }

    // Dashboard - Attendance Trend
    public List<Map<String, Object>> getAttendanceTrend() {

        List<Object[]> rows = repository.getAttendanceTrend();

        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rows) {

            Map<String, Object> item = new HashMap<>();

            item.put("date", row[0]);

            item.put("count", row[1]);

            result.add(item);

        }

        return result;

    }
}