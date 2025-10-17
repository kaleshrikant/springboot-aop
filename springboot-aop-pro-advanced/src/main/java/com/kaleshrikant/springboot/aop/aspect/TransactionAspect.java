package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.TransactionalBoundary;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Aspect
@Component
public class TransactionAspect {
	@Around("@annotation(tx)")
	public Object aroundTransaction(ProceedingJoinPoint pjp, TransactionalBoundary tx) throws Throwable {
		System.out.println("[TX] Beginning transaction...");
		try {
			Object result = pjp.proceed();
			System.out.println("[TX] Transaction committed.");
			return result;
		} catch(Throwable ex) {
			System.out.println("[TX] Transaction rolled back due to: " + ex.getClass().getSimpleName());
			throw ex;
		} finally {
			System.out.println("[TX] Transaction scope ended.");
		}
	}
}