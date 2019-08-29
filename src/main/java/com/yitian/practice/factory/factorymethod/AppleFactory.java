package com.yitian.practice.factory.factorymethod;

import com.yitian.practice.factory.factorymethod.product.Apple;

/**
 * 苹果工厂
 */
public class AppleFactory implements Factory {
	private final static AppleFactory ins = new AppleFactory();
	private AppleFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("不支持此操作");
	}
	public static AppleFactory getIns() {
		return ins;
	}
	public Apple getProduct() {
		return new Apple();
	}

}
