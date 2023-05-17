package com.avishka.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "Department",
        description = "Department DTO"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @Schema(
            description = "Department Name",
            example = "IT"
    )
    @NotEmpty(message = "Please provide a department name")
    private String departmentName;

    @Schema(
            description = "Department Description",
            example = "Information Technology"
    )
    @NotEmpty(message = "Please provide a department description")
    private String departmentDescription;

    @Schema(
            description = "Department Code",
            example = "IT-001"
    )
    @NotEmpty
    private String departmentCode;
}
