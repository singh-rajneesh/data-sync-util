package com.project.datasyncservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisteredUserInternalDTO {
    private Integer id;
    private UUID externalId;
    private Long phoneNumber;
    private Integer acquiredUserId;
    private Integer languageId;
    private String state;
    private String deviceId;
}