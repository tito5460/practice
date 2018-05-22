package com.tito.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/h")
public class HelloController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/hello")
	public ResponseEntity<?> hello() {
		String str = "Hello, this is eureka client.port:" + port;
		return ResponseEntity.ok(str);
	}

}
