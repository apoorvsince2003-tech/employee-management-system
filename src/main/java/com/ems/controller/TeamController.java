package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Team;
import com.ems.service.TeamService;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService service;

    // Get All Teams
    @GetMapping
    public List<Team> getAllTeams() {
        return service.getAllTeams();
    }

    // Get Team By ID
    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable Long id) {
        return service.getTeamById(id);
    }

    // Add Team
    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return service.addTeam(team);
    }

    // Update Team
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id,
                           @RequestBody Team team) {
        return service.updateTeam(id, team);
    }

    // Delete Team
    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable Long id) {
        service.deleteTeam(id);
        return "Team Deleted Successfully";
    }
}