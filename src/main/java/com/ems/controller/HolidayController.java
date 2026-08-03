package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Holiday;
import com.ems.service.HolidayService;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin(origins = "*")
public class HolidayController {

    @Autowired
    private HolidayService service;

    // Add Holiday
    @PostMapping
    public Holiday addHoliday(@RequestBody Holiday holiday) {
        return service.addHoliday(holiday);
    }

    // Get All Holidays
    @GetMapping
    public List<Holiday> getAllHolidays() {
        return service.getAllHolidays();
    }
    
    @GetMapping("/upcoming")
    public List<Holiday> getUpcomingHolidays(
            @RequestParam(defaultValue = "5") int limit) {

        List<Holiday> holidays = service.getAllHolidays();

        if (holidays.size() <= limit) {
            return holidays;
        }

        return holidays.subList(0, limit);
    }

    // Get Holiday By ID
    @GetMapping("/{id}")
    public Optional<Holiday> getHolidayById(@PathVariable int id) {
        return service.getHolidayById(id);
    }

    // Update Holiday
    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable int id,
                                 @RequestBody Holiday holiday) {
        return service.updateHoliday(id, holiday);
    }

    // Delete Holiday
    @DeleteMapping("/{id}")
    public String deleteHoliday(@PathVariable int id) {
        service.deleteHoliday(id);
        return "Holiday Deleted Successfully";
    }
}