package com.fastcampus.ch2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiCall {
	@GetMapping("/restApi")
	public String restCall() {
		String data = "hello rest-api"; 
		return data;
	}
}
