package com.avishka.employeeservice.service;

import com.avishka.employeeservice.dto.APIResponseDTO;
import com.avishka.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employeeDTO);

    APIResponseDTO getEmployeeById(Long id);

}
