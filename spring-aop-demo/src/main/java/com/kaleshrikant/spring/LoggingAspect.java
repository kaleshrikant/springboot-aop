package com.kaleshrikant.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * Date 18 Oct 2025
 */

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.kaleshrikant.spring.ShoppingCart.checkout(..))")
	public void beforeLogger() {
		System.out.println("🔍 [AOP] LoggingAspect Before Logger");
	}

	@After("execution(* *.*.checkout(..))")
	public void afterLogger() {
		System.out.println("🔍 [AOP] LoggingAspect After Logger");
	}
}
