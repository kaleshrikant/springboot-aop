package com.kaleshrikant.spring.aop.controller;

import com.kaleshrikant.spring.aop.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST controller that uses the GreetingService.
 *
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@RestController
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue = "Shrikant") String name) {
		return greetingService.greet(name);
	}
}
