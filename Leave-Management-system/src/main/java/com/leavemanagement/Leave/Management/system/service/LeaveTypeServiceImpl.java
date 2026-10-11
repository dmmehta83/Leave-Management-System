package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.dto.LeaveTypeRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveTypeResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.entity.LeaveType;
import com.leavemanagement.Leave.Management.system.exception.ResourceNotFoundException;
import com.leavemanagement.Leave.Management.system.mapper.LeaveTypeMapper;
import com.leavemanagement.Leave.Management.system.repository.LeaveTypeRepository;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	private final LeaveTypeRepository repository;
	
	
	public LeaveTypeServiceImpl(LeaveTypeRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public LeaveTypeResponseDTO saveLeaveType(LeaveTypeRequestDTO dto) {
		
		LeaveType leaveType=LeaveTypeMapper.toEntity(dto);
		LeaveType savedLeaveType=repository.save(leaveType);
		LeaveTypeResponseDTO resdto=LeaveTypeMapper.toResponseDTO(savedLeaveType);
		return resdto;
	}

	@Override
	public List<LeaveTypeResponseDTO> getAllLeaveTypes() {
		
		List<LeaveType> leaveType=repository.findAll();
		
		return leaveType.stream().map(LeaveTypeMapper::toResponseDTO).toList();
	}

	@Override
	public LeaveTypeResponseDTO getLeaveTypeById(Long id) {

	    LeaveType leaveType = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Leave Type not found with id : " + id));

	    return LeaveTypeMapper.toResponseDTO(leaveType);
	}

	@Override
	public LeaveTypeResponseDTO updateLeaveType(
	        Long id,
	        LeaveTypeRequestDTO dto) {

	    LeaveType existing = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Leave Type not found with id : " + id));

	    existing.setLeaveName(dto.getLeaveName());

	    existing.setMaxDays(dto.getMaxDaysAllowed());

	    LeaveType updated = repository.save(existing);

	    return LeaveTypeMapper.toResponseDTO(updated);
	}

	@Override
	public void deleteLeaveType(Long id) {

	    LeaveType leaveType = repository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Leave Type not found with id : " + id));

	    repository.delete(leaveType);
	}

}
