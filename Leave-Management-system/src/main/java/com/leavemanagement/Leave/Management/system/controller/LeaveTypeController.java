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

import com.leavemanagement.Leave.Management.system.entity.LeaveType;
import com.leavemanagement.Leave.Management.system.service.LeaveTypeService;

@RestController
@RequestMapping("api/leave-types")
public class LeaveTypeController {
	
	private final LeaveTypeService service;
	
	 public LeaveTypeController(LeaveTypeService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public LeaveType createLeaveType(@RequestBody LeaveType leaveType) {
	        return service.saveLeaveType(leaveType);
	    }

	    @GetMapping
	    public List<LeaveType> getAllLeaveTypes() {
	        return service.getAllLeaveTypes();
	    }

	    @GetMapping("/{id}")
	    public LeaveType getLeaveType(@PathVariable Long id) {
	        return service.getLeaveTypeById(id);
	    }

	    @PutMapping("/{id}")
	    public LeaveType updateLeaveType(@PathVariable Long id,
	                                       @RequestBody LeaveType leaveType) {
	        return service.updateLeaveType(id, leaveType);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteLeaveType(@PathVariable Long id) {
	        service.deleteLeaveType(id);
	    }
	

}
