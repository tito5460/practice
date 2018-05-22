package com.tito.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/ribbon")
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	//判断controller是单例还是多例
	//正常情况下，不推荐controller里使用属性
	private int count = 0;

	@RequestMapping("/hi")
	public ResponseEntity<?> hello() {
		// IP使用Eureka上的服务名字
		String msg = restTemplate.getForObject("http://HELLO-1/h/hello", String.class);
		return ResponseEntity.ok(count++ + ", " + msg);
	}
}
