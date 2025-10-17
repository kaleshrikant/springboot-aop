package com.kaleshrikant.springboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Aspect
@Component
public class LoggingAspect {


	@Pointcut("@annotation(com.kaleshrikant.springboot.aop.annotation.TrackExecution)")
	public void trackExecutionPointcut() {}


	@Around("trackExecutionPointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object result = pjp.proceed();
			long duration = System.currentTimeMillis() - start;
			System.out.println("[LOG] " + pjp.getSignature() + " executed in " + duration + " ms");
			return result;
		} catch (Throwable ex) {
			long duration = System.currentTimeMillis() - start;
			System.out.println("[LOG] " + pjp.getSignature() + " threw " + ex.getClass().getSimpleName() + " after " + duration + " ms");
			throw ex;
		}
	}


	@AfterReturning(pointcut = "trackExecutionPointcut()", returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[LOG] Returned: " + ret);
	}


	@AfterThrowing(pointcut = "trackExecutionPointcut()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LOG] Exception: " + ex.getMessage());
	}
}