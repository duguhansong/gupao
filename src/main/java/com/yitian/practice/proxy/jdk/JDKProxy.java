package com.yitian.practice.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {

	private Object ins;
	
	public JDKProxy(Object ins) {
		this.ins = ins;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行" +method.getName() + "方法");
		return method.invoke(this.ins, args);
	}
}
