package com.sBus.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;

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
	public ServiceBusSenderAsyncClient queueSenderClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
			         .sender()
			         .queueName(queueName)
			         .buildAsyncClient();
	}

	@Bean(name = "ServiceBusTopicSenderClient")
	public ServiceBusSenderAsyncClient topicSenderClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
					.sender()
					.topicName(topicName)
					.buildAsyncClient();
	}
	
	@Bean(name = "ServiceBusQueueReceiverClient")
	public ServiceBusReceiverAsyncClient queueReceiverClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
				     .receiver()
				     .queueName(queueName)
				     .buildAsyncClient();
	}
	
	@Bean(name = "ServiceBusTopicReceiverClient")
	public ServiceBusReceiverAsyncClient receiverClient() {
		return new ServiceBusClientBuilder().connectionString(connectionString)
				     .receiver()
				     .topicName(topicName)
				     .subscriptionName(subscriptionName2)
				     .buildAsyncClient();
	}

   
}

