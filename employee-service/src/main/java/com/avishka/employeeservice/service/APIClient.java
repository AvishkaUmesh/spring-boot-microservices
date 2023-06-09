package com.avishka.employeeservice.service;

import com.avishka.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface APIClient {

    @GetMapping("/api/departments/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("code") String departmentCode);
}
