package com.yitian.practice.single;
/**
 * 延迟加载:
 * 优点：使用时才加载
 * 缺点：为解决实例化的线程安全问题,在初始化时采用了爽重检测机制,有有影响效率
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
