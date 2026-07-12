package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return repository.save(employee);
	}

	public EmployeeServiceImpl(EmployeeRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
		
				}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return repository.findById(id).orElse(null);
		
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
	
		Employee existing=repository.findById(id).orElse(null);
		
		if (existing != null) {
            existing.setFirstName(employee.getFirstName());
            return repository.save(existing);
        }

        return null;
		
	}

	@Override
	public void deleteEmployee(Long id) {
		
		repository.deleteById(id);
		
		
	}


}
