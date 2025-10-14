package com.kaleshrikant.spring.aop.aspect;

import com.kaleshrikant.spring.aop.annotation.ValidateInput;
import com.kaleshrikant.spring.aop.exception.ValidationException;
import com.kaleshrikant.spring.aop.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@Aspect
@Component
public class ValidationAspect {
	private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

	@Before("@annotation(validateInput)")
	public void validateInput(JoinPoint joinPoint, ValidateInput validateInput) {
		Object[] args = joinPoint.getArgs();

		logger.debug("🔍 Validating input for method: {}", joinPoint.getSignature().getName());

		for (Object arg : args) {
			if (arg instanceof Product product) {
				validateProduct(product);
			}
		}

		logger.debug("✅ Validation passed");
	}

	private void validateProduct(Product product) {
		if (product.getName() == null || product.getName().trim().isEmpty()) {
			throw new ValidationException("Product name cannot be empty");
		}

		if (product.getPrice() == null || product.getPrice() <= 0) {
			throw new ValidationException("Product price must be greater than 0");
		}

		if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
			throw new ValidationException("Product category cannot be empty");
		}
	}
}
