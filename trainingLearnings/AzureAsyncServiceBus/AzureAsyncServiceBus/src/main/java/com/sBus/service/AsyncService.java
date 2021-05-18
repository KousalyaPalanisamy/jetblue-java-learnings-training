package com.sBus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;

import reactor.core.Disposable;

@Service
public class AsyncService 
{
	@Autowired
	@Qualifier("ServiceBusQueueSenderClient")
	ServiceBusSenderAsyncClient senderClient;
	
	@Autowired
	@Qualifier("ServiceBusTopicSenderClient")
	ServiceBusSenderAsyncClient topicSenderClient;
	
	@Autowired
	@Qualifier("ServiceBusQueueReceiverClient")
	ServiceBusReceiverAsyncClient queueReceiverClient;
	
	@Autowired
	@Qualifier("ServiceBusTopicReceiverClient")
	ServiceBusReceiverAsyncClient topicReceiverClient;
	
	public void sendMessageToQueue(String message) {
		senderClient.sendMessage(new ServiceBusMessage(message))
					.subscribe(unused -> {System.out.println("Message Consumed");		 },
						     error -> System.err.println("Error occurred while publishing message:" + error),
						     () -> System.out.println("Send complete"));	
	}
	
	public void sendMessageToTopic(String message) {
		topicSenderClient.sendMessage(new ServiceBusMessage(message).setSessionId("session1"))
							.subscribe(unused -> {System.out.println("Message Consumed");},
									error -> System.err.println("Error occurred while publishing message:" + error),
									() -> System.out.println("Send complete."));	
	}
	
	public void receiveMessagesUsingQueueReceiver()
	{	
		queueReceiverClient.receiveMessages()
					.subscribe(message -> {
						         System.out.printf("Received Queue Seq #: %s%n", message.getSequenceNumber());
						         System.out.printf("Contents of message as string: %s%n", message.getBody());
						         queueReceiverClient.complete(message);},
					         error -> System.out.println("Error occurred: " + error),
						         () -> System.out.println("Receiving complete."));
		
	}
	
	public void receiveMessagesUsingTopicReceiver()
	{	
		topicReceiverClient.receiveMessages()
 						.subscribe(message -> {
							         System.out.printf("Received Topic Seq #: %s%n", message.getSequenceNumber());
							         System.out.printf("Contents of message as string: %s%n", message.getBody());
							         topicReceiverClient.complete(message);},
						         error -> System.out.println("Error occurred: " + error),
						         () -> System.out.println("Receiving complete."));
	}
}
