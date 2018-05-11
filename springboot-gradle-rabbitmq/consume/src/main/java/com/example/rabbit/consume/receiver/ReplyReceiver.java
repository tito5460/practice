package com.example.rabbit.consume.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "reply")
// TODO 待实现
public class ReplyReceiver {

	// TODO 启动就报错
//	@RabbitHandler
//	public String process(String message) {
//		System.out.println("Reply Receiver: " + message);
//		return "Reply Receiver, " + message;
//	}
	
	@RabbitHandler
	public void process(String message) {
		System.out.println("Reply Receiver: " + message);
	}
}
