package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.project.datasyncservice.config.ZonedDateTimeDeserializer;
import com.project.datasyncservice.config.ZonedDateTimeSerializer;
import com.project.datasyncservice.model.OrderedProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.ZonedDateTime;
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
public class OrderDetailDTO extends BaseDTO {

    private String id;

    private String registeredUserId;

    private Integer registeredUserInternalId;

    private String orderSource;

    private String orderId;

    private String orderIntentId;

    private String countryId;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime placedDate;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @With
    private ZonedDateTime fulfilledDate;

    @With
    private String status;

    @With
    @Translate
    private List<OrderedProduct> products;

    private String advisorUserId;

    private String farmerPhoneNumber;

    private String latitude;

    private String longitude;

    private String orderStatus;

    @Translate
    private String orderStatusDisplayText;

    private Integer totalRewards;

    private Boolean isMultiplierApplied;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime scanExpiryDate;


}