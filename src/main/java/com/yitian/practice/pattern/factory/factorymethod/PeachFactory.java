package com.yitian.practice.pattern.factory.factorymethod;

import com.yitian.practice.pattern.factory.factorymethod.product.Product;
import com.yitian.practice.pattern.factory.factorymethod.product.Peach;

/**
 * ���ӹ���
 */
public class PeachFactory implements Factory {
	private final static PeachFactory ins = new PeachFactory();
	private PeachFactory() {
		if(ins != null)
			throw new UnsupportedOperationException("��֧�ֵĲ���");
	}
	public static PeachFactory getIns() {
		return ins;
	}
	public Product getProduct() {
		return new Peach();
	}

}
