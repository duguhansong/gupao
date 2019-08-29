package com.yitian.practice.factory.abstractfactory;

import com.yitian.practice.factory.abstractfactory.product.Product;

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
