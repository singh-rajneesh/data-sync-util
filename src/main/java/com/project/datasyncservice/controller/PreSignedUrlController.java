package com.project.datasyncservice.controller;

import com.climate.bo.MobileApiResponseBO;
import com.climate.util.FarmRiseCommonUtils;
import com.project.datasyncservice.service.impl.PreSignedUrlService;
import com.project.datasyncservice.constants.AppHeaderConstants;
import com.project.datasyncservice.dto.PreSignedUrlDTO;
import com.project.datasyncservice.validation.ValuesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class PreSignedUrlController {

    private final PreSignedUrlService preSignedUrlService;

    /**
     * This API will be used to get pre-signed urls which will be used to upload data
     *
     * @param syncDataType type for which url needs to be generated
     * @return ResponseEntity having pre-signed Urls
     */
    @GetMapping("v1/pre-signed/urls")
    public ResponseEntity<MobileApiResponseBO> getPreSignedUrls(
            @RequestParam(name = AppHeaderConstants.QUERY_PARAM_SYNC_DATA_TYPE)
            @ValuesAllowed(values = {"user", "order", "product"}) List<String> syncDataType) {
        List<PreSignedUrlDTO> urlDTOList = preSignedUrlService.getPreSignedURLs(syncDataType);
        return FarmRiseCommonUtils.getResponseEntity(urlDTOList, null, HttpStatus.OK);
    }
}