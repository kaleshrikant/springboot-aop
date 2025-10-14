package com.kaleshrikant.spring.aop.controller;

import com.kaleshrikant.spring.aop.exception.ValidationException;
import com.kaleshrikant.spring.aop.model.Product;
import com.kaleshrikant.spring.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		try {
			Product created = productService.createProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().body(
					new ErrorResponse("Validation Error", e.getMessage())
			);
		}
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse("Not Found", "Product not found with id: " + id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		try {
			Product updated = productService.updateProduct(id, product);
			if (updated != null) {
				return ResponseEntity.ok(updated);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse("Not Found", "Product not found with id: " + id));
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().body(
					new ErrorResponse("Validation Error", e.getMessage())
			);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		boolean deleted = productService.deleteProduct(id);
		if (deleted) {
			return ResponseEntity.ok(new SuccessResponse("Product deleted successfully"));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse("Not Found", "Product not found with id: " + id));
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchByCategory(@RequestParam String category) {
		List<Product> products = productService.searchByCategory(category);
		return ResponseEntity.ok(products);
	}

	record ErrorResponse(String error, String message) {}
	record SuccessResponse(String message) {}
}
