package com.kaleshrikant.spring.progrank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
public class Human {

/*	@Pointcut("execution(* com.kaleshrikant.spring.progrank.*.study*(..))")
	public void beforePointCut() {}

	//@Pointcut("execution(public void com.kaleshrikant.spring.progrank.Employee.studySomething())")
	@Pointcut("execution(* com.kaleshrikant.spring.progrank.*.study*(..))")
	public void afterPointCut() {}

	@Before("beforePointCut()")
	public void wakeUp(JoinPoint joinPoint) {
		System.out.println("\nGood Morning  🔍 [AOP] Human.wakeUp() triggered");
		//System.out.println("Getting Argument : "+joinPoint.getArgs()[0]);
		System.out.println("Getting Signature : "+joinPoint.getSignature());
		System.out.println("Getting Class Name : "+joinPoint.getTarget().getClass());
		System.out.println("Getting method Name : "+joinPoint.getSignature().getName());
		System.out.println("Getting Proxy Name (CGLIB) : "+joinPoint.getThis().getClass());
	}

	@After("afterPointCut()")
	public void sleep() {
		System.out.println("\nGood Night  🌙 [AOP] Human.sleep() triggered");
	}*/

	@AfterReturning(value = "execution(* com.kaleshrikant.spring.progrank.*.study*(..))", returning = "numValue")
	public void afterReturning(int numValue) {
		System.out.println("\n 🔍 [AOP] Human.afterReturning() triggered -> numValue = "+numValue);
	}

}
