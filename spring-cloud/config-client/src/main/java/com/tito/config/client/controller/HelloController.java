package com.tito.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope//要想刷新spring-cloud-config，必须加这个注解
@Controller
@RequestMapping("/h")
public class HelloController {

	@Value("${fieldp}")
	private String fieldp;

	@RequestMapping("/hello")
	public ResponseEntity<?> hello() {
		String str = "Hello, this is config client. field-name: fieldp, field-value: " + fieldp;
		return ResponseEntity.ok(str);
	}

}
