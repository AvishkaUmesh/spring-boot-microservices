package com.avishka.departmentservice.service;

import com.avishka.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
	DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

	DepartmentDTO getDepartmentByCode(String departmentCode);

}
