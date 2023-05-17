package com.avishka.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "Employee",
        description = "Employee DTO"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @Schema(
            description = "First name of the employee",
            example = "John"
    )
    @NotEmpty(message = "Please provide a first name")
    private String firstName;

    @Schema(
            description = "Last name of the employee",
            example = "Doe"
    )
    @NotEmpty(message = "Please provide a last name")
    private String lastName;

    @Schema(
            description = "Email of the employee",
            example = "test@test.com"
    )
    @NotEmpty(message = "Please provide an email")
    @Email(message = "Please provide a valid email")
    private String email;

    @Schema(
            description = "Employee department code",
            example = "IT-001"
    )
    @NotEmpty(message = "Please provide a department code")
    private String departmentCode;

    @Schema(
            description = "Employee organization code",
            example = "ORG-001"
    )
    @NotEmpty(message = "Please provide an organization code")
    private String organizationCode;

}
