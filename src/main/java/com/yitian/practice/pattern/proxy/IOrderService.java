package com.yitian.practice.pattern.proxy;

import java.io.Serializable;

public interface IOrderService extends Serializable {
	
	void saveOrder();
}
