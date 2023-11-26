package com.project.datasyncservice.entity;

import com.project.datasyncservice.config.ZonedDateTimeDeserializer;
import com.project.datasyncservice.config.ZonedDateTimeSerializer;
import com.project.datasyncservice.model.OrderedProduct;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(collection = "order_detail")
public class OrderDetail extends BaseEntity {

    @Id
    private String id;

    private String registeredUserId;

    private Integer registeredUserInternalId;

    private String orderSource;

    private String farmerPhoneNumber;

    @Indexed(unique = true)
    private String orderId;

    private String orderIntentId;

    private String countryId;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime placedDate;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime fulfilledDate;

    private String status;

    private List<OrderedProduct> products;

    private String advisorUserId;

    private String latitude;

    private String longitude;

    private String farmriseOrderStatus;

}