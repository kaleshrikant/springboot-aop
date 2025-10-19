package com.kaleshrikant.spring.progrank;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

	@Pointcut("execution(* com.kaleshrikant.spring.progrank.*.study*())")
	public void beforePointCut() {}

	@Pointcut("execution(public void com.kaleshrikant.spring.progrank.Employee.studySomething())")
	public void afterPointCut() {}

	@Before("beforePointCut()")
	public void wakeUp() {
		System.out.println("Good Morning  🔍 [AOP] Human.wakeUp() triggered");
	}

	@After("afterPointCut()")
	public void sleep() {
		System.out.println("Good Night  🌙 [AOP] Human.sleep() triggered");
	}
}
