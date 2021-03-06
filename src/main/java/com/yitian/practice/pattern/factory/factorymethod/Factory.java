package com.yitian.practice.pattern.factory.factorymethod;

import com.yitian.practice.pattern.factory.factorymethod.product.Product;;

/**
 * 抽象工厂
 */
public interface Factory {
	/**
	 * 创建产品
	 * @return
	 */
	Product getProduct();
}
