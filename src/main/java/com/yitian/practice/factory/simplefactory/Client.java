package com.yitian.practice.factory.simplefactory;

import com.yitian.practice.factory.factorymethod.product.Product;

public class Client {

	public static void main(String[] args) {
		Product p = FarmFactory.getProduct(Type.apple);
		System.out.println(p.getName());
		
		p = FarmFactory.getProduct(Type.grape);
		System.out.println(p.getName());
		
		p = FarmFactory.getProduct(Type.peach);
		System.out.println(p.getName());
	}

}
