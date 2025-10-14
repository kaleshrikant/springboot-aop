package com.kaleshrikant.spring.aop.service;

import com.kaleshrikant.spring.aop.annotation.Audit;
import com.kaleshrikant.spring.aop.annotation.LogExecutionTime;
import com.kaleshrikant.spring.aop.annotation.ValidateInput;
import com.kaleshrikant.spring.aop.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@Service
public class ProductService {
	private final ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();
	private final AtomicLong idCounter = new AtomicLong(1);

	@LogExecutionTime(description = "Creating a new product")
	@Audit(action = "CREATE", module = "PRODUCT")
	@ValidateInput
	public Product createProduct(Product product) {
		product.setId(idCounter.getAndIncrement());
		products.put(product.getId(), product);
		return product;
	}

	@LogExecutionTime(description = "Retrieving all products")
	@Audit(action = "READ_ALL", module = "PRODUCT")
	public List<Product> getAllProducts() {
		return new ArrayList<>(products.values());
	}

	@LogExecutionTime(description = "Finding product by ID")
	@Audit(action = "READ", module = "PRODUCT")
	public Product getProductById(Long id) {
		return products.get(id);
	}

	@LogExecutionTime(description = "Updating product")
	@Audit(action = "UPDATE", module = "PRODUCT")
	@ValidateInput
	public Product updateProduct(Long id, Product updatedProduct) {
		Product existing = products.get(id);
		if (existing != null) {
			updatedProduct.setId(id);
			products.put(id, updatedProduct);
			return updatedProduct;
		}
		return null;
	}

	@LogExecutionTime(description = "Deleting product")
	@Audit(action = "DELETE", module = "PRODUCT")
	public boolean deleteProduct(Long id) {
		return products.remove(id) != null;
	}

	@LogExecutionTime(description = "Searching products by category")
	public List<Product> searchByCategory(String category) {
		return products.values().stream()
				.filter(p -> p.getCategory().equalsIgnoreCase(category))
				.toList();
	}
}
