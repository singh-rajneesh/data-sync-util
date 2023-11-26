package com.project.datasyncservice.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreSignedUrlGenerationBO {

    String userId;

    String fileExtention;

    String referenceName;

    Integer count;

    String fileName;

    String bucketFolder;

    Boolean doCreateDateFolder;

}