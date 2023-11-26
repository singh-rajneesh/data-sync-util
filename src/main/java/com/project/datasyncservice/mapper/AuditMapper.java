package com.project.datasyncservice.mapper;

import com.project.datasyncservice.dto.BaseDTO;
import com.project.datasyncservice.entity.BaseEntity;
import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@MapperConfig(builder = @Builder(disableBuilder = true))
public interface AuditMapper {


    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "externalId", source = "externalId")
    BaseDTO map(BaseEntity source);

    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "externalId", source = "externalId")
    BaseEntity map(BaseDTO source);

}

