package com.kaleshrikant.spring.progrank.sequence;;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Shrikant Kale
 * @Date 19 Oct 2025
 */

public class Main {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

			Operation operation = context.getBean(Operation.class);
				operation.sum(10,20);
	}
}
