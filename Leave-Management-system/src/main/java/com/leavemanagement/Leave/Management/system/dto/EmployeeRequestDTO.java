package com.leavemanagement.Leave.Management.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequestDTO {

	@NotBlank(message="First name is required")
	private String firstName;
	@NotBlank(message="Last name is required")
	private String lastName;
	@NotBlank(message="Email is required")
	@Email(message="Invalid email")
	private String email;
	@NotBlank(message="Phone is required")
	private String phone;
	@NotBlank(message="Designation is required")
	private String designation;
	@NotNull(message="Salary is required")
	private Double salary;
	@NotNull(message="Department is required")
	private Long departmentId;
	public EmployeeRequestDTO() {
		
	}
	
	public EmployeeRequestDTO(String firstName,
            String lastName,
            String email,
            String phone,
            String designation,
            Double salary,
            Long departmentId) {

this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.phone = phone;
this.designation = designation;
this.salary = salary;
this.departmentId = departmentId;
}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
	
}
