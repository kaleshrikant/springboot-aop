package com.kaleshrikant.spring.aop.aspect;

import com.kaleshrikant.spring.aop.annotation.Audit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@Aspect
@Component
public class AuditAspect {
	private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@AfterReturning(pointcut = "@annotation(audit)", returning = "result")
	public void auditSuccess(JoinPoint joinPoint, Audit audit, Object result) {
		logger.info("📋 ========== AUDIT LOG ==========");
		logger.info("   Timestamp: {}", LocalDateTime.now().format(formatter));
		logger.info("   Module: {}", audit.module());
		logger.info("   Action: {}", audit.action());
		logger.info("   Method: {}", joinPoint.getSignature().toShortString());
		logger.info("   Arguments: {}", Arrays.toString(joinPoint.getArgs()));
		logger.info("   Result: {}", result);
		logger.info("   Status: ✅ SUCCESS");
		logger.info("=================================");
	}

	@AfterThrowing(pointcut = "@annotation(audit)", throwing = "error")
	public void auditFailure(JoinPoint joinPoint, Audit audit, Throwable error) {
		logger.error("📋 ========== AUDIT LOG ==========");
		logger.error("   Timestamp: {}", LocalDateTime.now().format(formatter));
		logger.error("   Module: {}", audit.module());
		logger.error("   Action: {}", audit.action());
		logger.error("   Method: {}", joinPoint.getSignature().toShortString());
		logger.error("   Arguments: {}", Arrays.toString(joinPoint.getArgs()));
		logger.error("   Status: ❌ FAILURE");
		logger.error("   Error: {}", error.getMessage());
		logger.error("=================================");
	}
}
