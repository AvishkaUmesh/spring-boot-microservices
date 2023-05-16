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
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
    //    private APIClient apiClient;
    private WebClient webClient;

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

    //    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDTO getEmployeeById(Long id) {

        LOGGER.info("Inside getEmployeeById() method of EmployeeServiceImpl");
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

//        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setDepartment(departmentDTO);
        apiResponseDTO.setEmployee(EmployeeMapper.MAPPER.employeeToEmployeeDTO(employee));

        return apiResponseDTO;
    }

    public APIResponseDTO getDefaultDepartment(Long id, Exception ex) {
        LOGGER.info("Inside getDefaultDepartment() method of EmployeeServiceImpl");
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode("0000");
        departmentDTO.setDepartmentName("Default Department");
        departmentDTO.setDepartmentDescription("Default Department Description");

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setDepartment(departmentDTO);
        apiResponseDTO.setEmployee(EmployeeMapper.MAPPER.employeeToEmployeeDTO(employee));

        return apiResponseDTO;
    }

}
