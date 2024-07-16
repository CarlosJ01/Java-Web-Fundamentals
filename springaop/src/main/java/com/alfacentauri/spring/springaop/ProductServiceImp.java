package com.alfacentauri.spring.springaop;

public class ProductServiceImp implements ProductService {

	@Override
	public int multiply(int num1, int num2) {
		System.out.println("Multiply");
		return num1 * num2;
	}

}
