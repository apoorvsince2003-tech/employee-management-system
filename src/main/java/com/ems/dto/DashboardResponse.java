package com.ems.dto;

import java.util.List;

import com.ems.entity.Activity;
import com.ems.entity.Holiday;

public class DashboardResponse {

    private long totalEmployees;
    private long totalDepartments;
    private long totalAttendance;
    private long totalLeaves;
    private long totalPayroll;
    private long totalPromotions;

    private List<Holiday> holidays;
    private List<Activity> activities;

    public DashboardResponse() {
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(long totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public long getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(long totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public long getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(long totalLeaves) {
        this.totalLeaves = totalLeaves;
    }

    public long getTotalPayroll() {
        return totalPayroll;
    }

    public void setTotalPayroll(long totalPayroll) {
        this.totalPayroll = totalPayroll;
    }

    public long getTotalPromotions() {
        return totalPromotions;
    }

    public void setTotalPromotions(long totalPromotions) {
        this.totalPromotions = totalPromotions;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}