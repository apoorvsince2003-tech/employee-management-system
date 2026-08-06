package com.ems.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Profile;
import com.ems.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    private ProfileService service;

    // Get Profile
    @GetMapping("/{id}")
    public Optional<Profile> getProfile(@PathVariable Long id) {
        return service.getProfile(id);
    }

    // Create Profile
    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return service.saveProfile(profile);
    }

    // Update Profile
    @PutMapping("/{id}")
    public Profile updateProfile(
            @PathVariable Long id,
            @RequestBody Profile profile) {

        return service.updateProfile(id, profile);
    }

}