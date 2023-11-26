package com.project.datasyncservice.service.impl;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.project.datasyncservice.service.SqsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
@Slf4j
public class SqsServiceImpl implements SqsService {

    @Autowired
    private AmazonSQSAsync amazonSQSAsync;

    @Override
    public void sendAsyncMessageToSQS(String message, String queueUrl) {
        log.info("SqsServiceImpl.sendAsyncMessageToSQS::Called with message = [{}]", message);
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message);

        Future<SendMessageResult> response = amazonSQSAsync.sendMessageAsync(sendMessageRequest);
        try {
            String messageId = response.get().getMessageId();
            log.info("SqsServiceImpl.sendAsyncMessageToSQS::Success in pushing message with ID - [{}] to SQS", messageId);
        } catch (CancellationException | ExecutionException e) {
            log.error("SqsServiceImpl.sendAsyncMessageToSQS::Error occurred while pushing message to SQS", e);
        } catch (InterruptedException exp) {
            log.error("SqsServiceImpl.sendAsyncMessageToSQS::Error occurred while pushing message to SQS", exp);
            Thread.currentThread().interrupt();
        }
    }
}
