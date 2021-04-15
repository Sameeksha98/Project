package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.configuration.Configuration;

@RestController
public class FirstResource {

	//@Value("${first-service.message}")
	//private String message;
	@Autowired
	Configuration config;
	
	@GetMapping("/first")
	public String getFirstMessage() {
		return config.getMessage();
	}
}
