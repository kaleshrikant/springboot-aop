package com.kaleshrikant.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * Date 18 Oct 2025
 */

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.kaleshrikant.spring.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint joinPoint) {
		// System.out.println(joinPoint.getSignature());
		System.out.println(joinPoint.getArgs()[0].toString());
		System.out.println("🔍 [AOP] LoggingAspect Before Logger");
	}

	@After("execution(* *.*.checkout(..))")
	public void afterLogger() {
		System.out.println("🔍 [AOP] LoggingAspect After Logger");
	}

	@Pointcut("execution(* *.*.quantity(..))")
	public void afterReturningPointCut() {}

	@AfterReturning(pointcut = "afterReturningPointCut()", returning="retVal")
	public void afterReturning(String retVal) {
		System.out.println("After Returning : "+retVal);
	}
}
