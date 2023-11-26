package com.project.datasyncservice.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PurchasedRewardEventDTO {

    private String registeredUserId;
    private Integer rewardsEarned;
    private AdvisorOrderDTO advisorOrder;
    private TransactionEventDataDTO qrCodeDetail;
}



