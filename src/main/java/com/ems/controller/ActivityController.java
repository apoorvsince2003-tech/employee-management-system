package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Activity;
import com.ems.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    @Autowired
    private ActivityService service;

    // Add Activity
    @PostMapping
    public Activity addActivity(@RequestBody Activity activity) {
        return service.addActivity(activity);
    }

    // Get All Activities
    @GetMapping
    public List<Activity> getAllActivities() {
        return service.getAllActivities();
    }
    
    
    
    @GetMapping("/recent")
    public List<Activity> getRecentActivities(
            @RequestParam(defaultValue = "8") int limit) {

        List<Activity> activities = service.getAllActivities();

        if (activities.size() <= limit) {
            return activities;
        }

        return activities.subList(0, limit);
    }

    // Get Activity By ID
    @GetMapping("/{id}")
    public Optional<Activity> getActivityById(@PathVariable int id) {
        return service.getActivityById(id);
    }

    // Update Activity
    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable int id,
                                   @RequestBody Activity activity) {
        return service.updateActivity(id, activity);
    }

    // Delete Activity
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable int id) {
        service.deleteActivity(id);
        return "Activity Deleted Successfully";
    }
}