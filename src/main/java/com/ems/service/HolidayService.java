package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Holiday;
import com.ems.repository.HolidayRepository;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository repository;

    // Add Holiday
    public Holiday addHoliday(Holiday holiday) {
        return repository.save(holiday);
    }

    // Get All Holidays
    public List<Holiday> getAllHolidays() {
        return repository.findAll();
    }

    // Get Holiday By ID
    public Optional<Holiday> getHolidayById(int id) {
        return repository.findById(id);
    }

    // Update Holiday
    public Holiday updateHoliday(int id, Holiday holiday) {

        Holiday existingHoliday = repository.findById(id).orElse(null);

        if (existingHoliday != null) {
            existingHoliday.setHolidayName(holiday.getHolidayName());
            existingHoliday.setHolidayDate(holiday.getHolidayDate());
            existingHoliday.setDescription(holiday.getDescription());

            return repository.save(existingHoliday);
        }

        return null;
    }

    // Delete Holiday
    public void deleteHoliday(int id) {
        repository.deleteById(id);
    }
    
    public List<Holiday> getUpcomingHolidays() {
        return repository.findTop5ByOrderByHolidayDateAsc();
    }
}