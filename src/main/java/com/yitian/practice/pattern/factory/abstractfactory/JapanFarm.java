package com.yitian.practice.pattern.factory.abstractfactory;

import com.yitian.practice.pattern.factory.abstractfactory.product.JapanApple;
import com.yitian.practice.pattern.factory.abstractfactory.product.JapanGrape;
import com.yitian.practice.pattern.factory.abstractfactory.product.JapanPeach;
import com.yitian.practice.pattern.factory.abstractfactory.product.Product;

public class JapanFarm implements Farm {

	public Product getApple() {
		return new JapanApple();
	}

	public Product getGrape() {
		return new JapanGrape();
	}

	public Product getPeach() {
		return new JapanPeach();
	}

}
