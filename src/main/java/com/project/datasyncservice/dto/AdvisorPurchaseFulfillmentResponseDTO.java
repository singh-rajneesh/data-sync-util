package com.project.datasyncservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
@JsonSerialize
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvisorPurchaseFulfillmentResponseDTO implements Serializable {

    @JsonProperty("status_flag")
    private Boolean statusFlag;

    @JsonProperty("message_response")
    private String messageResponse;

    @JsonProperty("status_code")
    private Long statusCode;

}