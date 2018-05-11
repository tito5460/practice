package com.example.rabbit.produce.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send1() {
		String str = "Topic Sender: topic.message";
		System.out.println(str);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", str);
	}

	public void send2() {
		String str = "Topic Sender: topic.messages++";
		System.out.println(str);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", str);
	}

	public void send3() {
		String str = "Topic Sender: topic.1";
		System.out.println(str);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", str);
	}
	
	public void send4() {
		String str = "Topic Sender: topic.2";
		System.out.println(str);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.2", str);
	}

}