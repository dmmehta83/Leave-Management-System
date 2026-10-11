package com.leavemanagement.Leave.Management.system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagement.Leave.Management.system.dto.LeaveTypeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveTypeResponseDTO;

import com.leavemanagement.Leave.Management.system.service.LeaveTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/leave-types")
public class LeaveTypeController {
	
	private final LeaveTypeService service;
	
	 public LeaveTypeController(LeaveTypeService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public ResponseEntity<LeaveTypeResponseDTO> createLeaveType(@Valid @RequestBody LeaveTypeRequestDTO dto) {
	    	return ResponseEntity
	    	        .status(HttpStatus.CREATED)
	    	        .body(service.saveLeaveType(dto));
	    }

	    @GetMapping
	    public ResponseEntity<List<LeaveTypeResponseDTO>> getAllLeaveTypes() {
	        return ResponseEntity
	        		 .status(HttpStatus.OK)
	        		.body(service.getAllLeaveTypes());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<LeaveTypeResponseDTO> getLeaveType(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).
	        		body(service.getLeaveTypeById(id));
	    }
	    

	    @PutMapping("/{id}")
	    public ResponseEntity<LeaveTypeResponseDTO> updateLeaveType(@PathVariable Long id,
	                                       @Valid @RequestBody LeaveTypeRequestDTO dto) {
	        return ResponseEntity.status(HttpStatus.OK).body(service.updateLeaveType(id, dto));
	        		
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteLeaveType(@PathVariable Long id) {
	    	service.deleteLeaveType(id);
	    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	

}
