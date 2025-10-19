package com.kaleshrikant.spring.progrank.sequence;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 19 Oct 2025
 */

@Order(2)
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Aspect1 {
	@Before("execution(* *(..))")
	public void advice() {
		System.out.println("Advice -- Aspect1");
	}
}
