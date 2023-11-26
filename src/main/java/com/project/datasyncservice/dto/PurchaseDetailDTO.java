package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.project.datasyncservice.config.ZonedDateTimeDeserializer;
import com.project.datasyncservice.config.ZonedDateTimeSerializer;
import com.project.datasyncservice.model.QRCodeDetail;
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
public class PurchaseDetailDTO extends BaseDTO {

    private String id;

    private String registeredUserId;

    private Integer registeredUserInternalId;

    private String orderId;

    private String advisorUserId;

    private String productOrderQuantity;

    @Translate
    private String productName;

    private String productImageUrl;

    private Double productSize;

    @Translate
    private String productSizeUnit;

    private Boolean isMultiplierApplied;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime purchaseDate;

    private String purchaseSource;

    private int totalRewards;

    private String productId;

    private String status;

    @Translate
    private String statusDisplayText;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime scanExpiryDate;

    private String qrCodeIdentifier;

    private QRCodeDetail qrCodeDetail;

    private Boolean active;

}
