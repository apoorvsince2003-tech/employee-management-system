package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Notification;
import com.ems.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private NotificationService service;

    // Get all notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }

    // Get unread notification count
    @GetMapping("/unread-count")
    public long getUnreadCount() {
        return service.getUnreadCount();
    }

    // Add notification
    @PostMapping
    public Notification addNotification(@RequestBody Notification notification) {
        return service.addNotification(notification);
    }

    // Mark notification as read
    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable Integer id) {
        return service.markAsRead(id);
    }

    // Delete notification
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Integer id) {
        service.deleteNotification(id);
        return "Notification deleted successfully";
    }
}