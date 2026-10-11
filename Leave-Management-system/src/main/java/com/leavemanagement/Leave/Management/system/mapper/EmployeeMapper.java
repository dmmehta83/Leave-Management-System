package com.leavemanagement.Leave.Management.system.mapper;

import com.leavemanagement.Leave.Management.system.dto.EmployeeRequestDTO;

import com.leavemanagement.Leave.Management.system.dto.EmployeeResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.entity.Employee;

public class EmployeeMapper {

	public static Employee toEntity(
	        EmployeeRequestDTO dto,
	        Department department)
	{
		Employee employee = new Employee();

		employee.setFirstName(dto.getFirstName());

		employee.setLastName(dto.getLastName());

		employee.setEmail(dto.getEmail());

		employee.setPhone(dto.getPhone());

		employee.setDesignation(dto.getDesignation());

		employee.setSalary(dto.getSalary());

		employee.setDepartment(department);

		return employee;
	}
	public static EmployeeResponseDTO toResponseDTO(Employee employee)
	{
		EmployeeResponseDTO dto =
		        new EmployeeResponseDTO();

		dto.setId(employee.getId());

		dto.setFirstName(employee.getFirstName());

		dto.setLastName(employee.getLastName());

		dto.setEmail(employee.getEmail());

		dto.setPhone(employee.getPhone());

		dto.setDesignation(employee.getDesignation());

		dto.setSalary(employee.getSalary());

		dto.setDepartmentName(
		        employee.getDepartment().getDepartmentName());

		return dto;
	}
}
