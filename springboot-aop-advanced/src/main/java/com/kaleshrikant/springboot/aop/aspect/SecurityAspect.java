package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.SecureAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Aspect
@Component
public class SecurityAspect {
	private final String currentUserRole = "ADMIN"; // Simulated current user role

	@Before("@annotation(secureAction)")
	public void checkAccess(JoinPoint joinPoint, SecureAction secureAction) {
		String requiredRole = secureAction.role();
		if (!currentUserRole.equals(requiredRole)) {
			throw new SecurityException("[SECURITY] Access denied for role: " + currentUserRole);
		}
		System.out.println("[SECURITY] Access granted for role: " + currentUserRole);
	}
}
