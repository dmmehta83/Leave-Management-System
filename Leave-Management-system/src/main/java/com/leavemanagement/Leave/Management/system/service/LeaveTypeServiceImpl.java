package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.entity.LeaveType;
import com.leavemanagement.Leave.Management.system.repository.LeaveTypeRepository;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	private final LeaveTypeRepository repository;
	
	
	public LeaveTypeServiceImpl(LeaveTypeRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public LeaveType saveLeaveType(LeaveType leaveType) {
		
		return repository.save(leaveType);
	}

	@Override
	public List<LeaveType> getAllLeaveTypes() {
		
		return repository.findAll();
	}

	@Override
	public LeaveType getLeaveTypeById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public LeaveType updateLeaveType(Long id, LeaveType leaveType) {
		LeaveType existing=repository.findById(id).orElse(null);
		
		if (existing != null) {
            existing.setLeaveName(leaveType.getLeaveName());
            return repository.save(existing);
        }
		return null;
	}

	@Override
	public void deleteLeaveType(Long id) {
		
		repository.deleteById(id);
		
	}

}
