package com.ems.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Team;
import com.ems.repository.TeamRepository;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.ProjectRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    public List<Team> getAllTeams() {

        List<Team> teams = repository.findAll();

        for (Team team : teams) {

            departmentRepository.findById(team.getDepartmentId().intValue())
                    .ifPresent(d -> team.setDepartmentName(d.getName()));

            employeeRepository.findById(team.getLeadId().intValue())
            .ifPresent(e -> team.setLeadName(e.getFirstName() + " " + e.getLastName()));

    if (team.getProjectId() != null) {
        projectRepository.findById(team.getProjectId())
                .ifPresent(p -> team.setProjectName(p.getName()));
    }
        }

        return teams;
    }

    // Get Team By ID
    public Optional<Team> getTeamById(Long id) {
        return repository.findById(id);
    }

    // Add Team
    public Team addTeam(Team team) {

        departmentRepository.findById(team.getDepartmentId().intValue())
                .ifPresent(d -> team.setDepartmentName(d.getName()));

        employeeRepository.findById(team.getLeadId().intValue())
                .ifPresent(e -> team.setLeadName(e.getFirstName() + " " + e.getLastName()));

        if (team.getProjectId() != null) {
            projectRepository.findById(team.getProjectId())
                    .ifPresent(p -> team.setProjectName(p.getName()));
        }

        return repository.save(team);
    }

    // Update Team
    public Team updateTeam(Long id, Team team) {

        team.setId(id);

        departmentRepository.findById(team.getDepartmentId().intValue())
                .ifPresent(d -> team.setDepartmentName(d.getName()));

        employeeRepository.findById(team.getLeadId().intValue())
                .ifPresent(e -> team.setLeadName(e.getFirstName() + " " + e.getLastName()));

        if (team.getProjectId() != null) {
            projectRepository.findById(team.getProjectId())
                    .ifPresent(p -> team.setProjectName(p.getName()));
        }

        return repository.save(team);
    }

    // Delete Team
    public void deleteTeam(Long id) {
        repository.deleteById(id);
    }
}