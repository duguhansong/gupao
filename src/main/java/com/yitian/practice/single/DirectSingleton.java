package com.yitian.practice.single;

import java.io.Serializable;

/**
 * �ŵ�:������JVM����ػ���,�����̰߳�ȫ
 * ȱ�㣺���ױ����䡢�����л���ʵ����
 */
public class DirectSingleton implements Serializable{
	
	private final static DirectSingleton ins = new DirectSingleton();
	private DirectSingleton() {
//		if(ins != null)
//			throw new UnsupportedOperationException("��֧�ֶ�ʵ��");
	}
	
	public final static DirectSingleton getIns() {
		return ins;
	}
}