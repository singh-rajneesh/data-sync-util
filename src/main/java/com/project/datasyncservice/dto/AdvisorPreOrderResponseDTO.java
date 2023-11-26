package com.project.datasyncservice.dto;

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
public class AdvisorPreOrderResponseDTO implements Serializable {

    private Boolean status;

    private String message;

    private Long code;

}