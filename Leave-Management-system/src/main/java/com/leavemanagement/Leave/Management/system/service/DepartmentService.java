package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.dto.DepartmentRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.DepartmentResponseDTO;


public interface DepartmentService {

DepartmentResponseDTO saveDepartment(DepartmentRequestDTO department);
List<DepartmentResponseDTO> getAllDepartments();
DepartmentResponseDTO getDepartmentById(Long id);
DepartmentResponseDTO updateDepartment(Long id,DepartmentRequestDTO department);
void deleteDepartment(Long id);
}
