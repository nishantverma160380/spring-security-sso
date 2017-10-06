package org.nhs.springsecurityssoui4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/hello")
public class HelloController {
	@GetMapping
	public String hello(){
		return "Hello REST";
	}
}
