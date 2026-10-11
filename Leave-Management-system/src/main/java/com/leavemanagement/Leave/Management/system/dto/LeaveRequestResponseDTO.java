package com.leavemanagement.Leave.Management.system.dto;

import java.time.LocalDate;

public class LeaveRequestResponseDTO {

private Long id;
private String employeeName;
private String leaveTypeName;
private LocalDate startDate;
private LocalDate endDate;
private String reason;
private String status;
public LeaveRequestResponseDTO() {
	
}
public LeaveRequestResponseDTO(Long id, String employeeName, String leaveTypeName, LocalDate startDate,
		LocalDate endDate, String reason, String status) {

	this.id = id;
	this.employeeName = employeeName;
	this.leaveTypeName = leaveTypeName;
	this.startDate = startDate;
	this.endDate = endDate;
	this.reason = reason;
	this.status = status;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getLeaveTypeName() {
	return leaveTypeName;
}
public void setLeaveTypeName(String leaveTypeName) {
	this.leaveTypeName = leaveTypeName;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}






}
