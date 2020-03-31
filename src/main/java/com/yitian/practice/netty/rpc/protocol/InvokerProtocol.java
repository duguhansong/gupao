package com.yitian.practice.netty.rpc.protocol;

import java.io.Serializable;
import java.util.Arrays;

public class InvokerProtocol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5545855469239562984L;
	private String className;//服务名
	private String methodName;//方法名
	private Class<?>[]  prames;//参数列表
	private Object[] values;//实参列表
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class<?>[] getPrames() {
		return prames;
	}
	public void setPrames(Class<?>[] prames) {
		this.prames = prames;
	}
	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
	@Override
	public String toString() {
		return "InvokerProtocol [className=" + className + ", methodName=" + methodName + ", prames="
				+ Arrays.toString(prames) + ", values=" + Arrays.toString(values) + "]";
	}
	
}
