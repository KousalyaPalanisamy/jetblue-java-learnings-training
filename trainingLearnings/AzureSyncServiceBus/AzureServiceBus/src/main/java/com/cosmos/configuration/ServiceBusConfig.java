package com.cosmos.configuration;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusErrorContext;
import com.azure.messaging.servicebus.ServiceBusException;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

@Configuration
public class ServiceBusConfig {
	@Value("${servicebus.connectionString}")
	private String connectionString;
	@Value("${servicebus.queueName}")
	private String queueName;
	@Value("${servicebus.topicName}")
	private String topicName;
	@Value("${servicebus.subscriptionName1}")
	private String subscriptionName1;
	@Value("${servicebus.subscriptionName2}")
	private String subscriptionName2;
	@Value("${servicebus.subscriptionName3}")
	private String subscriptionName3;
	
	@Bean(name = "ServiceBusQueueSenderClient")
	public ServiceBusSenderClient queueSenderClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
			         .sender()
			         .queueName(queueName)
			         .buildClient();
	}

	@Bean(name = "ServiceBusTopicSenderClient")
	public ServiceBusSenderClient topicSenderClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
					.sender()
			        .topicName(topicName)
			        .buildClient();
	}
	
	@Bean(name = "ServiceBusTopicReceiverClient")
	public ServiceBusReceiverClient receiverClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
		     .receiver()
		     .topicName(topicName)
		     .subscriptionName(subscriptionName2)
		     .buildClient();
	}

    @Bean(name = "ServiceBusQueueProcessorClient")
    public ServiceBusProcessorClient processorClient() {
    	return new ServiceBusClientBuilder()//an instance of the processor through the ServiceBusClientBuilder
        .connectionString(connectionString)
        .processor()
        .queueName(queueName)
        .processMessage(onMessage)
        .processError(onError)
        .buildProcessorClient();
    }
    
    @Bean(name = "ServiceBusTopicProcessorClient")
    public ServiceBusProcessorClient topicProcessorClient() {
    	return new ServiceBusClientBuilder()
        .connectionString(connectionString)
        .processor()
        .topicName(topicName)
        .subscriptionName(subscriptionName3)
        .processMessage(onMessage)
        .processError(onError)
        .buildProcessorClient();
    }
    
        
    Consumer<ServiceBusReceivedMessageContext> onMessage = context -> {
        ServiceBusReceivedMessage message = context.getMessage();
        System.out.printf("Processing message. Sequence #: %s. Contents: %s%n",
            message.getSequenceNumber(), message.getBody());
    };
    
    Consumer<ServiceBusErrorContext> onError = context -> {
        System.out.printf("Error when receiving messages from namespace: '%s'. Entity: '%s'%n",
            context.getFullyQualifiedNamespace(), context.getEntityPath());
    
        if (context.getException() instanceof ServiceBusException) {
            ServiceBusException exception = (ServiceBusException) context.getException();
            System.out.printf("Error source: %s, reason %s%n", context.getErrorSource(),
                exception.getReason());
        } else {
            System.out.printf("Error occurred: %s%n", context.getException());
        }
    };
}
