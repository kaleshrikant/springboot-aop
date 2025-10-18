package com.kaleshrikant.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 18 Oct 2025
 */

@Aspect
@Component
public class AuthonticationAspect {

	@Pointcut("within(com.kaleshrikant..*)")
	public void authinticatingPointCut() {

	}

	@Pointcut("within(com.kaleshrikant.spring.ShoppingCart.*)")
	public void authorizationPointCut() {

	}

	@Before("authinticatingPointCut() && authorizationPointCut()")
	public void authonticate() {
		System.out.println("Authenticating the Request");
	}
}
