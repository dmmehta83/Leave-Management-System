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


import jakarta.validation.Valid;

import com.leavemanagement.Leave.Management.system.dto.EmployeeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.EmployeeResponseDTO;
import com.leavemanagement.Leave.Management.system.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(
	        @Valid @RequestBody EmployeeRequestDTO dto) {

		return ResponseEntity.status(HttpStatus.CREATED)
		        .body(service.saveEmployee(dto));

	}
	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

	    return ResponseEntity.ok(service.getAllEmployees());

	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployee(
	        @PathVariable Long id) {

	    return ResponseEntity.ok(
	            service.getEmployeeById(id));

	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(
	        @PathVariable Long id,
	        @Valid @RequestBody EmployeeRequestDTO dto) {

		return ResponseEntity.ok(service.updateEmployee(id, dto));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	    service.deleteEmployee(id);
	    service.deleteEmployee(id);

	    return ResponseEntity.noContent().build();
	}
 
	
	

}
