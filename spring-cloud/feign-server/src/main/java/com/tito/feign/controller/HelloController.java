package com.tito.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tito.feign.feign.HelloRemoteService;

@Controller
@RequestMapping("/feign")
public class HelloController {

	@Autowired
	private HelloRemoteService helloRemoteService;

	@RequestMapping("/hi")
	public ResponseEntity<?> hello() {
		String msg = helloRemoteService.hello("abc");
		return ResponseEntity.ok(msg);
	}
}
