package com.leavemanagement.Leave.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagement.Leave.Management.system.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long> {

}
