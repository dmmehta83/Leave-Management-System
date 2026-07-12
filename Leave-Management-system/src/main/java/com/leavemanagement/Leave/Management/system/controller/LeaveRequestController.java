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

import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;

import com.leavemanagement.Leave.Management.system.service.LeaveRequestService;

@RestController
@RequestMapping("api/leave-requests")
public class LeaveRequestController {
	
	private final LeaveRequestService service;

	public LeaveRequestController(LeaveRequestService service) {
		
		this.service = service;
	}
	
	@PostMapping
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return service.saveLeaveRequest(leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequest() {
        return service.getAllLeaveRequest();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequest(@PathVariable Long id) {
        return service.getLeaveRequestById(id);
    }

    @PutMapping("/{id}")
    public LeaveRequest updateLeaveRequest(@PathVariable Long id,
                                       @RequestBody LeaveRequest leaveRequest) {
        return service.updateLeaveRequest(id, leaveRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        service.deleteLeaveRequest(id);
    }
	
	

}
