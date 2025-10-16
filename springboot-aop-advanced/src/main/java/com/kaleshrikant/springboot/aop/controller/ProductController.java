package com.kaleshrikant.springboot.aop.controller;

import com.kaleshrikant.springboot.aop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shrikant Kale
 * @Date 16 Oct 2025
 */

@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product/add")
	public String addProduct(@RequestParam(defaultValue = "Laptop") String name) throws InterruptedException {
		return productService.addProduct(name);
	}

}
