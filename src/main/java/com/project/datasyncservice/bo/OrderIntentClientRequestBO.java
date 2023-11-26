package com.project.datasyncservice.bo;

import com.project.datasyncservice.dto.IntentMetaDataDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderIntentClientRequestBO {

    private String registeredUserId;

    private Integer registeredUserInternalId;

    private String featureName;

    private  String referenceId;

    private String advisorId;

    @Valid
    private IntentMetaDataDTO metaData;

}