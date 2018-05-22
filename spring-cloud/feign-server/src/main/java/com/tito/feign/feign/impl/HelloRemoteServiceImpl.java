package com.tito.feign.feign.impl;

import org.springframework.stereotype.Component;

import com.tito.feign.feign.HelloRemoteService;

@Component
public class HelloRemoteServiceImpl implements HelloRemoteService {

	@Override
	public String hello(String param1) {
		return "Hello Server Not Found!";
	}

}
