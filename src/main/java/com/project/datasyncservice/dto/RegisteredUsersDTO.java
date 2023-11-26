package com.project.datasyncservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;


@Data
public class RegisteredUsersDTO {

    private Integer id;
    private UUID externalId;
    private Long phoneNumber;
    private String name;
    private Integer acquiredUserId;
    private Integer languageId;

    @JsonProperty("isSubscribedWhatsApp")
    private Boolean isSubscribedWhatsApp;

    @JsonIgnore
    private Boolean isAppInstalled;


}
