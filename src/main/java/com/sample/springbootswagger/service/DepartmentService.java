package com.sample.springbootswagger.service;

import com.sample.springbootswagger.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String departmentCode);

}