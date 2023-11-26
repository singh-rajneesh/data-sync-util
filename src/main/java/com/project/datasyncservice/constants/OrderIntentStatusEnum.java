package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@AllArgsConstructor
@Getter
public enum OrderIntentStatusEnum {


    PENDING("PENDING", "CONTACTED", "Advisor Contacted"),
    SUPERSEDED("SUPERSEDED", "REASSIGNED", "Advisor Reassigned"),
    PROCESSED("PROCESSED", "PROCESSED", "Intent Processed"),
    EXPIRED("EXPIRED", "EXPIRED", "Intent Expired");


    private final String orderIntentStatus;
    private final String displayStatus;
    private final String displayStatusTranslated;

    public static OrderIntentStatusEnum getStatusByOrderIntentStatus(String orderIntentStatus) {
        return Arrays.stream(OrderIntentStatusEnum.values())
                .filter(statusEnum -> statusEnum.getOrderIntentStatus().equals(orderIntentStatus))
                .findAny().orElse(null);
    }
}

