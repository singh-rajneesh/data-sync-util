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
public enum PurchaseStatusEnum {

    ORDERED("ORDERED", "Purchase Ordered"),
    PURCHASED("PURCHASED", "Purchased"),
    EXPIRED("EXPIRED", "Order Expired"),
    ALTERNATE_PURCHASED("ALTERNATE_PURCHASED", "Alternate Purchased");


    public static final Set<PurchaseStatusEnum> INACTIVE_STATUS = EnumSet.of(EXPIRED, ALTERNATE_PURCHASED);
    private final String purchaseStatus;
    private final String displayText;

    public static PurchaseStatusEnum getPurchaseStatus(String purchaseStatus) {
        return Arrays.stream(PurchaseStatusEnum.values())
                .filter(statusEnum -> statusEnum.getPurchaseStatus().equals(purchaseStatus))
                .findAny().orElse(null);
    }
}

