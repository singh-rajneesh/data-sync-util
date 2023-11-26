package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import com.project.datasyncservice.model.OrderedProduct;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRecordDTO {

    private String orderId;

    private String orderIntentId;

    private String orderSource;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime placedDate;

    private String status;

    private String cropName;

    private String diseaseName;

    @Translate
    private List<OrderedProduct> products;

    private String orderStatus;

    @Translate
    private String orderStatusDisplayText;

    private String externalId;

}