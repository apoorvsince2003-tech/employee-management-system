package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findTop8ByOrderByActivityDateDesc();

}