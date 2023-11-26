package com.project.datasyncservice.dto;

import com.project.datasyncservice.model.UserGeoLocation;
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
public class UserDetailDTO extends BaseDTO {

    private String farmerUserId;

    private String farmerName;

    private String mobileNumber;

    private UserGeoLocation location;

    private AMSLocationDto locationHierarchy;

    private Integer preferredLanguageId;

    private String status;
}