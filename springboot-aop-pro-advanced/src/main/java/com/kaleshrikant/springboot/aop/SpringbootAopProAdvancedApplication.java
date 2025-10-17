package com.kaleshrikant.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class SpringbootAopProAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopProAdvancedApplication.class, args);
	}

}
