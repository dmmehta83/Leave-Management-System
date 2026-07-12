package com.leavemanagement.Leave.Management.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		
		this.service = service;
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
		
	}
	@GetMapping
	public List<Employee> getAllEmployees() {
	    return service.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
	    return service.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id,
	                                   @RequestBody Employee employee) {
	    return service.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
	    service.deleteEmployee(id);
	}
 
	
	

}
