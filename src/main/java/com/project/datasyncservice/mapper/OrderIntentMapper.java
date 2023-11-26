package com.project.datasyncservice.mapper;

import com.project.datasyncservice.bo.OrderIntentClientRequestBO;
import com.project.datasyncservice.dto.OrderIntentDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface OrderIntentMapper {

    @Mapping(source = "id", target = "orderIntentId")
    @InheritConfiguration
    OrderIntentDTO map(OrderIntent source);

    @Mapping(target = "id", source = "orderIntentId")
    @InheritConfiguration
    OrderIntent map(OrderIntentDTO source);

    OrderIntentDTO map(OrderIntentClientRequestBO orderClientRequestBO);

    default List<OrderIntentDTO> map(List<OrderIntent> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}