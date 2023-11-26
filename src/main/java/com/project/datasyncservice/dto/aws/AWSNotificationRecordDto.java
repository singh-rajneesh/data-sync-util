package com.project.datasyncservice.dto.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AWSNotificationRecordDto {

    private String eventVersion;
    private String eventSource;
    private String eventName;
    private String eventTime;
    private String awsRegion;

    private Map<String,String> userIdentity;
    private Map<String,String> requestParameters;
    private Map<String,String> responseElements;
    private S3NotificationObjectDto s3;
}
