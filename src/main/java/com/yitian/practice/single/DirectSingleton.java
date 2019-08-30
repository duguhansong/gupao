package com.yitian.practice.single;

public class DirectSingleton {
	
	private final static DirectSingleton ins = new DirectSingleton();
	private DirectSingleton() {
		if(ins != null)
			throw new UnsupportedOperationException("不支持多实例");
	}
	
	public final static DirectSingleton getIns() {
		return ins;
	}
}