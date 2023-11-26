package com.project.datasyncservice.mapper;

import com.project.datasyncservice.bo.PurchaseRequestBO;
import com.project.datasyncservice.constants.PurchaseStatusEnum;
import com.project.datasyncservice.dto.PurchaseDetailDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface PurchaseDetailMapper {

    @InheritConfiguration
    @Mapping(target = "statusDisplayText", source = "status", qualifiedByName = "getDisplayText")
    PurchaseDetailDTO map(PurchaseDetail source);

    @InheritConfiguration
    PurchaseDetail map(PurchaseDetailDTO source);

    PurchaseDetailDTO map(PurchaseRequestBO purchaseRequestBO);

    default List<PurchaseDetailDTO> map(List<PurchaseDetail> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    @Named("getDisplayText")
    default String getDisplayText(String status) {
        return PurchaseStatusEnum.getPurchaseStatus(status).getDisplayText();
    }

}