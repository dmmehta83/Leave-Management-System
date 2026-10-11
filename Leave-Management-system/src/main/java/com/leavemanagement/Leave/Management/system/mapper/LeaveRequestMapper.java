package com.leavemanagement.Leave.Management.system.mapper;

import com.leavemanagement.Leave.Management.system.dto.LeaveRequestRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveRequestResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;
import com.leavemanagement.Leave.Management.system.entity.LeaveType;

public class LeaveRequestMapper {

	public static LeaveRequest toEntity(LeaveRequestRequestDTO dto,
		    Employee employee,
		    LeaveType leaveType)
	{
		LeaveRequest request=new LeaveRequest();
		request.setEmployee(employee);
		request.setLeavetype(leaveType);
		request.setStartdate(dto.getStartDate());
		request.setEnddate(dto.getEndDate());
		request.setReason(dto.getReason());
		
		return request;
	}
	
	public static LeaveRequestResponseDTO toResponseDTO(LeaveRequest leaveRequest
		    )
	{
		LeaveRequestResponseDTO dto=new LeaveRequestResponseDTO();
		dto.setId(leaveRequest.getId());
		dto.setEmployeeName(leaveRequest.getEmployee().getFirstName());
		dto.setLeaveTypeName(leaveRequest.getLeavetype().getLeaveName());
		dto.setStartDate(leaveRequest.getStartdate());
		dto.setEndDate(leaveRequest.getEnddate());
		dto.setReason(leaveRequest.getReason());
		dto.setStatus(leaveRequest.getStatus());
		return dto;
		
		
		
	}
	
}
