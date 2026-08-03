package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Activity;
import com.ems.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    // Add Activity
    public Activity addActivity(Activity activity) {
        return repository.save(activity);
    }

    // Get All Activities
    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    // Get Activity By ID
    public Optional<Activity> getActivityById(int id) {
        return repository.findById(id);
    }

    // Update Activity
    public Activity updateActivity(int id, Activity activity) {

        Activity existingActivity = repository.findById(id).orElse(null);

        if (existingActivity != null) {
            existingActivity.setTitle(activity.getTitle());
            existingActivity.setDescription(activity.getDescription());
            existingActivity.setActivityDate(activity.getActivityDate());

            return repository.save(existingActivity);
        }

        return null;
    }

    // Delete Activity
    public void deleteActivity(int id) {
        repository.deleteById(id);
    }
    
    public List<Activity> getRecentActivities() {
        return repository.findTop8ByOrderByActivityDateDesc();
    }
}