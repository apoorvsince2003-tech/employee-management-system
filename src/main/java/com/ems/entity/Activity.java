package com.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private String activityDate;

    public Activity() {
    }

    public Activity(int id, String title, String description, String activityDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.activityDate = activityDate;
    }

    public Activity(String title, String description, String activityDate) {
        this.title = title;
        this.description = description;
        this.activityDate = activityDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }
}