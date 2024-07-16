package com.alfacentauri.spring.springaop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alfacentauri.spring.springaop.ProductService;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/alfacentauri/spring/springaop/test/config.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		int result = productService.multiply(4, 5);
		System.out.println(result);
	}
	
}
