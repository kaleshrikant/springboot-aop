package com.kaleshrikant.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootAopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopDemoApplication.class, args);
		System.out.println("\n=================================");
		System.out.println("🚀 Application Started Successfully!");
		System.out.println("📝 API Documentation: http://localhost:8080/api/products");
		System.out.println("=================================\n");
	}

}
