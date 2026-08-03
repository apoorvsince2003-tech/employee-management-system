package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Notice;
import com.ems.service.NoticeService;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private NoticeService service;

    // Get All Notices
    @GetMapping
    public List<Notice> getAllNotices() {
        return service.getAllNotices();
    }

    // Get Notice By ID
    @GetMapping("/{id}")
    public Optional<Notice> getNoticeById(@PathVariable Long id) {
        return service.getNoticeById(id);
    }

    // Add Notice
    @PostMapping
    public Notice addNotice(@RequestBody Notice notice) {
        return service.addNotice(notice);
    }

    // Update Notice
    @PutMapping("/{id}")
    public Notice updateNotice(@PathVariable Long id,
                               @RequestBody Notice notice) {
        return service.updateNotice(id, notice);
    }

    // Delete Notice
    @DeleteMapping("/{id}")
    public String deleteNotice(@PathVariable Long id) {
        service.deleteNotice(id);
        return "Notice Deleted Successfully";
    }
}