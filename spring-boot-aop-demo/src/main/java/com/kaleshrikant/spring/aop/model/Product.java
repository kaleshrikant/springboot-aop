package com.kaleshrikant.spring.aop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shrikant Kale
 * @Date 14 Oct 2025
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String category;
	private Integer stock;
}
