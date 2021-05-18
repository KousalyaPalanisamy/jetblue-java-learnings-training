package com.cosmos.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
@Service
public class SendAndReceiveService 
{
	@Autowired
	@Qualifier("ServiceBusQueueSenderClient")
	ServiceBusSenderClient senderClient;
	
	@Autowired
	@Qualifier("ServiceBusTopicSenderClient")
	ServiceBusSenderClient topicSenderClient;
	
	@Autowired
	@Qualifier("ServiceBusTopicReceiverClient")
	ServiceBusReceiverClient topicReceiverClient;
	
	@Autowired
	@Qualifier("ServiceBusQueueProcessorClient")
	ServiceBusProcessorClient processorClient;
	
	@Autowired
	@Qualifier("ServiceBusTopicProcessorClient")
	ServiceBusProcessorClient topicProcessorClient;
	
	public void sendMessageToQueue(String message) {
		senderClient.sendMessage(new ServiceBusMessage(message));	
	}
	
	public void sendMessageToTopic(String message) {
		topicSenderClient.sendMessage(new ServiceBusMessage(message).setSessionId("session1"));	
	}
	
	public void receiveMessagesFromQueue() throws InterruptedException
	{
		System.out.println("Starting the processor for Queue");
	    processorClient.start();

	    TimeUnit.SECONDS.sleep(10);
	    System.out.println("Stopping and closing the processor for Queue");
	    processorClient.close();
	}
	
	public void receiveMessagesFromTopic() throws InterruptedException
	{
		System.out.println("Starting the processor for Topic");
		topicProcessorClient.start();

	    TimeUnit.SECONDS.sleep(10);
	    System.out.println("Stopping and closing the processor for Topic");
	    topicProcessorClient.close();
	}
	
	public void receiveMessagesUsingTopicReceiver(int maxMessages)
	{
//		Disposable subscription = topicReceiverClient.receiveMessages()
//			     .subscribe(message -> 
//						     {
//						         System.out.printf("Received Seq #: %s%n", message.getSequenceNumber());
//						         System.out.printf("Contents of message as string: %s%n", message.getBody());
//						     },
//				         error -> System.out.println("Error occurred: " + error),
//				         () -> System.out.println("Receiving complete."));
//			 subscription.dispose();
		if (maxMessages <= 0) {
            throw new IllegalArgumentException(
                "'maxMessages' cannot be less than or equal to 0. maxMessages: " + maxMessages);
        }
		topicReceiverClient.receiveMessages(maxMessages).forEach(message-> {System.out.println(message.getBody());
		topicReceiverClient.complete(message);	
		});
			 topicReceiverClient.close();
	}
	
}
