package com.avishka.organizationservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long id;
    @NotNull(message = "Please provide an organization name")
    private String organizationName;
    private String organizationDescription;
    @NotNull(message = "Please provide an organization code")
    private String organizationCode;
    private LocalDateTime createdDate;
}
