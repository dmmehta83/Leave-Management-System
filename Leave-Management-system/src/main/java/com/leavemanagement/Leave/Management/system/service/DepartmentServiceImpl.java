package com.leavemanagement.Leave.Management.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.dto.DepartmentRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.DepartmentResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.mapper.DepartmentMapper;
import com.leavemanagement.Leave.Management.system.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository repository;
	
	public DepartmentServiceImpl(DepartmentRepository repository) {
		
		this.repository = repository;
	}

	
	
	@Override
	public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO requestDTO) {

	    Department department = DepartmentMapper.toEntity(requestDTO);

	    Department savedDepartment = repository.save(department);

	    return DepartmentMapper.toResponseDTO(savedDepartment);
	}
	
	
	
	
	

	@Override
	public List<DepartmentResponseDTO> getAllDepartments() {
		
		List<Department> departments=repository.findAll();
		List<DepartmentResponseDTO> responseList = new ArrayList<>();
		
		for (Department department : departments) {
	        responseList.add(DepartmentMapper.toResponseDTO(department));
	    }

	    return responseList;
	}

	@Override
	public DepartmentResponseDTO getDepartmentById(Long id) {
		
		Department department=repository.findById(id).orElse(null);
		if (department == null) {
	        return null;
	    }

	    return DepartmentMapper.toResponseDTO(department);
				
	}

	@Override
	public  DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO requestDTO) {
		Department existing=repository.findById(id).orElse(null);
		
		if (existing == null) {
			return null;    
        }

		existing.setDepartmentName(requestDTO.getDepartmentName());
        
		Department updatedDepartment = repository.save(existing);

	    return DepartmentMapper.toResponseDTO(updatedDepartment);
        
		
	}

	@Override
	public void deleteDepartment(Long id) {
		repository.deleteById(id);
		
		
	}

	
}
