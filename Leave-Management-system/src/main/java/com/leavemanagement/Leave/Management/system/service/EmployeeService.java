package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.dto.EmployeeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.EmployeeResponseDTO;


public interface EmployeeService {

	EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

    void deleteEmployee(Long id);
}
