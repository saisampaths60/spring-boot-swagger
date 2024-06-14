package com.sample.springbootswagger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springbootswagger.dto.DepartmentDto;
import com.sample.springbootswagger.entities.department.Department;
import com.sample.springbootswagger.repositories.department.DepartmentRepository;
import com.sample.springbootswagger.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode());

		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());

		return departmentDto;
	}

}