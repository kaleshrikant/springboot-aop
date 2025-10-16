package com.kaleshrikant.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication
public class SpringbootAopAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopAdvancedApplication.class, args);
	}

}
