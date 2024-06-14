package com.sample.springbootswagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springbootswagger.dto.APIResponseDTO;
import com.sample.springbootswagger.dto.EmployeeDto;
import com.sample.springbootswagger.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") Long employeeId) {
		APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<APIResponseDTO>(apiResponseDTO, HttpStatus.OK);
	}

}