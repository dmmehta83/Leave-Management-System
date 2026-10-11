package com.leavemanagement.Leave.Management.system.mapper;

import com.leavemanagement.Leave.Management.system.dto.LeaveTypeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveTypeResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.LeaveType;

public class LeaveTypeMapper {

	public static LeaveType toEntity(LeaveTypeRequestDTO dto)
	{
		LeaveType leaveType=new LeaveType();
		leaveType.setLeaveName(dto.getLeaveName());
		leaveType.setMaxDays(dto.getMaxDaysAllowed());
		
		return leaveType;
		
		
		
	}
	
	public static LeaveTypeResponseDTO toResponseDTO(LeaveType leaveType)
	{
		LeaveTypeResponseDTO dto =new LeaveTypeResponseDTO();
		dto.setId(leaveType.getId());
		dto.setLeaveName(leaveType.getLeaveName());
		dto.setMaxDaysAllowed(leaveType.getMaxDays());
		
		return dto;
	}
	
	
}
