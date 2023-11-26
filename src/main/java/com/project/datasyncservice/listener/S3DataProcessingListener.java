package com.project.datasyncservice.listener;

import com.climate.async.model.Event;
import com.climate.event.listener.EventListener;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.service.impl.DataProcessingServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component(value = "S3DataProcessingListener")
@RequiredArgsConstructor
@Slf4j
public class S3DataProcessingListener extends EventListener {

    private final DataProcessingServiceFactory leadServiceFactory;

    private final ObjectMapper objectMapper;

    /**
     * This listener is currently being used for product data sync
     *
     * @param event containing object key and sync data type
     */
    @Override
    @RabbitListener(queues = OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE, containerFactory = "simpleRabbitListenerContainerFactory")
    protected void processEvent(Event event) {
        super.processEvent(event);
        log.info("S3DataProcessingListener.processEvent() :: Event [{}]", event.getPayload());
        S3DataDto s3DataDto = objectMapper.convertValue(event.getPayload(), S3DataDto.class);
        leadServiceFactory.getServiceByDataType(S3DataTypesEnum.getDataTypeByContext(s3DataDto.getSyncDataType()))
                .processData(s3DataDto);
    }
}