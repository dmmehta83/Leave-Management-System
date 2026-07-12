package com.leavemanagement.Leave.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagement.Leave.Management.system.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
