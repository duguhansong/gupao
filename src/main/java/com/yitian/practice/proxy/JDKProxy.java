package com.yitian.practice.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object ins;
	
	public JDKProxy(Object ins) {
		this.ins = ins;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("动态代理检查权限...");
		return method.invoke(this.ins, args);
	}
}
