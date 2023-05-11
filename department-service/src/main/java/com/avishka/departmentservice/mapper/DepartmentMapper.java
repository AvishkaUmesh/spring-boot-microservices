package com.avishka.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.avishka.departmentservice.dto.DepartmentDTO;
import com.avishka.departmentservice.entity.Department;

@Mapper
public interface DepartmentMapper {

	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

	DepartmentDTO departmentToDepartmentDTO(Department department);

	Department departmentDTOToDepartment(DepartmentDTO departmentDTO);

}
