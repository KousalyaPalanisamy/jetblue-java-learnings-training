package com.cosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.service.SendAndReceiveService;

@RestController
public class SenderController 
{
	@Autowired
	private SendAndReceiveService sendService;
	
	@PostMapping("/sendMessageToQueue")
	public ResponseEntity<?> sendMessageToQueue(@RequestBody String message){
		sendService.sendMessageToQueue(message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/sendMessageToTopic")
	public ResponseEntity<?> sendMessageToTopic(@RequestBody String message){
		sendService.sendMessageToTopic(message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
