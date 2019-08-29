package com.yitian.practice.factory.simplefactory;

import com.yitian.practice.factory.factorymethod.product.Apple;
import com.yitian.practice.factory.factorymethod.product.Grape;
import com.yitian.practice.factory.factorymethod.product.Peach;
import com.yitian.practice.factory.factorymethod.product.Product;

/**
 * 静态工厂方法
 * @author xianjianyi
 *
 */
public class FarmFactory {
	private FarmFactory() {
		throw new UnsupportedOperationException("不支持创建");
	}
	//静态工厂方法
	public static Product getProduct(Type type) {
		switch (type) {
		case apple:
			return new Apple();
		case grape:
			return new Grape();
		case peach:
			return new Peach();
		default:
			throw new UnsupportedOperationException("没有种这水果 ");
		}
	}
}