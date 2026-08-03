package com.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeName;

    private String date;

    private String status;

    public Attendance() {
    }

    public Attendance(int id, String employeeName, String date, String status) {
        this.id = id;
        this.employeeName = employeeName;
        this.date = date;
        this.status = status;
    }

    public Attendance(String employeeName, String date, String status) {
        this.employeeName = employeeName;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}