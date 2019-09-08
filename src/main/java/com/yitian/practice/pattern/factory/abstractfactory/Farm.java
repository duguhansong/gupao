package com.yitian.practice.pattern.factory.abstractfactory;

import com.yitian.practice.pattern.factory.abstractfactory.product.Product;

public interface Farm {
	/**
	 * ÕªÆ»¹û
	 * @return
	 */
	Product getApple();
	/**
	 * ÕªÆÏÌÑ
	 * @return
	 */
	Product getGrape();
	/**
	 * ÕªÌÒ×Ó
	 * @return
	 */
	Product getPeach();
}
