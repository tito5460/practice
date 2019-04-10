package com.example.rabbit.produce.sender;

import java.util.Map;

import net.minidev.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(Map<String, String> map) {
		System.out.println("Object Sender: " + JSONObject.toJSONString(map));
		rabbitTemplate.convertAndSend("object", map);
	}
}
