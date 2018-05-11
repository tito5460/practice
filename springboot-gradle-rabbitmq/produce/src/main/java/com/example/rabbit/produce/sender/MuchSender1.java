package com.example.rabbit.produce.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MuchSender1 {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(String str) {
		String content = "Much Sender1: " + str;
		System.out.println(content);
		rabbitTemplate.convertAndSend("much", content);
	}
}
