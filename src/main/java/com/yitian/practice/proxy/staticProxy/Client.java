package com.yitian.practice.proxy.staticProxy;

public class Client {

	public static void main(String[] args) {
		StaticOrderProxy orderService = new StaticOrderProxy();
		orderService.saveOrder();
	}
}
