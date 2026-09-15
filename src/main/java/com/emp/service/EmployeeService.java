package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto updateEmployee(Long id , EmployeeDto employeeDto);
	
	void deleteEmployee(Long id);
	
	EmployeeDto getSingleEmployee(Long id);
	
	List <EmployeeDto> getAllEmployee();
}
