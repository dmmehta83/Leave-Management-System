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

import com.leavemanagement.Leave.Management.system.dto.DepartmentRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.DepartmentResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Department;
import com.leavemanagement.Leave.Management.system.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

private final DepartmentService service;

public DepartmentController(DepartmentService service) {
	
	this.service = service;
}

@PostMapping
public DepartmentResponseDTO saveDepartment(
        @Valid @RequestBody DepartmentRequestDTO requestDTO) {

    return service.saveDepartment(requestDTO);
}

@GetMapping
public List<DepartmentResponseDTO> getAllDepartments() {

    return service.getAllDepartments();
}

@GetMapping("/{id}")
public  DepartmentResponseDTO getDepartment(@PathVariable Long id) {
    return service.getDepartmentById(id);
}

@PutMapping("/{id}")
public DepartmentResponseDTO updateDepartment(
        @PathVariable Long id,
        @Valid @RequestBody DepartmentRequestDTO requestDTO) {

    return service.updateDepartment(id, requestDTO);
}

@DeleteMapping("/{id}")
public void deleteDepartment(@PathVariable Long id) {
    service.deleteDepartment(id);
}



}
