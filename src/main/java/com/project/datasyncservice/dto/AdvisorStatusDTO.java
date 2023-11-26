package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvisorStatusDTO {

    private String advisorId;

    @Translate
    private String advisorName;

    private String status;

    @Translate
    private String statusDisplayText;
}