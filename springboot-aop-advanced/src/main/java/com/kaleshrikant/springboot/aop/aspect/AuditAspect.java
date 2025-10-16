package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.Audit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Aspect
@Component
public class AuditAspect {

	@Before("@annotation(audit)")
	public void logBefore(JoinPoint joinPoint, Audit audit) {
		System.out.println("[AUDIT] Starting action: " + audit.action() +
				" | Method: " + joinPoint.getSignature().getName());
	}

	@AfterReturning(value = "@annotation(audit)", returning = "result")
	public void logAfter(JoinPoint joinPoint, Audit audit, Object result) {
		System.out.println("[AUDIT] Completed action: " + audit.action() +
				" | Result: " + result);
	}
}
