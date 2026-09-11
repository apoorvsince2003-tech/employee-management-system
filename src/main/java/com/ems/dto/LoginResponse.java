package com.ems.dto;

public class LoginResponse {
    private String message;
    private String email;
    private String role;
    private Long employeeId;

    public LoginResponse(String message, String email, String role, Long employeeId) {
        this.message = message;
        this.email = email;
        this.role = role;
        this.employeeId = employeeId;
    }

    public String getMessage() { return message; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public Long getEmployeeId() { return employeeId; }
}