package com.kaleshrikant.spring.aop.service;

import com.kaleshrikant.spring.aop.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

/**
 * Simple service class to demonstrate AOP.
 *
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Service
public class GreetingService {

	@LogExecutionTime
	public String greet(String name) {
		simulateWork();
		return "Hello, "+name+ " 👋";
	}

	private void simulateWork() {
		try {
			Thread.sleep(250); // simulate some processing delay
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
