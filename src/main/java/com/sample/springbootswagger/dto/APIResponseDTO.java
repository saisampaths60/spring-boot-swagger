package com.sample.springbootswagger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {

	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;

}