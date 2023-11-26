package com.project.datasyncservice.mapper;

import com.project.datasyncservice.bo.AdvisorPreOrderBO;
import com.project.datasyncservice.dto.OrderIntentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdvisorPreOrderMapper {

    @Mapping(target = "preOrderId", source = "orderIntentId")
    AdvisorPreOrderBO map(OrderIntentDTO source);

}