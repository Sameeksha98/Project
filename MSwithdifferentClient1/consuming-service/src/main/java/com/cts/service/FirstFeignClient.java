package com.cts.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="http://localhost:9091",name="firstClient")
public interface FirstFeignClient {

	
	@GetMapping("/first")
	String showFirstMessage();
}
