package com.kaleshrikant.spring.progrank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
	}

	@Pointcut("execution(* com.kaleshrikant.spring.progrank.*.study*(..))")
	public void afterReturnPointCut() { }

	@AfterReturning(
			value = "afterReturnPointCut())",
			returning = "numValue"
	)
	public void afterReturning(int numValue) {
		System.out.println("\n 🔍 [AOP] Human.afterReturning() triggered -> numValue = "+numValue);
	}

	@Pointcut("execution(* com.kaleshrikant.spring.progrank.*.doOperation*(..))")
	public void afterThorowingPointCut() {}

	@AfterThrowing(value ="afterThorowingPointCut()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, MyException ex) {
		System.out.println("\n ❌ [AOP] Exception occurred in method: " + joinPoint.getSignature().getName());
		System.out.println("This is my throw Exception : "+ex);
		System.out.println(" 🔴 Exception type: " + ex.getClass().getSimpleName());
		System.out.println(" 🔴 Exception message: " + ex.getMessage());
		System.out.println(" 🔴 Stack trace:");
		ex.printStackTrace();
	}*/

	@Around("execution(int com.kaleshrikant.spring.progrank.Employee.rankOfVideo(int, int))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object [] args = joinPoint.getArgs();

		int originalViews = (int) args[0];
		int originalWatchTime = (int) args[1];

		args[0] = originalViews - 50;
		args[1] = originalWatchTime - 20;

		System.out.println("updated noOfViews = "+args[0]);
		System.out.println("updated watchTime = "+args[1]);

		Object result = null;

		try {
			result = joinPoint.proceed(args);
		} catch(Throwable throwable) {
			System.out.println(" ❌ [AOP] Exception occurred: " + throwable.getMessage());
		}
		System.out.println("\n 🔍 [AOP] Human.aroundAdvice() triggered -> final Rank = "+result);
		return result;
	}

}
