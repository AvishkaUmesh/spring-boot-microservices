package com.avishka.organizationservice.controller;

import com.avishka.organizationservice.dto.OrganizationDTO;
import com.avishka.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization",
        description = "Organization API"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Save an organization",
            description = "Save an organization object"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public ResponseEntity<OrganizationDTO> save(@RequestBody @Valid OrganizationDTO organizationDTO) {
        return new ResponseEntity<>(organizationService.save(organizationDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find an organization by code",
            description = "Find an organization object by code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDTO> findByCode(@PathVariable String organizationCode) {
        return new ResponseEntity<>(organizationService.findByCode(organizationCode), HttpStatus.OK);
    }
}
