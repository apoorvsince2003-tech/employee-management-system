package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByEmployeeName(String employeeName);

    long countByStatus(String status);

    long countByDate(String date);

    @Query("""
        SELECT a.date,
               COUNT(a)
        FROM Attendance a
        GROUP BY a.date
        ORDER BY a.date
    """)
    List<Object[]> getAttendanceTrend();

}