package com.leavemanagement.Leave.Management.system.dto;

public class DepartmentRequestDTO {

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