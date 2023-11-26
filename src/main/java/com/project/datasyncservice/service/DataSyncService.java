package com.project.datasyncservice.service;

import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.dto.aws.AWSEventNotificationDto;
import org.springframework.stereotype.Service;

@Service
public interface DataSyncService {
    void processEventNotification(AWSEventNotificationDto event);

    void processFailedData(S3DataDto s3DataDto);
}