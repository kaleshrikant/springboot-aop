package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Aspect
@Component
public class LogExecutionTimeAspect {

	@Around("@annotation(logExecutionTime)")
	public Object mesureExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) {
		Object result;
		long start,duration = 0;

		try {
			start  = System.currentTimeMillis();
			result = joinPoint.proceed();
			duration = System.currentTimeMillis() - start;
		} catch(Throwable e) {
			throw new RuntimeException(e);
		}
		finally {
			System.out.println("[AOP] " + joinPoint.getSignature() + " executed in " + duration + " ms");
		}
		return result;
	}
}
