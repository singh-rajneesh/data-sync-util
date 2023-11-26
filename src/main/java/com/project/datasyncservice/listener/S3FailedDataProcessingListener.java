package com.project.datasyncservice.listener;


import com.climate.async.model.Event;
import com.climate.event.listener.EventListener;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.service.DataSyncService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component(value = "S3DataProcessingDlqListener")
@RequiredArgsConstructor
@Slf4j
public class S3FailedDataProcessingListener extends EventListener {

    private final DataSyncService dataSyncService;

    private final ObjectMapper objectMapper;

    /**
     * TODO remove this listener as its no longer required after API integration with AMS
     *
     * @param event containing object key and sync data type of failed data
     */
    @Override
    @RabbitListener(queues = OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE_DLQ, containerFactory = "simpleRabbitListenerContainerFactory")
    protected void processEvent(Event event) {
        super.processEvent(event);
        log.info("S3FailedDataProcessingListener.processEvent() :: Event [{}]", event.getPayload());
        S3DataDto s3DataDto = objectMapper.convertValue(event.getPayload(), S3DataDto.class);
        dataSyncService.processFailedData(s3DataDto);
    }
}
