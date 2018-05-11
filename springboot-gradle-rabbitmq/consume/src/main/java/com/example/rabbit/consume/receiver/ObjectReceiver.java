package com.example.rabbit.consume.receiver;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

	@RabbitHandler
	public void process(Map<String, String> map) {
		System.out.println("Object Receiver: " + JSONObject.toJSONString(map));
	}
}
