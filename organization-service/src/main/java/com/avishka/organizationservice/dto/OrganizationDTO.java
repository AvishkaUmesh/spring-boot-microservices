package com.avishka.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(name = "Organization", description = "Organization API")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long id;
    @Schema(
            description = "Organization name",
            example = "Organization 1"
    )
    @NotNull(message = "Please provide an organization name")
    private String organizationName;
    @Schema(
            description = "Organization description",
            example = "Organization 1 description"
    )
    private String organizationDescription;
    @Schema(
            description = "Organization code",
            example = "ORG-001"
    )
    @NotNull(message = "Please provide an organization code")
    private String organizationCode;
    @Schema(
            description = "Organization created date",
            example = "2021-08-01T00:00:00"
    )
    private LocalDateTime createdDate;
}
