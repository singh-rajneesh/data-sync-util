package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.project.datasyncservice.config.ZonedDateTimeDeserializer;
import com.project.datasyncservice.config.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderIntentDTO extends BaseDTO {

    private String orderIntentId;

    private String registeredUserId;

    private Integer registeredUserInternalId;

    private String context;

    private String referenceId;

    private String advisorId;

    private String status;

    @Translate
    private IntentMetaDataDTO metaData;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime expiryTime;

    private String farmerFirstName;

    private String farmerLastName;

    private Long farmerPhone;

}