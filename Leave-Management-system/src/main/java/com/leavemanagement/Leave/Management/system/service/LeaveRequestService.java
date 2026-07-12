package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;

public interface LeaveRequestService {

	LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest);
	
	List<LeaveRequest> getAllLeaveRequest();
	
	LeaveRequest getLeaveRequestById(Long id);
	
	LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest);
	
	void deleteLeaveRequest(Long id);
}
