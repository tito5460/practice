package com.example.rabbit.produce.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String str = "Fanout Sender";
		System.out.println(str);
		this.rabbitTemplate.convertAndSend("fanoutExchange", "", str);
	}

}