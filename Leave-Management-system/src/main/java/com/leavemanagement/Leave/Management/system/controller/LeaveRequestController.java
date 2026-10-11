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

import com.leavemanagement.Leave.Management.system.dto.LeaveRequestRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveRequestResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;

import com.leavemanagement.Leave.Management.system.service.LeaveRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/leave-requests")
public class LeaveRequestController {
	
	private final LeaveRequestService service;

	public LeaveRequestController(LeaveRequestService service) {
		
		this.service = service;
	}
	
	@PostMapping
    public ResponseEntity<LeaveRequestResponseDTO> createLeaveRequest(@Valid @RequestBody LeaveRequestRequestDTO dto) {
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(service.saveLeaveRequest(dto));
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequestResponseDTO>> getAllLeaveRequest() {
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(service.getAllLeaveRequest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestResponseDTO> getLeaveRequest(@PathVariable Long id) {
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(service.getLeaveRequestById(id));
        		
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequestResponseDTO> updateLeaveRequest(@PathVariable Long id,
                                       @Valid @RequestBody LeaveRequestRequestDTO dto) {
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(service.updateLeaveRequest(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id) {

        service.deleteLeaveRequest(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
	
	

}
