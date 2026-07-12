package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;
import com.leavemanagement.Leave.Management.system.repository.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	
	private final LeaveRequestRepository repository;
	
	
	public LeaveRequestServiceImpl(LeaveRequestRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
		
		return repository.save(leaveRequest);
	}

	@Override
	public List<LeaveRequest> getAllLeaveRequest() {
		
		return repository.findAll();
	}

	@Override
	public LeaveRequest getLeaveRequestById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {
		LeaveRequest existing=repository.findById(id).orElse(null);
		
		if (existing != null) {
            existing.setStatus(leaveRequest.getStatus());
            return repository.save(existing);
        }
		
		return null;
	}

	@Override
	public void deleteLeaveRequest(Long id) {
		
		repository.deleteById(id);
		
	}

}
