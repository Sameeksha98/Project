package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstResource {

	@Autowired
	Environment env;
	@GetMapping("/first")
	
	public String getFirstMessage() {
		return "From Port No:"+env.getProperty("local.server.port")+"Hello ";
	}
}
