package com.yitian.practice.factory.factorymethod;

import com.yitian.practice.factory.factorymethod.product.Grape;
import com.yitian.practice.factory.factorymethod.product.Product;

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
