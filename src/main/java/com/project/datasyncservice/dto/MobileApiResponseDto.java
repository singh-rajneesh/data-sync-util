package com.project.datasyncservice.dto;

import com.project.datasyncservice.config.MobileApiResponseMetaData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
@JsonSerialize
@RequiredArgsConstructor
public class MobileApiResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient MobileApiResponseMetaData metaData;

}
