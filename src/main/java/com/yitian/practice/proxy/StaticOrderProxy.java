package com.yitian.practice.proxy;
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
