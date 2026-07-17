package com.leavemanagement.Leave.Management.system.mapper;

import com.leavemanagement.Leave.Management.system.dto.DepartmentRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.DepartmentResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Department;

public class DepartmentMapper {

    // RequestDTO -> Entity
    public static Department toEntity(DepartmentRequestDTO dto) {

        Department department = new Department();

        department.setDepartmentName(dto.getDepartmentName());

        return department;
    }

    // Entity -> ResponseDTO
    public static DepartmentResponseDTO toResponseDTO(Department department) {

        DepartmentResponseDTO dto = new DepartmentResponseDTO();

        dto.setId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());

        return dto;
    }

}