package com.avishka.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.avishka.departmentservice.dto.DepartmentDTO;
import com.avishka.departmentservice.entity.Department;
import com.avishka.departmentservice.mapper.DepartmentMapper;
import com.avishka.departmentservice.repository.DepartmentRepository;
import com.avishka.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

		// conv dto to entity
		Department department = DepartmentMapper.MAPPER.departmentDTOToDepartment(departmentDTO);
		Department savedDepartment = departmentRepository.save(department);

		// conv entity to dto
		return DepartmentMapper.MAPPER.departmentToDepartmentDTO(savedDepartment);

	}

	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		// conv entity to dto
		return DepartmentMapper.MAPPER.departmentToDepartmentDTO(department);

	}

}
