package com.yitian.practice.pattern.factory.factorymethod;

import com.yitian.practice.pattern.factory.factorymethod.product.Product;
import com.yitian.practice.pattern.factory.factorymethod.product.Grape;

/**
 * ���ѹ���
 *
 */
public class GrapeFactory implements Factory {
	private final static GrapeFactory ins = new GrapeFactory();
	private GrapeFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("��֧�ִ˲���");
	}
	public static GrapeFactory getIns() {
		return ins;
	}
	public Product getProduct() {
		return new Grape();
	}

}
