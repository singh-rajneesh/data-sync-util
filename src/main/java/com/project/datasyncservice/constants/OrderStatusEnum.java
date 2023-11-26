package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

@ToString
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {

    CREATED("Pending", "CREATED", "Order Created"),
    MODIFIED("Pending", "MODIFIED", "Order Modified"),
    PARTIALLY_FULFILLED("Partially_fulfilled", "PARTIALLY_FULFILLED", "Order Partially Fulfilled"),
    FULFILLED("Fulfilled", "FULFILLED", "Order Fulfilled"),
    EXPIRED("Expired", "EXPIRED", "Order Expired"),
    CANCELLED("Cancelled", "CANCELLED", "Order Cancelled"),
    REJECTED("Rejected", "REJECTED", "Order Rejected");


    public static final Set<OrderStatusEnum> INACTIVE_STATUS = EnumSet.of(CANCELLED, REJECTED, EXPIRED);
    private final String amsStatus;
    private final String farmriseStatus;
    private final String displayText;

    public static OrderStatusEnum getStatusByFarmriseStatus(String farmriseStatus) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(statusEnum -> statusEnum.getFarmriseStatus().equals(farmriseStatus))
                .findAny().orElse(null);
    }

    public static String getFarmriseStatusByStatus(String status) {
        OrderStatusEnum orderStatusEnum = Arrays.stream(OrderStatusEnum.values())
                .filter(statusEnum -> statusEnum.getAmsStatus().equals(status))
                .findAny().orElse(null);
        if (orderStatusEnum == null)
            return null;
        return orderStatusEnum.getFarmriseStatus();
    }

}