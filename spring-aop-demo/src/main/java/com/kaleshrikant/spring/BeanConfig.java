package com.kaleshrikant.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Shrikant Kale
 * Date 18 Oct 2025
 */

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan(basePackages = "com.kaleshrikant.spring")
public class BeanConfig {

}
