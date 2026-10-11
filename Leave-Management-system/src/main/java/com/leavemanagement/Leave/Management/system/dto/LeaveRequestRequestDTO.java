package com.leavemanagement.Leave.Management.system.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LeaveRequestRequestDTO {

@NotNull(message="Empoyee id required")
private Long employeeId;
@NotNull(message="LeaveType id required")
private Long leaveTypeId;
@NotNull(message="Start date required")
private LocalDate startDate;
@NotNull(message="End date required")
private LocalDate endDate;
@NotBlank(message="Reason is required")
private String reason;
public LeaveRequestRequestDTO() {

}
public LeaveRequestRequestDTO(Long employeeId,
		 Long leaveTypeId,
		 LocalDate startDate,
		 LocalDate endDate,
		 String reason) {
	
	this.employeeId = employeeId;
	this.leaveTypeId = leaveTypeId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.reason = reason;
}
public Long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}
public Long getLeaveTypeId() {
	return leaveTypeId;
}
public void setLeaveTypeId(Long leaveTypeId) {
	this.leaveTypeId = leaveTypeId;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}







}
