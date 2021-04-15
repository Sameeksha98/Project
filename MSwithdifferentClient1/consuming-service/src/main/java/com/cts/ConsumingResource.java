package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cts.service.FirstFeignClient;
import com.cts.service.SecondFeignClient;

@RestController
@EnableFeignClients(basePackages = "com.cts.service")
public class ConsumingResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FirstFeignClient firstClient;
	
	@Autowired
	SecondFeignClient secondClient;
	
	@Autowired
	WebClient.Builder builder;
	
	@GetMapping("/message")
	public String getMessage() {
	//RestTemplate restTemplate=new RestTemplate();
	//String first=restTemplate.getForObject("http://localhost:9091/first", String.class);
	//String second=restTemplate.getForObject("http://localhost:9092/second", String.class);
	
	//String first=restTemplate.getForObject("http://first-service/first", String.class);
	//String second=restTemplate.getForObject("http://second-service/second", String.class);
		
		//Using fiegnclient
		//String first=firstClient.showFirstMessage();
		//String second=secondClient.showSecondMessage();
		
		//using Webclient
		
		String first=builder.build()
				.get()
				.uri("http://localhost:9091/first")
				.retrieve()
				.bodyToMono(String.class)
				.block();
		String second=builder.build()
				.get()
				.uri("http://localhost:9092/second")
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
	String message=first+second;
	return message;
	}
}
