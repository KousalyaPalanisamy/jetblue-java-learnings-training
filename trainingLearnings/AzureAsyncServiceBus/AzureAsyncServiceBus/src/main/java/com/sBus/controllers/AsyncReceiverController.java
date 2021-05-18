package com.sBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sBus.service.AsyncService;

@RestController
public class AsyncReceiverController 
{
	@Autowired
	private AsyncService asyncReceiverService;
	
	@GetMapping("/messagesfromQueueUsingReceiver")
	public ResponseEntity<Void> getMessagesFromQueueUsingReceiver() {
		asyncReceiverService.receiveMessagesUsingQueueReceiver();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/messagesfromTopicUsingReceiver")
	public ResponseEntity<Void> getMessagesFromTopicUsingReceiver() {
		asyncReceiverService.receiveMessagesUsingTopicReceiver();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
