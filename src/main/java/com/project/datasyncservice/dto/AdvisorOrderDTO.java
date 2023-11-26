package com.project.datasyncservice.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdvisorOrderDTO {

    private Boolean advisorMultiplierApplied;

    private String orderId;
}
