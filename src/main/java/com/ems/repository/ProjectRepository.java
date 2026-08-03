package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	long countByStatus(String status);

}