package com.sBus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sBus.service.AsyncService;

@RestController
public class AsyncSenderController 
{
	@Autowired
	private AsyncService asyncSendService;
	
	@PostMapping("/sendMessageToQueue")
	public ResponseEntity<?> sendMessageToQueue(@RequestBody String message){
		asyncSendService.sendMessageToQueue(message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/sendMessageToTopic")
	public ResponseEntity<?> sendMessageToTopic(@RequestBody String message){
		asyncSendService.sendMessageToTopic(message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
