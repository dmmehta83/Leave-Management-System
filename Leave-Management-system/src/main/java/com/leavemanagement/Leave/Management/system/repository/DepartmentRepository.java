package com.leavemanagement.Leave.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagement.Leave.Management.system.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
