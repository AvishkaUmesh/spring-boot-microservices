package com.avishka.employeeservice.service.impl;

import com.avishka.employeeservice.dto.EmployeeDTO;
import com.avishka.employeeservice.entity.Employee;
import com.avishka.employeeservice.exception.EmailAlreadyExistException;
import com.avishka.employeeservice.exception.ResourceNotFoundException;
import com.avishka.employeeservice.mapper.EmployeeMapper;
import com.avishka.employeeservice.repository.EmployeeRepository;
import com.avishka.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {

        Optional<Employee> employeeByEmail = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (employeeByEmail.isPresent()) {
            throw new EmailAlreadyExistException("Employee with email " + employeeDTO.getEmail() + " already exist");
        }

        Employee employee = EmployeeMapper.MAPPER.employeeDTOToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.employeeToEmployeeDTO(savedEmployee);

    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        return EmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);
    }
}
