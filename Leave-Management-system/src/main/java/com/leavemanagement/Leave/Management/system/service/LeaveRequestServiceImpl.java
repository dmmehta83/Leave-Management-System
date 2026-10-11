package com.leavemanagement.Leave.Management.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.Leave.Management.system.dto.LeaveRequestRequestDTO;
import com.leavemanagement.Leave.Management.system.dto.LeaveRequestResponseDTO;
import com.leavemanagement.Leave.Management.system.entity.Employee;
import com.leavemanagement.Leave.Management.system.entity.LeaveRequest;
import com.leavemanagement.Leave.Management.system.entity.LeaveType;
import com.leavemanagement.Leave.Management.system.exception.ResourceNotFoundException;
import com.leavemanagement.Leave.Management.system.mapper.LeaveRequestMapper;
import com.leavemanagement.Leave.Management.system.repository.EmployeeRepository;
import com.leavemanagement.Leave.Management.system.repository.LeaveRequestRepository;
import com.leavemanagement.Leave.Management.system.repository.LeaveTypeRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	
	private final LeaveRequestRepository repository;
	private final EmployeeRepository employeeRepository;
	private final LeaveTypeRepository leaveTypeRepository;
	
	
	

	public LeaveRequestServiceImpl(LeaveRequestRepository repository, EmployeeRepository employeeRepository,
			LeaveTypeRepository leaveTypeRepository) {
		super();
		this.repository = repository;
		this.employeeRepository = employeeRepository;
		this.leaveTypeRepository = leaveTypeRepository;
	}

	@Override
	public LeaveRequestResponseDTO saveLeaveRequest(LeaveRequestRequestDTO dto) {
		
		Employee employee = employeeRepository
		        .findById(dto.getEmployeeId())
		        .orElseThrow(() ->
		                new ResourceNotFoundException(
		                        "Employee not found with id : " + dto.getEmployeeId()));
		
		LeaveType leaveType=leaveTypeRepository.findById(dto.getLeaveTypeId())
				.orElseThrow(()-> new ResourceNotFoundException("LeaveType not found with id :"+dto.getLeaveTypeId()));
		LeaveRequest leaveRequest=LeaveRequestMapper.toEntity(dto, employee, leaveType);
		leaveRequest.setStatus("Pending");
		LeaveRequest savedLeaveRequest=repository.save(leaveRequest);
		
		LeaveRequestResponseDTO leaveRequestResponseDTO=LeaveRequestMapper.toResponseDTO(savedLeaveRequest);
		
		return leaveRequestResponseDTO;
		
		
		
	}

	@Override
	public List<LeaveRequestResponseDTO> getAllLeaveRequest() {
		
		List<LeaveRequest> leaveRequest=repository.findAll();
		
		return leaveRequest
		.stream()
		.map(LeaveRequestMapper::toResponseDTO)
		.toList();
	
	}

	@Override
	public LeaveRequestResponseDTO getLeaveRequestById(Long id) {
		
		LeaveRequest leaveRequest=repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Leavenot foudnd with id"+id));
		
		
		return LeaveRequestMapper.toResponseDTO(leaveRequest);
		
	}

	@Override
	public LeaveRequestResponseDTO updateLeaveRequest(Long id, LeaveRequestRequestDTO dto) {
		
		LeaveRequest existing=repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Leavenot foudnd with id"+id));
		
		Employee employee = employeeRepository
		        .findById(dto.getEmployeeId())
		        .orElseThrow(() ->
		                new ResourceNotFoundException(
		                        "Employee not found with id : " + dto.getEmployeeId()));
            
		LeaveType leaveType = leaveTypeRepository
		        .findById(dto.getLeaveTypeId())
		        .orElseThrow(() ->
		                new ResourceNotFoundException(
		                        "Leave Type not found with id : " + dto.getLeaveTypeId()));
		
	existing.setEmployee(employee);
	existing.setLeavetype(leaveType);
	existing.setStartdate(dto.getStartDate());
	existing.setEnddate(dto.getEndDate());
	existing.setReason(dto.getReason());
	
	LeaveRequest updated = repository.save(existing);
	
	return LeaveRequestMapper.toResponseDTO(updated);
	
	}

	@Override
	public void deleteLeaveRequest(Long id) {
		
		repository.findById(id)
	    .orElseThrow(() -> new ResourceNotFoundException("Leave request is not found"+id));
		
		repository.deleteById(id);
		
	}

}
