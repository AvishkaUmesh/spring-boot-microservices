package com.avishka.employeeservice.service.impl;

import com.avishka.employeeservice.dto.APIResponseDTO;
import com.avishka.employeeservice.dto.DepartmentDTO;
import com.avishka.employeeservice.dto.EmployeeDTO;
import com.avishka.employeeservice.entity.Employee;
import com.avishka.employeeservice.exception.EmailAlreadyExistException;
import com.avishka.employeeservice.exception.ResourceNotFoundException;
import com.avishka.employeeservice.mapper.EmployeeMapper;
import com.avishka.employeeservice.repository.EmployeeRepository;
import com.avishka.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

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
    public APIResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDTO.class);
        DepartmentDTO departmentDTO = responseEntity.getBody();

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setDepartment(departmentDTO);
        apiResponseDTO.setEmployee(EmployeeMapper.MAPPER.employeeToEmployeeDTO(employee));

        return apiResponseDTO;
//        return EmployeeMapper.MAPPER.employeeToEmployeeDTO(employee);
    }
}
