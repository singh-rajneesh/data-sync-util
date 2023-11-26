package com.project.datasyncservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@JsonSerialize
@RequiredArgsConstructor
public class AzureResponseDTO {

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("extExpiresIn")
    private String extExpiresIn;

    @JsonProperty("expires_on")
    private String expiresOn;

    @JsonProperty("not_before")
    private String notBefore;

    @JsonProperty("resource")
    private String resource;

    @JsonProperty("access_token")
    private String accessToken;
}
