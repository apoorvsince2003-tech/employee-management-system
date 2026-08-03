package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

    List<Holiday> findTop5ByOrderByHolidayDateAsc();

}