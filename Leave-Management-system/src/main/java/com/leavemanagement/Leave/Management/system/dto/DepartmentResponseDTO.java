package com.leavemanagement.Leave.Management.system.dto;

public class DepartmentResponseDTO {

    private Long id;
    
    private String departmentName;

    public DepartmentResponseDTO() {
    }

    public DepartmentResponseDTO(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
}