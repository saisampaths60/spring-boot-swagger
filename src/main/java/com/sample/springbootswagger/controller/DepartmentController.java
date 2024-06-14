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

import com.sample.springbootswagger.dto.DepartmentDto;
import com.sample.springbootswagger.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
	}

	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);

	}

}