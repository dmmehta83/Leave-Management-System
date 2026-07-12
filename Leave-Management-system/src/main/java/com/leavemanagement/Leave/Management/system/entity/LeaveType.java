package com.leavemanagement.Leave.Management.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leave_types")
public class LeaveType {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String leaveName;
private Integer maxDays;
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
public Integer getMaxDays() {
	return maxDays;
}
public void setMaxDays(Integer maxDays) {
	this.maxDays = maxDays;
}
public LeaveType(Long id, String leaveName, Integer maxDays) {
	
	this.id = id;
	this.leaveName = leaveName;
	this.maxDays = maxDays;
}
public LeaveType() {

}




}
