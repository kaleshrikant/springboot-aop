package com.kaleshrikant.springboot.aop.service;

import com.kaleshrikant.springboot.aop.annotation.Audit;
import com.kaleshrikant.springboot.aop.annotation.LogExecutionTime;
import com.kaleshrikant.springboot.aop.annotation.SecureAction;
import org.springframework.stereotype.Service;

/**
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@Service
public class ProductService {

	@LogExecutionTime
	@Audit(action = "Add New Product")
	@SecureAction(role = "ADMIN")
	public String addProduct(String name) throws InterruptedException {
		Thread.sleep(500); // simulate processing
		return "Product '" + name + "' added successfully.";
	}

}
