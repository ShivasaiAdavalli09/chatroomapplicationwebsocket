package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.model.Message;


//learn code with durgesh channel https://www.youtube.com/watch?v=bBQnWcbxDo8&t=1106s
@RestController
public class MessagController {

	//any client who will send message will send at this url
	@MessageMapping("/message")
	//this message will be sent to all whoever subscribed to this url
	@SendTo("/topic/return-to")
	//whatever messages come and connectivity of that to server will be configured in other class using message broker
	//in Config class
	public Message getContent(@RequestBody Message message){
		
		try{
			//if want to process and save db or anything we want to do
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	return message;
		 }
	
}
