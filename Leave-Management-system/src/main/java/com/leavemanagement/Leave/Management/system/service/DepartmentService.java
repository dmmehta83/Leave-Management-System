package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import com.leavemanagement.Leave.Management.system.entity.Department;

public interface DepartmentService {

Department saveDepartment(Department department);
List<Department> getAllDepartments();
Department getDepartmentById(Long id);
Department updateDepartment(Long id,Department department);
void deleteDepartment(Long id);
}
