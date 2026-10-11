package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.dto.LeaveTypeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveTypeResponseDTO;


public interface LeaveTypeService {

	
	LeaveTypeResponseDTO saveLeaveType(LeaveTypeRequestDTO dto);

    List<LeaveTypeResponseDTO> getAllLeaveTypes();

    LeaveTypeResponseDTO getLeaveTypeById(Long id);

    LeaveTypeResponseDTO updateLeaveType(Long id, LeaveTypeRequestDTO dto);

    void deleteLeaveType(Long id);
}
