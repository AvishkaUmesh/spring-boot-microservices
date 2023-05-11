package com.avishka.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotEmpty(message = "Please provide a department name")
    private String departmentName;

    @NotEmpty(message = "Please provide a department description")
    private String departmentDescription;

    @NotEmpty
    private String departmentCode;
}
