package com.kaleshrikant.spring.progrank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		Student student = context.getBean("student",Student.class);

		int returnedValue = student.studyAnything(9, 6);
		System.out.println(" 🔍 [MAIN] Returned Value : "+returnedValue);

		student.doOperation();
		*/

		Employee employee = context.getBean("employee", Employee.class);
			// employee.studySomething();
		int rank = employee.rankOfVideo(100, 65);
		System.out.println("Video Ranking Poostion : "+rank);
	}
}
