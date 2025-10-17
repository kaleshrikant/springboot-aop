package com.kaleshrikant.springboot.aop.aspect;

import com.kaleshrikant.springboot.aop.annotation.SecureAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Aspect
@Component
public class SecurityAspect {
	@Before("@annotation(secure)")
	public void checkRole(JoinPoint jp, SecureAction secure) {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String currentRole = attrs.getRequest().getHeader("X-Role");
		if (currentRole == null) currentRole = "GUEST"; // default
		if (!currentRole.equals(secure.role())) {
			System.out.println("[SECURITY] Access denied for role: " + currentRole);
			throw new SecurityException("Access denied");
		}
		System.out.println("[SECURITY] Role check passed for " + currentRole);
	}
}
