package com.kaleshrikant.springboot.aop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shrikant Kale
 * @Date 17 Oct 2025
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private String name;
	private String email;
}
