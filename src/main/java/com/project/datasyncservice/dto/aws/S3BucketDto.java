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
public class S3BucketDto {

    private String name;
    private Map<String, String> ownerIdentity;
    private String arn;
}
