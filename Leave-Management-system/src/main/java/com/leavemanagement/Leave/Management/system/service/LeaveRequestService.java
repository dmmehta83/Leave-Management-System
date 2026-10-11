package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.dto.LeaveRequestRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveRequestResponseDTO;


public interface LeaveRequestService {

	LeaveRequestResponseDTO saveLeaveRequest(LeaveRequestRequestDTO dto);
	
	List<LeaveRequestResponseDTO> getAllLeaveRequest();
	
	LeaveRequestResponseDTO getLeaveRequestById(Long id);
	
	LeaveRequestResponseDTO updateLeaveRequest(Long id, LeaveRequestRequestDTO dto);
	
	void deleteLeaveRequest(Long id);
}
