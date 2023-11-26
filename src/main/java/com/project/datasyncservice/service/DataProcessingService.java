package com.project.datasyncservice.service;

import com.amazonaws.services.s3.model.S3Object;
import com.project.datasyncservice.dto.S3DataDto;
import org.springframework.stereotype.Service;

@Service
public interface DataProcessingService {

    void processData(S3Object object);

    void processData(S3DataDto s3DataDto);

    default S3DataDto prepareS3Data(Object data, String key, String syncDataType) {
        return S3DataDto.builder()
                .objectKey(key)
                .data(data)
                .syncDataType(syncDataType)
                .build();
    }

}
