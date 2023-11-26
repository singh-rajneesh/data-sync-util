package com.project.datasyncservice.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

import java.io.Serializable;

public class S3DataProcessingException extends AmqpRejectAndDontRequeueException implements Serializable {
    private static final long serialVersionUID = 12314512356L;

    private String message;

    public S3DataProcessingException(String message) {
        super(message);
    }
}

