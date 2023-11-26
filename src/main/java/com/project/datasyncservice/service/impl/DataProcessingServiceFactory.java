package com.project.datasyncservice.service.impl;


import com.project.datasyncservice.constants.ExceptionConstants;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.service.DataProcessingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class DataProcessingServiceFactory {

    private ProductDataProcessingServiceImpl productDataProcessingService;

    public DataProcessingService getServiceByDataType(S3DataTypesEnum dataType) {
        DataProcessingService dataProcessingService;
        if (Objects.requireNonNull(dataType) == S3DataTypesEnum.PRODUCT_DATA) {
            dataProcessingService = productDataProcessingService;
        } else {
            log.error("DataProcessingService.getProcessingService() :: invalid dataType={}", dataType.getDataContext());
            throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
        }
        return dataProcessingService;
    }
}
