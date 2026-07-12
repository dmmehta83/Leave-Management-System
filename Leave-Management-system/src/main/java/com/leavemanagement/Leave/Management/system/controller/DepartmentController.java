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
import com.leavemanagement.Leave.Management.system.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

private final DepartmentService service;

public DepartmentController(DepartmentService service) {
	
	this.service = service;
}

@PostMapping
public Department createDepartment(@RequestBody Department department)
{
	return service.saveDepartment(department);
	
}
@GetMapping
public List<Department> getAllDepartments() {
    return service.getAllDepartments();
}

@GetMapping("/{id}")
public Department getDepartment(@PathVariable Long id) {
    return service.getDepartmentById(id);
}

@PutMapping("/{id}")
public Department updateDepartment(@PathVariable Long id,
                                   @RequestBody Department department) {
    return service.updateDepartment(id, department);
}

@DeleteMapping("/{id}")
public void deleteDepartment(@PathVariable Long id) {
    service.deleteDepartment(id);
}



}
