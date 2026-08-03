package com.ems.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Notification;
import com.ems.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    // Get all notifications (latest first)
    public List<Notification> getAllNotifications() {
        return repository.findByOrderByTimestampDesc();
    }

    // Get unread notification count
    public long getUnreadCount() {
        return repository.countByReadFalse();
    }

    // Add notification
    public Notification addNotification(Notification notification) {

        if (notification.getTimestamp() == null) {
            notification.setTimestamp(LocalDateTime.now());
        }

        return repository.save(notification);
    }

    // Mark as Read
    public Notification markAsRead(Integer id) {

        Notification notification = repository.findById(id).orElse(null);

        if (notification != null) {
            notification.setRead(true);
            return repository.save(notification);
        }

        return null;
    }

    // Delete Notification
    public void deleteNotification(Integer id) {
        repository.deleteById(id);
    }
}