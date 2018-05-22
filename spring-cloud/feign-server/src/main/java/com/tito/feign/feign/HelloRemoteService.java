package com.tito.feign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tito.feign.feign.impl.HelloRemoteServiceImpl;

@FeignClient(value = "HELLO-1",fallback = HelloRemoteServiceImpl.class)
public interface HelloRemoteService {

	@RequestMapping(value = "/h/hello",method = RequestMethod.POST)
    String hello(@RequestParam(value = "param1") String param1);
}
