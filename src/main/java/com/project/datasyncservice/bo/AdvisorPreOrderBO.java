package com.project.datasyncservice.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvisorPreOrderBO {

    private String preOrderId;

    private String expiryDateTime;

    private Long advisorId;

    private String farmerFirstName;

    private String farmerLastName;

    private Long farmerPhone;

    private String cropName;

    private String cropDiseaseName;


}