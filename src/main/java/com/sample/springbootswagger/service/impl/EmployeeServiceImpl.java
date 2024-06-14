package com.sample.springbootswagger.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springbootswagger.dto.APIResponseDTO;
import com.sample.springbootswagger.dto.DepartmentDto;
import com.sample.springbootswagger.dto.EmployeeDto;
import com.sample.springbootswagger.entities.department.Department;
import com.sample.springbootswagger.entities.employee.Employee;
import com.sample.springbootswagger.repositories.department.DepartmentRepository;
import com.sample.springbootswagger.repositories.employee.EmployeeRepository;
import com.sample.springbootswagger.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode());
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());
		return savedEmployeeDto;
	}

	@Override
	public APIResponseDTO getEmployeeById(Long employeeId) {
		LOGGER.info("inside getEmployeeById method");
		Employee employee = employeeRepository.findById(employeeId).get();

		Department department = departmentRepository.findByDepartmentCode(employee.getDepartmentCode());

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());

		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getEmail(), employee.getDepartmentCode());
		APIResponseDTO apiResponseDTO = new APIResponseDTO();
		apiResponseDTO.setDepartmentDto(departmentDto);
		apiResponseDTO.setEmployeeDto(employeeDto);
		return apiResponseDTO;
	}

}