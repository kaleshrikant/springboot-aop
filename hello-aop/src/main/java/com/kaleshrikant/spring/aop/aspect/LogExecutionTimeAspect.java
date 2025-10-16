package com.kaleshrikant.spring.aop.aspect;

import com.kaleshrikant.spring.aop.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect to measure and log the execution time of methods annotated with @LogExecutionTime.
 *
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Aspect
@Component
public class LogExecutionTimeAspect {

	@Around("@annotation(logExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
		long start = System.currentTimeMillis();
		Object result;

		try {
			result = joinPoint.proceed();
		} finally {
			long duration = System.currentTimeMillis() - start;
			System.out.println("[AOP] " + joinPoint.getSignature() + " executed in " + duration + " ms");
		}
		return result;
	}
}
