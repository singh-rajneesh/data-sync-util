package com.project.datasyncservice.dto;

import com.climate.enums.UserRolesEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FarmerProfileDTO {
    private Integer id;
    private UUID externalId;
    private Integer otpVerificationId;
    private Long phoneNumber;
    private String name;
    private String imageURL;
    private boolean optedOut;
    private UserRolesEnum userRole;
}
