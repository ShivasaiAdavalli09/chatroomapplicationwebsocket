package com.chat.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;



@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer{

	public void registerStompEndpoints(StompEndpointRegistry registry) {
	//we are trying to configure server connection
	//with sock js as we are trying to interact with js frontend
	registry.addEndpoint("/server1").withSockJS();
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//this is destination prefix ,this topic url will be used for broadcast as we gave /topic/...
		//in MessageController
		registry.enableSimpleBroker("/topic");
		//this can be anything and whoever sends message will send by /app/..,
		//that is first message will be send to app and then message
		registry.setApplicationDestinationPrefixes("/app");
	}
}
//to connect with server: /server1
//to send message: /app/message{}
//to receive or subscribe so that to receive messages: /topic/return-to
//now create static foder in resources

