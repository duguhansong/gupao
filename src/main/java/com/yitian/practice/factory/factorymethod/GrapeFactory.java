package com.yitian.practice.factory.factorymethod;

import com.yitian.practice.factory.factorymethod.product.Grape;
import com.yitian.practice.factory.factorymethod.product.Product;

/**
 * 葡萄工厂
 *
 */
public class GrapeFactory implements Factory {
	private final static GrapeFactory ins = new GrapeFactory();
	private GrapeFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("不支持此操作");
	}
	public static GrapeFactory getIns() {
		return ins;
	}
	public Product getProduct() {
		return new Grape();
	}

}
