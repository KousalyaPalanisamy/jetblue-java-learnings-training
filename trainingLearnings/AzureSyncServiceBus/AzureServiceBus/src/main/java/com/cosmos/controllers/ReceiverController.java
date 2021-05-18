package com.cosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.service.SendAndReceiveService;

@RestController
public class ReceiverController 
{
	@Autowired
	private SendAndReceiveService receiverService;
	
	@GetMapping("/messagesfromQueue")
	public ResponseEntity<Void> getMessagesFromQueue() throws InterruptedException{
		receiverService.receiveMessagesFromQueue();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/messagesfromTopic")
	public ResponseEntity<Void> getMessagesFromTopic() throws InterruptedException{
		receiverService.receiveMessagesFromTopic();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/messagesfromTopicUsingReceiver")
	public ResponseEntity<Void> getMessagesFromTopicUsingReceiver(@RequestParam int maxMessages) {
		receiverService.receiveMessagesUsingTopicReceiver(maxMessages);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
