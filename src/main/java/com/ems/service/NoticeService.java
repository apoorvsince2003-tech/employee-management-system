package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Notice;
import com.ems.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository repository;

    // Get All Notices
    public List<Notice> getAllNotices() {
        return repository.findAll();
    }

    // Get Notice By ID
    public Optional<Notice> getNoticeById(Long id) {
        return repository.findById(id);
    }

    // Add Notice
    public Notice addNotice(Notice notice) {
        return repository.save(notice);
    }

    // Update Notice
    public Notice updateNotice(Long id, Notice notice) {

        Notice existingNotice = repository.findById(id).orElse(null);

        if (existingNotice != null) {

            existingNotice.setTitle(notice.getTitle());
            existingNotice.setContent(notice.getContent());
            existingNotice.setCategory(notice.getCategory());
            existingNotice.setAuthor(notice.getAuthor());
            existingNotice.setPublishedDate(notice.getPublishedDate());
            existingNotice.setPriority(notice.getPriority());
            existingNotice.setPinned(notice.isPinned());

            return repository.save(existingNotice);
        }

        return null;
    }

    // Delete Notice
    public void deleteNotice(Long id) {
        repository.deleteById(id);
    }
}