package com.avishka.organizationservice.mapper;

import com.avishka.organizationservice.dto.OrganizationDTO;
import com.avishka.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {

    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDTO organizationToOrganizationDTO(Organization organization);

    @Mapping(target = "organizationCode", source = "organizationCode")
    Organization organizationDTOToOrganization(OrganizationDTO organizationDTO);
}
