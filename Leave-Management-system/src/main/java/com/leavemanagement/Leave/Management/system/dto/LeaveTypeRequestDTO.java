package com.leavemanagement.Leave.Management.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LeaveTypeRequestDTO {

	@NotBlank(message = "Leave name is required")
private String leaveName;
	@NotNull(message = "Maximum allowed days is required")
	@Positive(message = "Maximum allowed days must be positive")
private Integer maxDaysAllowed;
public LeaveTypeRequestDTO() {

}
public LeaveTypeRequestDTO(@NotBlank String leaveName, @NotNull @Positive Integer maxDaysAllowed) {
	super();
	this.leaveName = leaveName;
	this.maxDaysAllowed = maxDaysAllowed;
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
