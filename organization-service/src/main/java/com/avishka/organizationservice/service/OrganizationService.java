package com.avishka.organizationservice.service;

import com.avishka.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {

    OrganizationDTO save(OrganizationDTO organizationDTO);

    OrganizationDTO findByCode(String organizationCode);
}
