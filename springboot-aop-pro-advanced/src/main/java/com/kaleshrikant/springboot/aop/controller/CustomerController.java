package com.kaleshrikant.springboot.aop.controller;

import com.kaleshrikant.springboot.aop.model.Customer;
import com.kaleshrikant.springboot.aop.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@RestController
public class CustomerController {
	private final CustomerService customerService;


	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public Customer add(@RequestBody Customer customer) throws InterruptedException {
		return customerService.addCustomer(customer.getName(), customer.getEmail());
	}

	@GetMapping("/{name}")
	public ResponseEntity<Customer> find(@PathVariable String name) throws InterruptedException {
		Customer customer = customerService.findCustomer(name);
		if (customer == null) {
			System.out.println("[INFO] Customer not found: " + name);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(customer);
	}
}
