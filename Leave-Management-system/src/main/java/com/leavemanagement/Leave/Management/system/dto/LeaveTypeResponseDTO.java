package com.leavemanagement.Leave.Management.system.dto;

public class LeaveTypeResponseDTO {

private Long id;
private String leaveName;
private Integer maxDaysAllowed;
public LeaveTypeResponseDTO() {

}
public LeaveTypeResponseDTO(Long id, String leaveName, Integer maxDaysAllowed) {

	this.id = id;
	this.leaveName = leaveName;
	this.maxDaysAllowed = maxDaysAllowed;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLeaveName() {
	return leaveName;
}
public void setLeaveName(String leaveName) {
	this.leaveName = leaveName;
}
public Integer getMaxDaysAllowed() {
	return maxDaysAllowed;
}
public void setMaxDaysAllowed(Integer maxDaysAllowed) {
	this.maxDaysAllowed = maxDaysAllowed;
}




}
