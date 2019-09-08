package com.yitian.practice.pattern.proxy;

/**
 * JDK代理模式实现
 */
public class OrderServiceImpl implements IOrderService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void saveOrder() {
		System.out.println("保存订单");
	}


}
