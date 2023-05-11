package com.avishka.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avishka.departmentservice.dto.DepartmentDTO;
import com.avishka.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;

	// save department REST API
	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	// get department by code REST API
	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("code") String departmentCode) {
		DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
	}
}
