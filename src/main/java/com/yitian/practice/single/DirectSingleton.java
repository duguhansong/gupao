package com.yitian.practice.single;

import java.io.Serializable;

/**
 * 优点:利用了JVM类加载机制,天生线程安全
 * 缺点：容易被反射、反序列化多实例化
 */
public class DirectSingleton implements Serializable{
	
	private final static DirectSingleton ins = new DirectSingleton();
	private DirectSingleton() {
//		if(ins != null)
//			throw new UnsupportedOperationException("不支持多实例");
	}
	
	public final static DirectSingleton getIns() {
		return ins;
	}
}