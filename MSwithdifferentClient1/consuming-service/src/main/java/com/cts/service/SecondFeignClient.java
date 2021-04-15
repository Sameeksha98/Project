package com.cts.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="http://localhost:9092",name="secondClient")
public interface SecondFeignClient {

	@GetMapping("/second")
	String showSecondMessage();
	
}
