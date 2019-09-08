package com.yitian.practice.pattern.factory.simplefactory;

import com.yitian.practice.pattern.factory.factorymethod.product.Product;
import com.yitian.practice.pattern.factory.factorymethod.product.Apple;
import com.yitian.practice.pattern.factory.factorymethod.product.Grape;
import com.yitian.practice.pattern.factory.factorymethod.product.Peach;

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