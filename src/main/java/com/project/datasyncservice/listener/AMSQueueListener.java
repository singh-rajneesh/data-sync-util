package com.project.datasyncservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.datasyncservice.dto.aws.AWSEventNotificationDto;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.service.DataSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AMSQueueListener {

    private final ObjectMapper objectMapper;

    private final DataSyncService dataSyncService;

    /**
     * This listener is being used only for data sync from AMS for product
     */
    @SqsListener(value = "${ams.shared.data.event.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consume(String payload) {
        if (payload != null) {
            log.info("AMSQueueListener.consume() :: Received event for consumer : " + payload);
            try {
                AWSEventNotificationDto event = objectMapper.readValue(payload, AWSEventNotificationDto.class);
                dataSyncService.processEventNotification(event);
            } catch (Exception e) {
                log.error("AMSQueueListener.consume() :: error while consuming payload, exception = ", e);
                handleListenerException(e);
            }

        }
    }

    private void handleListenerException(Exception exception) {
        log.error("AMSQueueListener.handleListenerException() :: handling exception, e= ", exception);
        if (exception instanceof DataSyncFileFormatException) {
            // TODO - integrate a teams webhook here
            log.error("AMSQueueListener.handleListenerException() :: handled exception in data file format", exception);
        } else {
            log.error("AMSQueueListener.handleListenerException() :: handled exception, e= ", exception);
        }
    }
}