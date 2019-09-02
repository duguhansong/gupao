package com.yitian.practice.single;
/**
 * 懒加载
 */
public final class LazySingle {
	private static LazySingle ins = null;
	private LazySingle() {
		if(ins != null)
			throw new UnsupportedOperationException("不支持多实例");
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
