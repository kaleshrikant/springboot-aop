package com.kaleshrikant.spring.progrank;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
public class Human {

	@Before("execution(* com.kaleshrikant.spring.progrank.*.study*())")
	public void wakeUp() {
		System.out.println("Good Morning  🔍 [AOP] Human.wakeUp() triggered");
	}

	@After("execution(public void com.kaleshrikant.spring.progrank.Employee.study())")
	public void sleep() {
		System.out.println("Good Night  🌙 [AOP] Human.sleep() triggered");
	}
}
