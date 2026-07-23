package com.leavemanagement.Leave.Management.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentRequestDTO {

    @NotBlank(message="Department name is required")
    @Size(min=3,max=100,message="Department must be between 3 and 100 characters")
	private String departmentName;

    public DepartmentRequestDTO() {
    }

    public DepartmentRequestDTO(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}