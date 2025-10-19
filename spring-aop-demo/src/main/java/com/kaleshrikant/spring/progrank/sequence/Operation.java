package com.kaleshrikant.spring.progrank.sequence;

import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * @Date 19 Oct 2025
 */

@Component
public class Operation {
	public void sum(int x, int y) {
		System.out.println("Sum is = "+(x+y));
	}
}
