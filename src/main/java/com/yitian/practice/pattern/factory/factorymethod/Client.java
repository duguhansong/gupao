package com.yitian.practice.pattern.factory.factorymethod;

import com.yitian.practice.pattern.factory.factorymethod.product.Product;

public class Client {
	
	public static void main(String[] args) {
		Product p  = AppleFactory.getIns().getProduct();
		System.out.println(p.getName());

		p  = GrapeFactory.getIns().getProduct();
		System.out.println(p.getName());
		
		p  = PeachFactory.getIns().getProduct();
		System.out.println(p.getName());		
	}

}
