package com.yitian.practice.single;
/**
 * ������
 */
public final class LazySingle {
	private static LazySingle ins = null;
	private LazySingle() {
		if(ins != null)
			throw new UnsupportedOperationException("��֧�ֶ�ʵ��");
	}
	public static LazySingle getIns() {
		if(ins == null) {
			synchronized (LazySingle.class) {
				if(ins == null) {
					ins = new LazySingle();
				}
			}
		}
		return ins;
	}
}
