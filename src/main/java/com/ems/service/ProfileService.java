package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Profile;
import com.ems.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    // Get Profile
    public Optional<Profile> getProfile(Long id) {
        return repository.findById(id);
    }

    // Save Profile
    public Profile saveProfile(Profile profile) {
        return repository.save(profile);
    }

    // Update Profile
    public Profile updateProfile(Long id, Profile profile) {

        Profile existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setFirstName(profile.getFirstName());
            existing.setLastName(profile.getLastName());
            existing.setEmail(profile.getEmail());
            existing.setPhone(profile.getPhone());
            existing.setDesignation(profile.getDesignation());
            existing.setDepartment(profile.getDepartment());
            existing.setEmployeeCode(profile.getEmployeeCode());
            existing.setEmploymentType(profile.getEmploymentType());
            existing.setStatus(profile.getStatus());
            existing.setJoinDate(profile.getJoinDate());
            existing.setLocation(profile.getLocation());
            existing.setManager(profile.getManager());
            existing.setReports(profile.getReports());
            existing.setBio(profile.getBio());
            existing.setDateOfBirth(profile.getDateOfBirth());
            existing.setGender(profile.getGender());
            existing.setNationality(profile.getNationality());
            existing.setAddress(profile.getAddress());
            existing.setEmergencyContact(profile.getEmergencyContact());
            existing.setEmergencyName(profile.getEmergencyName());
            existing.setLinkedin(profile.getLinkedin());
            existing.setGithub(profile.getGithub());
            existing.setWebsite(profile.getWebsite());

            return repository.save(existing);
        }

        return null;
    }
}