package com.kaleshrikant.spring.aop;

import com.kaleshrikant.spring.aop.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class HelloAopApplicationTests {

	@Autowired
	private GreetingService greetingService;

	@Test
	void testGreetMethod() {
		String result = greetingService.greet("Test");
		assertThat(result).contains("Hello, Test");
	}
}
