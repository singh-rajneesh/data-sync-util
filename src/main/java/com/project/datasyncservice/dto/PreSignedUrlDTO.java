package com.project.datasyncservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreSignedUrlDTO {

    private String syncDataType;

    private String objectKey;

    private String url;

}