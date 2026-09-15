package com.emp.service.serviceimp;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDto;
import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
 
	 private final EmployeeRepository  employeeRepository;
	 private final ModelMapper modelMapper;
	 
	 public EmployeeServiceImpl (EmployeeRepository employeeRepository ,ModelMapper modelMapper) {
		  this.employeeRepository = employeeRepository;
		  this.modelMapper = modelMapper;
	 }
	
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		if(employeeDto.getId()!=null) {
			throw new RuntimeException("Employee Already Exist..");
		}
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee saveEntity = employeeRepository.save(entity);
				return modelMapper
		          .map(saveEntity, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		 if(id==null || employeeDto.getId()==null) {
			 throw new RuntimeException("Please Provide Valid Id");
		 }
		 
		 if (!Objects.equals(id, employeeDto.getId())) {
			 throw new RuntimeException("id mismatch"); 
		 }
		 employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		 Employee entity = modelMapper.map(employeeDto, Employee.class);
		 Employee updateEntity = employeeRepository.save(entity);
		  return modelMapper
		          .map(updateEntity, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long id) {
		 Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		 employeeRepository.delete(employee);
	}

	@Override
	public EmployeeDto getSingleEmployee(Long id) {
		Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employee = employeeRepository.findAll();
	           return employee.stream()
				.map((Employee emp) -> modelMapper.map(emp, EmployeeDto.class))
				.toList();
	 

	}

}
