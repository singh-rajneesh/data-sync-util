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
public class S3NotificationObjectDto {

    private String s3SchemaVersion;
    private String configurationId;
    private S3BucketDto bucket;
    private Map<String, String> object;

}


