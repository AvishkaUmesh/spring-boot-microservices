package com.avishka.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avishka.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);

}
