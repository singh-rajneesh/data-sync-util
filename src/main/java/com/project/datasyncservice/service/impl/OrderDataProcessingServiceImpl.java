package com.project.datasyncservice.service.impl;

import com.amazonaws.services.s3.model.S3Object;
import com.climate.event.gateway.QueueGateway;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.constants.ExceptionConstants;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.dto.OrderDetailDTO;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.service.DataProcessingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value = "ORDER_PROCESSOR")
@RequiredArgsConstructor
public class OrderDataProcessingServiceImpl implements DataProcessingService {

    private final ObjectMapper objectMapper;

    private final QueueGateway queueGateway;


    @Override
    public void processData(S3Object object) {
        try {
            List<OrderDetailDTO> orderDetails = objectMapper.readValue(object.getObjectContent(),
                    new TypeReference<List<OrderDetailDTO>>() {
                    });
            orderDetails.forEach(orderDetail -> queueGateway.pushEventToQueue(prepareS3Data(orderDetail, object.getKey(), S3DataTypesEnum.ORDER_DATA.getDataContext()),
                    OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE));
        } catch (Exception e) {
            throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
        }
    }

    @Override
    public void processData(S3DataDto s3DataDto) {
        log.info("OrderDataProcessingServiceImpl.processData():: processing s3DataDto={}", s3DataDto);
        OrderDetailDTO orderDetailDTO = objectMapper.convertValue(s3DataDto.getData(), OrderDetailDTO.class);
        OrderDetailDTO savedOrder = null;
        log.info("OrderDataProcessingServiceImpl.processData():: saved order data={}", savedOrder);
    }

}
