package com.emp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeDto;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
	  this.employeeService=employeeService;	
	}
	
	  @PostMapping("/save")
	  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto response = employeeService.saveEmployee(employeeDto);

		  return new ResponseEntity<>(response, HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update/{id}")
	   public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id){
		  EmployeeDto response = employeeService.updateEmployee(id,employeeDto);
		  return new ResponseEntity<>(response, HttpStatus.OK);
	   }
	  
	   @DeleteMapping("delete/{id}")
	   public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
	   
		   employeeService.deleteEmployee(id);
		   return new ResponseEntity<>("Employee delete Successfully" , HttpStatus.OK);
	   }
	  
	   
	   @GetMapping("/{id}")
	   public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
		EmployeeDto response=employeeService.getSingleEmployee(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	   
	   @GetMapping("/all")
	   public ResponseEntity<Iterable<EmployeeDto>> getallEmployee(){
		   Iterable<EmployeeDto> response=employeeService.getAllEmployee();
		return new ResponseEntity<>(response, HttpStatus.OK); 
	   }  
	   
}
