package com.kaleshrikant.spring.aop.aspect;

import com.kaleshrikant.spring.aop.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("@annotation(logExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint,
	                               LogExecutionTime logExecutionTime) throws Throwable {

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getMethod().getName();
		String className = signature.getDeclaringType().getSimpleName();

		long startTime = System.currentTimeMillis();

		logger.info("▶️  Starting: {}.{}", className, methodName);
		if (!logExecutionTime.description().isEmpty()) {
			logger.info("   Description: {}", logExecutionTime.description());
		}

		Object result = null;
		try {
			result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			logger.error("❌ Error in {}.{}: {}", className, methodName, e.getMessage());
			throw e;
		} finally {
			long executionTime = System.currentTimeMillis() - startTime;

			if (executionTime > 1000) {
				logger.warn("⚠️  SLOW METHOD: {}.{} took {}ms", className, methodName, executionTime);
			} else {
				logger.info("✅ Completed: {}.{} in {}ms", className, methodName, executionTime);
			}
		}
	}
}
