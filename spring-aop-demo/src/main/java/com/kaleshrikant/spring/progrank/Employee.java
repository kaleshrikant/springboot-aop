package com.kaleshrikant.spring.progrank;

import org.springframework.stereotype.Component;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

@Component
public class Employee {
	public void studySomething() {
		System.out.println("I am Exploring..!");
	}

	public int rankOfVideo(int noOfViews, int watchTime) {
		System.out.println("\n 🔍 [Employee] rankOfVideo("+noOfViews+","+watchTime+")");
		return (noOfViews * watchTime) - (noOfViews + watchTime);
	}
}
