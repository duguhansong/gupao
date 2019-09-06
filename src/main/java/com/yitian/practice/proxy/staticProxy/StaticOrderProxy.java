package com.yitian.practice.proxy.staticProxy;

import com.yitian.practice.proxy.IOrderService;
import com.yitian.practice.proxy.OrderServiceImpl;

/**
 * ��̬����
 */
public class StaticOrderProxy implements IOrderService{
	private IOrderService orderService;
	public StaticOrderProxy() {
		orderService = new OrderServiceImpl();
	}
	public void saveOrder() {
		System.out.println("��̬����--���Ȩ��");
		orderService.saveOrder();
	}
}
