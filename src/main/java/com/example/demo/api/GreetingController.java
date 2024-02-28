package com.example.demo.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	// demo env variable 
    @Value("${user}")
	private String user;

	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", required=false) String name ) {
		
		// use env var if no name is supplied
		String input = name != null ?  name : user; 
		return new Greeting(counter.incrementAndGet(), String.format("Hello, %s!", input));
	}
}