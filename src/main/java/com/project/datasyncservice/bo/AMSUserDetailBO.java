package com.project.datasyncservice.bo;


import com.project.datasyncservice.dto.AMSLocationDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AMSUserDetailBO implements Serializable {

    private static final long serialVersionUID = -779692990704466519L;


    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_type")
    private String customerType;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("contact_person")
    private String contactPerson;

    @JsonProperty("account_status")
    private String accountStatus;

    @JsonProperty("preferred_language")
    private String preferredLanguage;

    private AMSLocationDto geo;

    @JsonProperty("registration_timestamp")
    private String registrationTimestamp;

}
