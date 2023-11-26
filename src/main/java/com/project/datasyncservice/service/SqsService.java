package com.project.datasyncservice.service;

import org.springframework.stereotype.Service;

@Service
public interface SqsService {

    /**
     * This method provides asynchronous mechanism for sending message to SQS
     * @param message : Message body
     * @param queueUrl : SQS Queue URL
     * */
    void sendAsyncMessageToSQS(String message, String queueUrl);
}
