package com.kaleshrikant.spring.progrank;

import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

@Component
public class Student {
	public int studyAnything(int start, int end) {
		System.out.println("I am in school and studying right now..! from "+start+" to "+end);
		return 333;
	}
}
