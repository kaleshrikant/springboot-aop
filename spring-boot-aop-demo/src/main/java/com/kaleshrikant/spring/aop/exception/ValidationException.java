package com.kaleshrikant.spring.aop.exception;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

public class ValidationException  extends RuntimeException{
	public ValidationException(String message) {
		super(message);
	}
}
