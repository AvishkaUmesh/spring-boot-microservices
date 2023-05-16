package com.avishka.organizationservice.service.impl;

import com.avishka.organizationservice.dto.OrganizationDTO;
import com.avishka.organizationservice.entity.Organization;
import com.avishka.organizationservice.exception.OrganizationAlreadyExistException;
import com.avishka.organizationservice.exception.ResourceNotFoundException;
import com.avishka.organizationservice.mapper.OrganizationMapper;
import com.avishka.organizationservice.repository.OrganizationRepository;
import com.avishka.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO save(OrganizationDTO organizationDTO) {

        Optional<Organization> organizationByOrganizationCode = organizationRepository.findByOrganizationCode(organizationDTO.getOrganizationCode());

        if (organizationByOrganizationCode.isPresent()) {
            throw new OrganizationAlreadyExistException("Organization with organization code " + organizationDTO.getOrganizationCode() + " already exist");
        }

        Organization organization = OrganizationMapper.MAPPER.organizationDTOToOrganization(organizationDTO);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.MAPPER.organizationToOrganizationDTO(savedOrganization);
    }

    @Override
    public OrganizationDTO findByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "organizationCode", organizationCode));

        return OrganizationMapper.MAPPER.organizationToOrganizationDTO(organization);
    }
}
