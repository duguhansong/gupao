package com.yitian.practice.factory.abstractfactory;

import com.yitian.practice.factory.abstractfactory.product.ChinaApple;
import com.yitian.practice.factory.abstractfactory.product.ChinaGrape;
import com.yitian.practice.factory.abstractfactory.product.ChinaPeach;
import com.yitian.practice.factory.abstractfactory.product.Product;

public class ChinaFarm implements Farm {

	public Product getApple() {
		return new ChinaApple();
	}

	public Product getGrape() {
		return new ChinaGrape();
	}

	public Product getPeach() {
		return new ChinaPeach();
	}

}
