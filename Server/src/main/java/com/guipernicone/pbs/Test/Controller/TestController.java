package com.guipernicone.pbs.Test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping
	public String hello_world() {
		return "Hello World!";
	}
	
	@GetMapping("auth")
	public String auth_test() {
		return "Acess Granted";
	}
}
