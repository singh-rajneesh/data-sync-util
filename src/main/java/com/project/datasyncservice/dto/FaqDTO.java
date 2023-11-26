package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaqDTO extends BaseDTO {

    @Translate
    private String title;

    @Translate
    private String answer;
}