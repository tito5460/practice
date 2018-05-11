package com.example.rabbit.produce.sender;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		rabbitTemplate.setConfirmCallback(this);
		String str = "CallBack Sender";
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		System.out.println("CallBackSender UUID: " + correlationData.getId());
		//rabbitTemplate.convertAndSend("hello", (Object) str, correlationData);
		rabbitTemplate.convertAndSend("fanoutExchange", "", str, correlationData);
	}

	/**
	 * 消息一发送到rabbit服务器就触发回调，不管consumer有没有接收到消息。
	 * 广播模式，也只执行一次回调，原因上一句。
	 * 也就是说，它仅仅代表消息发送成功。
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("callback confirm: " + correlationData.getId() + ", " + ack + ", " + cause);
	}
}