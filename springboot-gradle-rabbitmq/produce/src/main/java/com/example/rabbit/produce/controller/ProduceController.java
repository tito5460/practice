package com.example.rabbit.produce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rabbit.produce.sender.CallBackSender;
import com.example.rabbit.produce.sender.FanoutSender;
import com.example.rabbit.produce.sender.HelloSender;
import com.example.rabbit.produce.sender.MuchSender1;
import com.example.rabbit.produce.sender.MuchSender2;
import com.example.rabbit.produce.sender.ObjectSender;
import com.example.rabbit.produce.sender.TopicSender;

@Controller
@RequestMapping("/produce")
public class ProduceController {

	@Autowired
	private HelloSender helloSender;
	@Autowired
	private ObjectSender objectSender;
	@Autowired
	private MuchSender1 muchSender1;
	@Autowired
	private MuchSender2 muchSender2;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private CallBackSender callBackSender;

	@RequestMapping("/sendHello")
	public ResponseEntity<?> sendHello(){
		helloSender.send();
		return ResponseEntity.ok("sendHello");
	}
	
	@RequestMapping("/sendObject")
	public ResponseEntity<?> sendObject(){
		Map<String, String> map = new HashMap<>();
		map.put("id", "001");
		map.put("name", "Tom");
		objectSender.send(map);
		return ResponseEntity.ok("sendObject");
	}
	
	@RequestMapping("/sendOneToMany")
	public ResponseEntity<?> sendOneToMany(){
		for (int i = 0; i < 20; i++) {
			muchSender1.send("" + i);
		}
		return ResponseEntity.ok("sendOneToMany");
	}
	
	@RequestMapping("/sendManyToMany")
	public ResponseEntity<?> sendManyToMany(){
		for (int i = 0; i < 20; i++) {
			String str = "" + i;
			muchSender1.send(str);
			muchSender2.send(str);
		}
		return ResponseEntity.ok("sendManyToMany");
	}
	
	@RequestMapping("/sendTopic1")
	public ResponseEntity<?> sendTopic1(){
		topicSender.send1();
		return ResponseEntity.ok("sendTopic1");
	}
	
	@RequestMapping("/sendTopic2")
	public ResponseEntity<?> sendTopic2(){
		topicSender.send2();
		return ResponseEntity.ok("sendTopic2");
	}
	
	@RequestMapping("/sendTopic3")
	public ResponseEntity<?> sendTopic3(){
		topicSender.send3();
		return ResponseEntity.ok("sendTopic3");
	}
	
	@RequestMapping("/sendTopic4")
	public ResponseEntity<?> sendTopic4(){
		topicSender.send4();
		return ResponseEntity.ok("sendTopic4");
	}
	
	@RequestMapping("/sendFanout")
	public ResponseEntity<?> sendFanout(){
		fanoutSender.send();
		return ResponseEntity.ok("sendFanout");
	}
	
	@RequestMapping("/sendCallBack")
	public ResponseEntity<?> sendCallBack(){
		callBackSender.send();
		return ResponseEntity.ok("sendCallBack");
	}
}
