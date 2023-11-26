package com.project.datasyncservice.mapper;

import com.project.datasyncservice.constants.OrderStatusEnum;
import com.project.datasyncservice.dto.OrderDetailDTO;
import com.project.datasyncservice.entity.OrderDetail;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface OrderDetailMapper {

    @Mapping(source = "farmriseOrderStatus", target = "orderStatus")
    @Mapping(target = "orderStatusDisplayText", source = "farmriseOrderStatus", qualifiedByName = "getDisplayText")
    @InheritConfiguration
    OrderDetailDTO map(OrderDetail source);

    @Mapping(target = "farmriseOrderStatus", source = "orderStatus")
    @InheritConfiguration
    OrderDetail map(OrderDetailDTO source);

    OrderDetailDTO map(OrderCreateRequestBO orderCreateRequestBO);

    List<OrderDetailDTO> map(List<OrderDetail> orderDetails);

    @Named("getDisplayText")
    default String getDisplayText(String farmriseOrderStatus) {
        return OrderStatusEnum.getStatusByFarmriseStatus(farmriseOrderStatus).getDisplayText();
    }

}