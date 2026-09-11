package com.ems.service;

import com.ems.dto.LoginRequest;
import com.ems.dto.LoginResponse;
import com.ems.entity.AppUser;
import com.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
        Optional<AppUser> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found with email: " + request.getEmail());
        }

        AppUser user = userOpt.get();

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password!");
        }

        return new LoginResponse(
            "Login Successful",
            user.getEmail(),
            user.getRole(),
            user.getEmployeeId()
        );
    }
}