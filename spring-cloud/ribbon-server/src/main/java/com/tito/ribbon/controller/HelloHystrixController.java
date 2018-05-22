package com.tito.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@RequestMapping("/ribbon")
public class HelloHystrixController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hi2")
	// 回调fn的参数要和该fn的参数一致
	@HystrixCommand(fallbackMethod = "helloError")
	public ResponseEntity<?> hello(String param1) {
		String msg = restTemplate.getForObject("http://HELLO-1/h/hello", String.class);
		return ResponseEntity.ok(msg + ", " + param1);
	}

	public ResponseEntity<?> helloError(String param1) {
		return ResponseEntity.ok("hello server not found!" + ", " + param1);
	}
}
