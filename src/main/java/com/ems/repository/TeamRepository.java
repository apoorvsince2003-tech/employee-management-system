package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}