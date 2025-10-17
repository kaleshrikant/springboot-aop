package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.Audit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Aspect
@Component
public class AuditAspect {


	@Before("@annotation(audit)")
	public void beforeAudit(JoinPoint jp, Audit audit) {
		System.out.println("[AUDIT] Action: " + audit.action() + " started. Method: " + jp.getSignature().getName());
	}


	@AfterReturning(value = "@annotation(audit)", returning = "ret")
	public void afterAudit(JoinPoint jp, Audit audit, Object ret) {
		System.out.println("[AUDIT] Action: " + audit.action() + " completed. Result: " + ret);
	}


	@After("@annotation(audit)")
	public void afterAlways(JoinPoint jp, Audit audit) {
// runs regardless of outcome
		System.out.println("[AUDIT] (Finally) Action: " + audit.action());
	}
}
