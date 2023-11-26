package com.project.datasyncservice.mapper;

import com.project.datasyncservice.constants.OrderStatusEnum;
import com.project.datasyncservice.dto.OrderRecordDTO;
import com.project.datasyncservice.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderRecordMapper {
    @Mapping(source = "farmriseOrderStatus", target = "orderStatus")
    @Mapping(target = "orderStatusDisplayText", source = "farmriseOrderStatus", qualifiedByName = "getDisplayText")
    OrderRecordDTO map(OrderDetail source);

    @Mapping(target = "farmriseOrderStatus", source = "orderStatus")
    OrderDetail map(OrderRecordDTO source);

    default List<OrderRecordDTO> map(List<OrderDetail> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    default ZonedDateTime map(LocalDateTime value) {
        return value.atZone(ZoneId.of("UTC"));
    }

    @Named("getDisplayText")
    default String getDisplayText(String farmriseOrderStatus) {
        return OrderStatusEnum.getStatusByFarmriseStatus(farmriseOrderStatus).getDisplayText();
    }

}
