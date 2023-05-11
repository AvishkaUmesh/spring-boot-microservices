package com.avishka.employeeservice.service;

import com.avishka.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

}
