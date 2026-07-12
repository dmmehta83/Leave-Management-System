package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.entity.LeaveType;

public interface LeaveTypeService {

	
	LeaveType saveLeaveType(LeaveType leaveType);

    List<LeaveType> getAllLeaveTypes();

    LeaveType getLeaveTypeById(Long id);

    LeaveType updateLeaveType(Long id, LeaveType leaveType);

    void deleteLeaveType(Long id);
}
