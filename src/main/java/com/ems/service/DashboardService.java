package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.DashboardResponse;
import com.ems.repository.ActivityRepository;
import com.ems.repository.AttendanceRepository;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.HolidayRepository;
import com.ems.repository.LeaveRepository;
import com.ems.repository.PayrollRepository;
import com.ems.repository.PromotionRepository;

@Service
public class DashboardService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public DashboardResponse getDashboardData() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalEmployees(employeeRepository.count());
        response.setTotalDepartments(departmentRepository.count());
        response.setTotalAttendance(attendanceRepository.count());
        response.setTotalLeaves(leaveRepository.count());
        response.setTotalPayroll(payrollRepository.count());
        response.setTotalPromotions(promotionRepository.count());

        response.setHolidays(holidayRepository.findAll());
        response.setActivities(activityRepository.findAll());

        return response;
    }
}