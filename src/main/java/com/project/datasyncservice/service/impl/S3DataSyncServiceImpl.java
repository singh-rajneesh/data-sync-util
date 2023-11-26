package com.project.datasyncservice.service.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.climate.constants.LiteralConstants;
import com.project.datasyncservice.constants.AdvisorConstants;
import com.project.datasyncservice.constants.ExceptionConstants;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.dto.aws.AWSEventNotificationDto;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.service.DataSyncService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@AllArgsConstructor
public class S3DataSyncServiceImpl implements DataSyncService {

    private AmazonS3Client s3Client;

    private DataProcessingServiceFactory leadServiceFactory;


    @Override
    public void processFailedData(S3DataDto s3DataDto) {
        log.info("S3DataSyncServiceImpl.processFailedData():: processing s3DataDto={}", s3DataDto);
        // TODO - write data to s3 with objectKey_failed file name

    }

    @Override
    public void processEventNotification(AWSEventNotificationDto event) {
        log.info("S3DataSyncService.processEventNotification() :: received AWSEventNotificationDto={}", event);
        String objectKey = event.getRecords().get(0).getS3().getObject().getOrDefault(LiteralConstants.KEY, null);
        String bucketName = event.getRecords().get(0).getS3().getBucket().getName();
        String decodedObjectKey = UriUtils.decode(objectKey, StandardCharsets.UTF_8);
        if (Objects.nonNull(bucketName) && Objects.nonNull(objectKey)) {
            S3Object s3Object = s3Client.getObject(bucketName, decodedObjectKey);
            processS3Object(s3Object, decodedObjectKey);
        } else {
            log.error("S3DataSyncServiceImpl.processEventNotification() :: invalid objectKey or bucketName");
            throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
        }
    }

    private void processS3Object(S3Object s3Object, String objectKey) {
        String dataContext = getContextFromObjectKey(objectKey);
        S3DataTypesEnum dataType = S3DataTypesEnum.getDataTypeByContext(dataContext);
        leadServiceFactory.getServiceByDataType(dataType).processData(s3Object);
    }

    private String getContextFromObjectKey(String objectKey) {
        if (objectKey.contains("translation")) {
            return S3DataTypesEnum.TRANSLATION.getDataContext();
        }
        Pattern pattern = Pattern.compile(AdvisorConstants.S3_DATA_SYNC_DATA_CONTEXT_REGEX);
        Matcher matcher = pattern.matcher(objectKey);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
