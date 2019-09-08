package com.yitian.practice.pattern.factory.abstractfactory;

import com.yitian.practice.pattern.factory.abstractfactory.product.Product;

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
