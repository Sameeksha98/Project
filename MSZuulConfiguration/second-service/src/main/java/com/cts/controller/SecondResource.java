package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.configuration.Configuration;

@RestController
public class SecondResource {

	@Autowired
	Configuration config;
	
	@GetMapping("/second")
	public String getSecondMessage() {
		return config.getMessage();
	}
}
