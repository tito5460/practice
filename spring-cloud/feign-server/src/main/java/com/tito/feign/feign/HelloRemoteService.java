package com.tito.feign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HELLO-1")
public interface HelloRemoteService {

	@RequestMapping(value = "/h/hello",method = RequestMethod.POST)
    String hello(@RequestParam(value = "param1") String param1);
}
