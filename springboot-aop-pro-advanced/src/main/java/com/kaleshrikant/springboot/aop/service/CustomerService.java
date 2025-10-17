package com.kaleshrikant.springboot.aop.service;

import com.kaleshrikant.springboot.aop.annotation.Audit;
import com.kaleshrikant.springboot.aop.annotation.SecureAction;
import com.kaleshrikant.springboot.aop.annotation.TrackExecution;
import com.kaleshrikant.springboot.aop.annotation.TransactionalBoundary;
import com.kaleshrikant.springboot.aop.model.Customer;
import org.springframework.stereotype.Service;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Service
public class CustomerService {
	@TrackExecution
	@Audit(action = "Add New Customer")
	@SecureAction(role = "ADMIN")
	@TransactionalBoundary
	public Customer addCustomer(String name, String email) throws InterruptedException {
// simple validation
		if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
		if (email == null || !email.contains("@")) throw new IllegalArgumentException("Invalid email format");


// simulate processing and DB save
		Thread.sleep(200);
		Customer c = new Customer(name, email);
// imagine saving to DB here
		return c;
	}


	@TrackExecution
	@Audit(action = "Find Customer")
	@SecureAction(role = "USER")
	public Customer findCustomer(String name) throws InterruptedException {
		Thread.sleep(80);
		return new Customer(name, name.toLowerCase().replaceAll("\\s+", "") + "@example.com");
	}
}
