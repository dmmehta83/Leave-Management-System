package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.exception.ResourceNotFoundException;
import com.leavemanagement.Leave.Management.system.repository.DepartmentRepository;
import com.leavemanagement.Leave.Management.system.repository.EmployeeRepository;

import com.leavemanagement.Leave.Management.system.dto.EmployeeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.EmployeeResponseDTO;
import com.leavemanagement.Leave.Management.system.mapper.EmployeeMapper;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;
	private final DepartmentRepository departmentRepository;
	
	
	@Override
	public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto) {
		Department department = departmentRepository.findById(dto.getDepartmentId())
		        .orElseThrow(() -> new ResourceNotFoundException(
		                "Department not found with id : " + dto.getDepartmentId()));
		Employee employee = EmployeeMapper.toEntity(dto, department);
		Employee savedEmployee = repository.save(employee);
		return EmployeeMapper.toResponseDTO(savedEmployee);
		
	}

	public EmployeeServiceImpl(EmployeeRepository repository,
            DepartmentRepository departmentRepository) {

this.repository = repository;
this.departmentRepository = departmentRepository;
}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {

	    return repository.findAll()
	            .stream()
	            .map(EmployeeMapper::toResponseDTO)
	            .toList();
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {

	    Employee employee = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Employee not found with id : " + id));

	    return EmployeeMapper.toResponseDTO(employee);
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id,
	        EmployeeRequestDTO dto) {

	    Employee existingEmployee = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Employee not found with id : " + id));

	    Department department = departmentRepository.findById(dto.getDepartmentId())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Department not found with id : "
	                                    + dto.getDepartmentId()));

	    existingEmployee.setFirstName(dto.getFirstName());
	    existingEmployee.setLastName(dto.getLastName());
	    existingEmployee.setEmail(dto.getEmail());
	    existingEmployee.setPhone(dto.getPhone());
	    existingEmployee.setDesignation(dto.getDesignation());
	    existingEmployee.setSalary(dto.getSalary());
	    existingEmployee.setDepartment(department);

	    Employee updatedEmployee = repository.save(existingEmployee);

	    return EmployeeMapper.toResponseDTO(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {

	    Employee employee = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Employee not found with id : " + id));

	    repository.delete(employee);
	}


}
