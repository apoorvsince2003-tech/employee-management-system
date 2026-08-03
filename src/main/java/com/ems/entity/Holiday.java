package com.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "holidays")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String holidayName;

    private String holidayDate;

    private String description;

    public Holiday() {
    }

    public Holiday(int id, String holidayName, String holidayDate, String description) {
        this.id = id;
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.description = description;
    }

    public Holiday(String holidayName, String holidayDate, String description) {
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}