package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumingResource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/message")
	public String getMessage() {
		
		String first=restTemplate.getForObject("http://zuul-gate-way/first-service/first", String.class);
		String second=restTemplate.getForObject("http://zuul-gate-way/second-service/second", String.class);
		return first+second;
	}
}
