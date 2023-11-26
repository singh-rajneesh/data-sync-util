package com.project.datasyncservice.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.support.NotificationMessageArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class SqsConfig {

    @Value("${application.env}")
    private String environment;

    @Value("${cloud.aws.sqs.endpoint}")
    private String endpoint;

    @Value("${sqs.access.key}")
    private String sqsAccessKey;

    @Value("${sqs.secret.key}")
    private String sqsSecretKey;

    @Bean
    public AwsClientBuilder.EndpointConfiguration endpointConfiguration() {
        String region = Regions.AP_SOUTH_1.getName();
        return new AwsClientBuilder.EndpointConfiguration(endpoint, region);
    }

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync(final AwsClientBuilder.EndpointConfiguration endpointConfiguration) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(sqsAccessKey, sqsSecretKey);
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(getClientConfiguration())
                .build();
    }

    @Bean
    public QueueMessageHandlerFactory queueMessageHandlerFactory(MessageConverter messageConverter) {
        QueueMessageHandlerFactory factory = new QueueMessageHandlerFactory();
        factory.setArgumentResolvers(Collections.singletonList(new NotificationMessageArgumentResolver(messageConverter)));
        return factory;
    }

    @Bean("SQSMessageConverter")
    protected MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setSerializedPayloadClass(String.class);
        converter.setStrictContentTypeMatch(false);
        return converter;
    }

    private ClientConfiguration getClientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        if (environment.equalsIgnoreCase("dev")) {
            clientConfiguration.setProtocol(Protocol.HTTP);
        } else {
            clientConfiguration.setProtocol(Protocol.HTTPS);
        }
        return clientConfiguration;
    }
}
