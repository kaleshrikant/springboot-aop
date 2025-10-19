package com.kaleshrikant.spring.progrank.sequence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shrikant Kale
 * Date 19 Oct 2025
 */

@Configuration
@ComponentScan(basePackages = {
		"com.kaleshrikant.spring.progrank",
		"com.kaleshrikant.spring.progrank.sequence"
})
public class AppConfig {
}
