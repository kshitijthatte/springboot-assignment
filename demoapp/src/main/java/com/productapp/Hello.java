package com.productapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping(path = "hellourl")
	public String hello() {
		return "hello to spring boot on tomcat";
	}

}
