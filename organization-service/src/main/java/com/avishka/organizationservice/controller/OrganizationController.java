package com.avishka.organizationservice.controller;

import com.avishka.organizationservice.dto.OrganizationDTO;
import com.avishka.organizationservice.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDTO> save(@RequestBody @Valid OrganizationDTO organizationDTO) {
        return new ResponseEntity<>(organizationService.save(organizationDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDTO> findByCode(@PathVariable String organizationCode) {
        return new ResponseEntity<>(organizationService.findByCode(organizationCode), HttpStatus.OK);
    }
}
