package com.yitian.practice.factory.factorymethod;

import com.yitian.practice.factory.factorymethod.product.Peach;
import com.yitian.practice.factory.factorymethod.product.Product;

/**
 * 桃子工厂
 */
public class PeachFactory implements Factory {
	private final static PeachFactory ins = new PeachFactory();
	private PeachFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("不支持的操作");
	}
	public static PeachFactory getIns() {
		return ins;
	}
	public Product getProduct() {
		return new Peach();
	}

}
