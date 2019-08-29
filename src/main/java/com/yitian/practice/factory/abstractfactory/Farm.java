package com.yitian.practice.factory.abstractfactory;

import com.yitian.practice.factory.abstractfactory.product.Product;

public interface Farm {
	/**
	 * ժƻ��
	 * @return
	 */
	Product getApple();
	/**
	 * ժ����
	 * @return
	 */
	Product getGrape();
	/**
	 * ժ����
	 * @return
	 */
	Product getPeach();
}
