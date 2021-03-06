package com.yitian.practice.pattern.factory.abstractfactory;

import com.yitian.practice.pattern.factory.abstractfactory.product.Product;
import com.yitian.practice.pattern.factory.abstractfactory.product.ThailandApple;
import com.yitian.practice.pattern.factory.abstractfactory.product.ThailandGrape;
import com.yitian.practice.pattern.factory.abstractfactory.product.ThailandPeach;

public class ThailandFarm implements Farm{

	public Product getApple() {
		return new ThailandApple();
	}

	public Product getGrape() {
		return new ThailandGrape();
	}

	public Product getPeach() {
		return new ThailandPeach();
	}

}
