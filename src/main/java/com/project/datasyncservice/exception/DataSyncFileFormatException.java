package com.project.datasyncservice.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

import java.io.Serializable;

public class DataSyncFileFormatException extends AmqpRejectAndDontRequeueException implements Serializable {
    private static final long serialVersionUID = 1234512356L;

    private String message;

    public DataSyncFileFormatException(String message) {
        super(message);
    }
}
