package com.sample.springbootswagger.service;

import com.sample.springbootswagger.dto.APIResponseDTO;
import com.sample.springbootswagger.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDTO getEmployeeById(Long employeeId);

}