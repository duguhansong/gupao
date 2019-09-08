package com.yitian.practice.pattern.factory.factorymethod;

import com.yitian.practice.pattern.factory.factorymethod.product.Apple;

/**
 * ƻ������
 */
public class AppleFactory implements Factory {
	private final static AppleFactory ins = new AppleFactory();
	private AppleFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("��֧�ִ˲���");
	}
	public static AppleFactory getIns() {
		return ins;
	}
	public Apple getProduct() {
		return new Apple();
	}

}
