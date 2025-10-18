package com.kaleshrikant.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 *   @author Shrikant Kale
 *   Date 18 Oct 2025
 */

@Component
public class Main {
    public static void main( String[] args ) {

	    ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

	    ShoppingCart shoppingCartBean = context.getBean(ShoppingCart.class);

		shoppingCartBean.checkout("CANCELED");
    }
}
