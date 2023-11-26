package com.project.datasyncservice.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransactionEventDataDTO {

    private String qrCode;
    private Integer scanCount;
    private Long scanTime;
    private String productId;
    private String productName;
    private String packSize;
    private Boolean purchased;
    private String scannedBy;
    private String materialCode;
    private String batchNo;
    private String mfgDate;
    private String expDate;
    private Integer agrowSmartProductId;

}
