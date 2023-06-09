package com.avishka.employeeservice.mapper;

import com.avishka.employeeservice.dto.EmployeeDTO;
import com.avishka.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(target = "departmentCode", source = "departmentCode")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);


}
