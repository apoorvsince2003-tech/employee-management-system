package com.ems;

import com.ems.entity.AppUser;
import com.ems.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // 1. Admin User create karna
            if (userRepository.findByEmail("admin@ems.com").isEmpty()) {
                AppUser admin = new AppUser("admin@ems.com", "admin123", "ADMIN", null);
                userRepository.save(admin);
                System.out.println(">>> Default Admin Created: admin@ems.com / admin123");
            }

            // 2. Demo Employee User create karna (taaki employee login kaam kare)
            if (userRepository.findByEmail("rahul@ems.com").isEmpty()) {
                AppUser emp = new AppUser("rahul@ems.com", "emp123", "EMPLOYEE", 1L);
                userRepository.save(emp);
                System.out.println(">>> Default Employee Created: rahul@ems.com / emp123");
            }
        };
    }
}