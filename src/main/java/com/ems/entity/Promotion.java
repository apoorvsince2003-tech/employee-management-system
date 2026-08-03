package com.ems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employeeId;

    private String employeeName;

    private String departmentName;

    private String oldDesignation;

    private String newDesignation;

    private double oldSalary;

    private double newSalary;

    private double salaryIncrease;

    private String reason;

    private String promotionDate;

    private String status;

    public Promotion() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOldDesignation() {
		return oldDesignation;
	}

	public void setOldDesignation(String oldDesignation) {
		this.oldDesignation = oldDesignation;
	}

	public String getNewDesignation() {
		return newDesignation;
	}

	public void setNewDesignation(String newDesignation) {
		this.newDesignation = newDesignation;
	}

	public double getOldSalary() {
		return oldSalary;
	}

	public void setOldSalary(double oldSalary) {
		this.oldSalary = oldSalary;
	}

	public double getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(double newSalary) {
		this.newSalary = newSalary;
	}

	public double getSalaryIncrease() {
		return salaryIncrease;
	}

	public void setSalaryIncrease(double salaryIncrease) {
		this.salaryIncrease = salaryIncrease;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPromotionDate() {
		return promotionDate;
	}

	public void setPromotionDate(String promotionDate) {
		this.promotionDate = promotionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}