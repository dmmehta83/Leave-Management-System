package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository repository;
	
	public DepartmentServiceImpl(DepartmentRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public Department saveDepartment(Department department) {
		
		return repository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return repository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		
		return repository.findById(id).orElse(null);
				
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department existing=repository.findById(id).orElse(null);
		
		if (existing != null) {
            existing.setDepartmentName(department.getDepartmentName());
            return repository.save(existing);
        }

        return null;
		
	}

	@Override
	public void deleteDepartment(Long id) {
		repository.deleteById(id);
		
		
	}

	
}
