package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.client.dto.AdvisorGeoLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvisorDetailSyncDTO implements Serializable {

    @JsonProperty("customer_id")
    @NotBlank
    private String customerId;

    @JsonProperty("customer_type")
    @NotBlank
    private String customerType;

    @JsonProperty("phone_number")
    @NotBlank
    private String phoneNumber;

    @JsonProperty("contact_person")
    @NotBlank
    private String contactPerson;

    @JsonProperty("account_status")
    @NotBlank
    private String accountStatus;

    @JsonProperty("geo")
    private AdvisorGeoLocation geo;

    @JsonProperty("assigned_village_apac_code")
    @NotNull
    private List<@NotBlank String> assignedVillageApacCode;

    @JsonProperty("registration_timestamp")
    private String registrationTimestamp;

}